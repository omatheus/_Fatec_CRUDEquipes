package br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpamodelo.hpabaseadmin;


import br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpaauxilio.HPASaida;
import br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpaentidades.HPAProjeto;
import br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpaentidades.HPAUsuario;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.TreeMap;


/*
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

public class HPABaseNucleo implements HPABaseInterface
{
  
  
  private Connection hpa_linha_conexao;
  
  
  private Statement hpa_statement_interno;
  
  
  private ResultSet hpa_resultset_interno;
  
  
  @Override
  public void hpaInicilizar ()
  {
    
    
    try
    {
      HPASaida.hpaImprimir ("Inicializando processo de instancia atraves de Driver.");
      Class.forName ("org.firebirdsql.jdbc.FBDriver");
    } catch
        (Exception hpa_excecao)
    {
      hpa_excecao.printStackTrace ();
    }
  }
  
  
  @Override
  public void hpaConectar ()
  {
    
    
    try
    {
      HPASaida.hpaImprimir ("Realizando conexao primaria.");
      this.hpa_linha_conexao = DriverManager.getConnection
          (HPABaseRecorrencia.hpa_conexao_tradicional,
              HPABaseRecorrencia.hpa_conexao_por_usuario,
              HPABaseRecorrencia.hpa_segredo);
      
      this.hpa_linha_conexao.setAutoCommit (false);
      this.hpa_linha_conexao.setHoldability ((int) 64);
      
    } catch
        (Exception hpa_excecao)
    {
      hpa_excecao.printStackTrace ();
    }
    
  }
  
  
  @Override
  public void hpaFinalizar ()
  {
    
    
    try
    {
      HPASaida.hpaImprimir ("Encerrando conexao e desalocando recursos");
      if ( this.hpa_linha_conexao != null && ! this.hpa_linha_conexao.isClosed () )
      {
        this.hpa_linha_conexao.close ();
        this.hpa_linha_conexao = null;
      }
      
    } catch
        (Exception hpa_excecao)
    {
      hpa_excecao.printStackTrace ();
    }
    
  }
  
  
  @Override
  public <U> U hpaProcessarImagem (final String hpa_chamada)
  {
    
    
    try
    {
      
      HPASaida.hpaImprimir ("Bloco hpaProcessarImagem em execucao...");
      
      if ( hpa_chamada.contains (HPABaseRecorrencia.hpa_sql_selecionar_usuarios_pid) )
      {
        
        HPASaida.hpaImprimir ("--> Usuarios por ID(primaria)");
        
        this.hpa_statement_interno = this.hpa_linha_conexao.createStatement ();
        this.hpa_resultset_interno = this.hpa_statement_interno.executeQuery (hpa_chamada);
        
        if
            ( ! this.hpa_resultset_interno.isBeforeFirst () )
        {
          HPASaida.hpaImprimir ("Nada encontrado.");
          return null;
        }
        
        hpa_resultset_interno.next ();
        
        final long   hpa_pam1 = hpa_resultset_interno.getLong (1);
        final String hpa_pam2 = hpa_resultset_interno.getString (2);
        final String hpa_pam3 = hpa_resultset_interno.getString (3);
        
        final HPAUsuario hpa_usuario = new HPAUsuario (hpa_pam1,hpa_pam2,hpa_pam3);
        
        if ( hpa_usuario != null )
        {
          HPASaida.hpaImprimir ("Retornando objeto autenticado...");
          this.hpa_statement_interno.close ();
          this.hpa_resultset_interno.close ();
          return (U) hpa_usuario;
        }
        else
        {
          this.hpa_statement_interno.close ();
          this.hpa_resultset_interno.close ();
          return null;
        }
        
      }
      else
        if ( hpa_chamada.contains (HPABaseRecorrencia.hpa_sql_selecionar_projeto_pid) )
        {
          
          HPASaida.hpaImprimir ("--> Projetos por ID(primaria)");
          
          this.hpa_statement_interno = this.hpa_linha_conexao.createStatement ();
          this.hpa_resultset_interno = this.hpa_statement_interno.executeQuery (hpa_chamada);
          
          if
              ( ! this.hpa_resultset_interno.isBeforeFirst () )
          {
            HPASaida.hpaImprimir ("Nada encontrado.");
            return null;
          }
          
          hpa_resultset_interno.next ();
          
          final long   hpa_pam1 = hpa_resultset_interno.getLong (1);
          final String hpa_pam2 = hpa_resultset_interno.getString (2);
          final String hpa_pam3 = hpa_resultset_interno.getString (3);
          final long   hpa_pam4 = hpa_resultset_interno.getLong (4);
          final String hpa_pam5 = hpa_resultset_interno.getString (5);
          
          final HPAProjeto hpa_projeto = new HPAProjeto (hpa_pam1,hpa_pam2,hpa_pam3,hpa_pam4,hpa_pam5);
          
          if ( hpa_projeto != null )
          {
            HPASaida.hpaImprimir ("Retornando objeto autenticado...");
            this.hpa_statement_interno.close ();
            this.hpa_resultset_interno.close ();
            return (U) hpa_projeto;
          }
          else
          {
            this.hpa_statement_interno.close ();
            this.hpa_resultset_interno.close ();
            return null;
          }
          
        }
        else
        {
          return null;
        }
      
    } catch
        (Exception hpa_excecao)
    {
      hpa_excecao.printStackTrace ();
      return null;
    }
    
    
  }
  
  
  @Override
  public <T> HPABaseSimbolo hpaRetonarImagem (final String hpa_chamada)
  {
    
    
    try
    {
      
      HPASaida.hpaImprimir ("Bloco hpaRetonarImagem em execucao...");
      
      final HPABaseSimbolo<T> hpa_processo_imagem = new HPABaseSimbolo<> ((this.<T> hpaProcessarImagem (hpa_chamada)));
      
      if ( hpa_processo_imagem != null )
      {
        HPASaida.hpaImprimir ("Processo imagem valido! OK!");
        return hpa_processo_imagem;
      }
      else
      {
        HPASaida.hpaImprimir ("Processo imagem invalido! OPS!");
        return null;
      }
      
    } catch
        (Exception hpa_excecao)
    {
      hpa_excecao.printStackTrace ();
      return null;
    }
    
  }
  
  
  @Override
  public <Z> TreeMap<Integer, Z> hpaRetonarImagens (String hpa_chamada)
  {
    
    
    TreeMap<Integer, Z> hpa_retonar_imagens = new TreeMap<> ();
    
    try
    {
      
      
      assert (this.hpa_linha_conexao.isClosed ());
      
      
      HPASaida.hpaImprimir ("Bloco hpaRetonarImagens em execucao...");
      
      if ( hpa_chamada.contains (HPABaseRecorrencia.hpa_sql_selecionar_usuarios) )
      {
        
        this.hpaInicilizar ();
        this.hpaConectar ();
        
        this.hpa_statement_interno = this.hpa_linha_conexao.createStatement ();
        this.hpa_resultset_interno = this.hpa_statement_interno.executeQuery (hpa_chamada);
        
        if ( ! this.hpa_resultset_interno.isBeforeFirst () )
        {
          HPASaida.hpaImprimir ("Bloco hpaRetonarImagens nao pode realizar mapeamento.");
          this.hpaFinalizar ();
          return null;
        }
        
        while ( hpa_resultset_interno.next () )
        {
          
          final long   hpa_pam1 = hpa_resultset_interno.getLong (1);
          final String hpa_pam2 = hpa_resultset_interno.getString (2);
          final String hpa_pam3 = hpa_resultset_interno.getString (3);
          
          final HPAUsuario hpa_usuario = new HPAUsuario (hpa_pam1,hpa_pam2,hpa_pam3);
          
          hpa_retonar_imagens.put
              (new Random ().nextInt (new Random ().nextInt (50000)),(Z) hpa_usuario);
          
        }
        
        
        this.hpa_statement_interno.close ();
        this.hpa_resultset_interno.close ();
        this.hpaFinalizar ();
        
        return hpa_retonar_imagens;
        
      }
      else
      {
        this.hpa_statement_interno.close ();
        this.hpa_resultset_interno.close ();
        this.hpaFinalizar ();
        return null;
      }
      
      
      
    } catch
        (Exception hpa_excecao)
    {
      hpa_excecao.printStackTrace ();
      this.hpaFinalizar ();
      return null;
    }
    
    
  }
  
  
  @Override
  public void hpaExecutarSimples (String hpa_base,String... hpa_valores)
  {
    
    
    try
    {
      
      assert (hpa_valores.length >= 2 && hpa_valores != null &&
          (hpa_base.contains ("insert") || hpa_base.contains ("update")));
      
      HPASaida.hpaImprimir ("Bloco hpaExecutarSimplesInsercao em execucao...");
      
      this.hpaInicilizar ();
      this.hpaConectar ();
      
      this.hpa_statement_interno = this.hpa_linha_conexao.createStatement ();
      
      for ( int hpa_percorre = 0;hpa_percorre < hpa_valores.length;hpa_percorre++ )
      {
        
        if ( hpa_valores.length == 1 )
        {
          
          if ( hpa_base.contains ("update") )
          {
            
            if ( hpa_valores[ hpa_percorre ].toCharArray ()[ 0 ] == 'L' &&
                hpa_valores[ hpa_percorre ].toCharArray ()[ 1 ] == 'x' )
            {
              final String hpa_bloco =
                  hpa_valores[ hpa_percorre ].replaceAll ("Lx","");
              
              hpa_base += "  " + hpa_bloco + ";";
            }
            else
              if ( hpa_valores[ hpa_percorre ].toCharArray ()[ 0 ] == 'L' &&
                  hpa_valores[ hpa_percorre ].toCharArray ()[ 1 ] == 'y' )
              {
                final String hpa_bloco =
                    hpa_valores[ hpa_percorre ].replaceAll ("Ly","");
                hpa_base += "  '" + hpa_bloco + "';";
              }
            
          }
          else
            if ( hpa_base.contains ("insert") )
            {
              
              if ( hpa_valores[ hpa_percorre ].toCharArray ()[ 0 ] == 'L' &&
                  hpa_valores[ hpa_percorre ].toCharArray ()[ 1 ] == 'x' )
              {
                final String hpa_bloco =
                    hpa_valores[ hpa_percorre ].replaceAll ("Lx","");
                
                hpa_base += "  " + hpa_bloco + ");";
              }
              else
                if ( hpa_valores[ hpa_percorre ].toCharArray ()[ 0 ] == 'L' &&
                    hpa_valores[ hpa_percorre ].toCharArray ()[ 1 ] == 'y' )
                {
                  final String hpa_bloco =
                      hpa_valores[ hpa_percorre ].replaceAll ("Ly","");
                  hpa_base += "  '" + hpa_bloco + "');";
                }
              
            }
          
          break;
        }
        else
        {
          
          if ( hpa_percorre == (hpa_valores.length - 1) )
          {
            
            if ( hpa_valores[ hpa_percorre ].toCharArray ()[ 0 ] == 'L' &&
                hpa_valores[ hpa_percorre ].toCharArray ()[ 1 ] == 'x' )
            {
              final String hpa_bloco =
                  hpa_valores[ hpa_percorre ].replaceAll ("Lx","");
              
              hpa_base += "  " + hpa_bloco + ");";
            }
            else
              if ( hpa_valores[ hpa_percorre ].toCharArray ()[ 0 ] == 'L' &&
                  hpa_valores[ hpa_percorre ].toCharArray ()[ 1 ] == 'y' )
              {
                final String hpa_bloco =
                    hpa_valores[ hpa_percorre ].replaceAll ("Ly","");
                
                hpa_base += "  '" + hpa_bloco + "');";
              }
            
          }
          else
          {
            
            if ( hpa_valores[ hpa_percorre ].toCharArray ()[ 0 ] == 'L' &&
                hpa_valores[ hpa_percorre ].toCharArray ()[ 1 ] == 'x' )
            {
              final String hpa_bloco =
                  hpa_valores[ hpa_percorre ].replaceAll ("Lx","");
              
              hpa_base += "  " + hpa_bloco + ", ";
            }
            else
              if ( hpa_valores[ hpa_percorre ].toCharArray ()[ 0 ] == 'L' &&
                  hpa_valores[ hpa_percorre ].toCharArray ()[ 1 ] == 'y' )
              {
                final String hpa_bloco =
                    hpa_valores[ hpa_percorre ].replaceAll ("Ly","");
                
                hpa_base += "  '" + hpa_bloco + "', ";
              }
            
            
          }
          
        }
        
      }
      
      HPASaida.hpaImprimir ("Para execucao:" + hpa_base);
      
      
      if ( this.hpa_statement_interno.executeUpdate (hpa_base) != 0 )
      {
        
        this.hpa_linha_conexao.commit ();
        
        HPASaida.hpaImprimir ("Insercao concluida...");
        
      }
      else
      {
        
        HPASaida.hpaImprimir ("Insercao nao concluida...");
        
      }
      
      
      this.hpa_statement_interno.close ();
      this.hpaFinalizar ();
      
    } catch (Exception hpa_excecao)
    {
      
      hpa_excecao.printStackTrace ();
      this.hpaFinalizar ();
      
    }
    
  }
  
  
  @Override
  public <A> A hpaRetornoDe (final String hpa_chamada)
  {
    
    
    try
    {
      
      HPASaida.hpaImprimir ("Chamada de retorno generico unitario (hpaRetornoDe)");
      
      
      this.hpa_statement_interno = this.hpa_linha_conexao.createStatement ();
      this.hpa_resultset_interno = this.hpa_statement_interno.executeQuery (hpa_chamada);
      
      if ( ! hpa_resultset_interno.isBeforeFirst () )
      {
        HPASaida.hpaImprimir ("Nenhum registro disponivel.");
        this.hpa_statement_interno.close ();
        this.hpa_resultset_interno.close ();
        return null;
      }
      
      
      this.hpa_resultset_interno.next ();
      
      
      final A hpa_busca_principal = (A) this.hpa_resultset_interno.getString (1);
      
      this.hpa_statement_interno.close ();
      this.hpa_resultset_interno.close ();
      
      
      HPASaida.hpaImprimir ("Chamada de retorno generico unitario (hpaRetornoDe) concluida.");
      
      
      return hpa_busca_principal;
      
      
    } catch
        (Exception hpa_excecao)
    {
      
      hpa_excecao.printStackTrace ();
      return null;
    }
    
    
  }
  
}
