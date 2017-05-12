package br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpaweb;


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

/**
 * Created by m-h-silva on 5/11/17.
 */
@WebServlet (name = "HPABaseAssertiva", urlPatterns = {"/hpats"})
public class HPABaseAssertiva extends HttpServlet
{
  
  
  @Override
  protected void doPost (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
  {
    
    
    try
    {
      
      assert (request.getParameter ("hpa_mov") != null);
      
      switch ( Integer.parseInt (request.getParameter ("hpa_mov")) )
      {
        
        case HPABaseAssertivaPropria.hpa_solicitar_atualizacao_integrantes:
        {
          
          assert (request.getParameter ("hpa_primaria_aluno") != null);
          
          final HPABaseNucleo hpa_movimentacao_bd = new HPABaseNucleo ();
          
          hpa_movimentacao_bd.hpaInicilizar ();
          hpa_movimentacao_bd.hpaConectar ();
          
          final String hpa_integrantes_atuais =
              hpa_movimentacao_bd.
                  <String> hpaRetornoDe (HPABaseRecorrencia.hpa_sql_selecionar_integrantes);
          
          hpa_movimentacao_bd.hpaFinalizar ();
          
          if
              ( ! hpa_integrantes_atuais.contains (request.getParameter ("hpa_primaria_aluno")) )
          {
            
            
            
            hpa_movimentacao_bd.hpaExecutarSimples
                (HPABaseRecorrencia.hpa_sql_atualizar_novo_integrante,new String[]
                    {"Ly" + request.getParameter ("hpa_primaria_aluno") + ";"});
            
            
            response.setContentType ("text/html");
            response.getWriter ().println ("<div><h3 style=\"color:tan;\">Ok... retornando.</h3></div>");
          }
          else
          {
            
            response.setContentType ("text/html");
            response.getWriter ().println ("<div><h3 style=\"color:tan;\">ESPERE! Aluno ja inserido.</h3></div>");
            
          }
          
          
        }
        
        
      }
      
    } catch (Exception hpa_web_exececao)
    {
      
      hpa_web_exececao.printStackTrace ();
      
    }
    
  }
  
  
  @Override
  protected void doGet (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
  {
    
    
  }
}
