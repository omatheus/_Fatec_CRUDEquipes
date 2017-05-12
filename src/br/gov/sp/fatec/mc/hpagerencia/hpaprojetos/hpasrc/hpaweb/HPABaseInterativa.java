package br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpaweb;


import br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpaentidades.HPAProjeto;
import br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpaentidades.HPAUsuario;
import br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpamodelo.hpabaseadmin.HPABaseNucleo;
import br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpamodelo.hpabaseadmin.HPABaseRecorrencia;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/*
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

@WebServlet (name = "HPABaseInterativa", urlPatterns = {"/hpabi"})
public class HPABaseInterativa extends HttpServlet
{
  
  
  @Override
  protected void doPost (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
  {
    
    
  }
  
  
  @Override
  protected void doGet (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
  {
    
    
    
    try
    {
      if
          ( Integer.parseInt (request.getParameter ("hpa_obt_oper"))
          == HPABaseInterativaPropria.hpa_requisitar_r_usuario_pid )
      {
        
        
        response.setContentType ("text/html");
        
        
        final HPABaseNucleo hpa_movimentacao_bd = new HPABaseNucleo ();
        
        hpa_movimentacao_bd.hpaInicilizar ();
        hpa_movimentacao_bd.hpaConectar ();
        
        final HPAUsuario hpa_buscar_usuario = (HPAUsuario)
            
            hpa_movimentacao_bd.<HPAUsuario> hpaRetonarImagem
                
                (HPABaseRecorrencia.hpa_sql_selecionar_usuarios_pid +
                    request.getParameter ("hpa_us_pr")
                    + ";")
                .retornar ();
        
        
        if ( hpa_buscar_usuario != null )
        {
          response.getWriter ().println ("<div>" + hpa_buscar_usuario.getHpat_nome () + "</div><br>");
          response.getWriter ().println ("<div>" + hpa_buscar_usuario.getHpat_habilidades () + "</div><br>");
        }
        
        
        hpa_movimentacao_bd.hpaFinalizar ();
        
        
      }
      else
        if (
            Integer.parseInt (request.getParameter ("hpa_obt_oper"))
                == HPABaseInterativaPropria.hpa_requisitar_r_projeto_pid
            )
        {
          
          response.setContentType ("text/html");
          
          
          final HPABaseNucleo hpa_movimentacao_bd = new HPABaseNucleo ();
          
          hpa_movimentacao_bd.hpaInicilizar ();
          hpa_movimentacao_bd.hpaConectar ();
          
          final HPAProjeto hpa_buscar_projeto = (HPAProjeto)
              
              hpa_movimentacao_bd.<HPAProjeto> hpaRetonarImagem
                  
                  (HPABaseRecorrencia.hpa_sql_selecionar_projeto_pid +
                      request.getParameter ("hpa_pr_pr")
                      + ";")
                  .retornar ();
          
          if ( hpa_buscar_projeto != null )
          {
            response.getWriter ().println ("<div>" + hpa_buscar_projeto.getHpat_identificador () + "</div><br>");
            response.getWriter ().println ("<div>" + hpa_buscar_projeto.getHpat_descricao () + "</div><br>");
          }
          
          
          hpa_movimentacao_bd.hpaFinalizar ();
          
        }
        else
          if ( Integer.parseInt (request.getParameter ("hpa_obt_oper"))
              == HPABaseInterativaPropria.hpa_requisitar_r_usuarios )
          {
            
            
            response.setContentType ("text/html");
            
            
            final HPABaseNucleo hpa_movimentacao_bd = new HPABaseNucleo ();
            hpa_movimentacao_bd.hpaInicilizar ();
            hpa_movimentacao_bd.hpaConectar ();
            
            
            final String
                hpa_s_integrantes = hpa_movimentacao_bd.<String> hpaRetornoDe
                (HPABaseRecorrencia.hpa_sql_selecionar_integrantes);
            
            
            hpa_movimentacao_bd.hpaFinalizar ();
            
            
            response.getWriter ().println
                ("<form id=\"hpa_selecionar_form\" method=\"post\" action=\"hpats\">");
            
            response.getWriter ().println ("<input type=\"hidden\" name=\"hpa_mov\" value=\"0\">");
            
            for ( HPAUsuario hpa_usuario_em_mapa :
                hpa_movimentacao_bd.<HPAUsuario> hpaRetonarImagens
                    (HPABaseRecorrencia.hpa_sql_selecionar_usuarios).values () )
            {
              
              
              
              
              if
                  (
                  ! hpa_s_integrantes.contains (
                      String.valueOf (hpa_usuario_em_mapa.getHpat_primaria ())
                  )
                  )
              {
                
                response.getWriter ().println ("<input type=\"radio\" name=\"hpa_primaria_aluno\" value=\""
                    +
                    String.valueOf (hpa_usuario_em_mapa.getHpat_primaria ())
                    + "\">");
                
                
                response.getWriter ().println
                    ("<div id=\"hpausuario_" + hpa_usuario_em_mapa.getHpat_primaria () + "\" " +
                        "style=\"font-size:21px; color:red; background:white;\">");
                
                response.getWriter ().println (hpa_usuario_em_mapa.getHpat_nome ());
                
                for ( String hpa_habilidades : hpa_usuario_em_mapa.getHpat_habilidades ().split (";") )
                {
                  
                  response.getWriter ().println ("<div style=\"background:darkred; color:snow;\">");
                  
                  response.getWriter ().println (hpa_habilidades);
                  
                  response.getWriter ().println ("</div>");
                  
                }
                
                response.getWriter ().println ("</div>");
                
              }
              
            }
            
            
            response.getWriter ().println ("<input type=\"submit\" value=\"Concluir...\">");
            response.getWriter ().println ("</form>");
            
          }
          else
            if ( Integer.parseInt (request.getParameter ("hpa_obt_oper"))
                == HPABaseInterativaPropria.hpa_requisitar_r_osintegrantes )
            {
              
              response.setContentType ("text/html");
              
              
              final HPABaseNucleo hpa_movimentacao_bd = new HPABaseNucleo ();
              
              hpa_movimentacao_bd.hpaInicilizar ();
              hpa_movimentacao_bd.hpaConectar ();
              
              final String hpa_s_integrantes = hpa_movimentacao_bd.<String> hpaRetornoDe
                  (HPABaseRecorrencia.hpa_sql_selecionar_integrantes);
              
              if ( hpa_s_integrantes != null && hpa_s_integrantes.length () > 2 )
              {
                
                final StringBuffer hpa_alocar_info = new StringBuffer ();
                final String[]     hpa_parse       = hpa_s_integrantes.split (";");
                
                for
                    ( String hpa_itera : hpa_parse )
                {
                  
                  final HPAUsuario hpa_usuario_iterado = (HPAUsuario)
                      hpa_movimentacao_bd.
                          <HPAUsuario>
                              hpaRetonarImagem
                              (HPABaseRecorrencia.hpa_sql_selecionar_usuarios_pid +
                                  hpa_itera
                                  + ";"
                              ).retornar ();
                  
                  
                  if
                      ( hpa_usuario_iterado != null && hpa_usuario_iterado.getHpat_primaria () != 0 )
                  {
                    
                    hpa_alocar_info.append
                        (
                            "<a href=\"" + "hpabi?hpa_obt_oper=0&hpa_us_pr=" +
                                hpa_usuario_iterado.getHpat_primaria ()
                                + "\">" +
                                
                                hpa_usuario_iterado.getHpat_nome ()
                                
                                + "</a>" + "<span><button style=\"border:none;padding-left:12px;\" " +
                                
                                "id=\"hpa_rm_" +
                                
                                hpa_usuario_iterado.getHpat_primaria ()
                                
                                + "\"> \\X/ </button></span>"
                                
                                
                                + "<br><hr><br>"
                        );
                    
                  }
                  else
                  {
                    
                    response.getWriter ().println ("<p>" +
                        new String ("Algum erro inesperado ocorreu.") +
                        "</p>");
                    
                  }
                  
                  
                }
                
                
                response.getWriter ().println (hpa_alocar_info.toString ());
                
              }
              else
              {
                
                response.getWriter ().println
                    ("<p>" + new String ("Resultado nao encontrado.") + "</p>");
                
              }
              
            }
      
      
    } catch
        (Exception hpaweb_excecao)
    {
      hpaweb_excecao.printStackTrace ();
    }
  }
}
