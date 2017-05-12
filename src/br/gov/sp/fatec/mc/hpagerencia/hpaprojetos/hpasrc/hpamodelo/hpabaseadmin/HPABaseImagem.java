package br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpamodelo.hpabaseadmin;


/*
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

public class HPABaseImagem<X>
{
  
  
  protected X hpa_estrutura_buscada;
  
  
  public HPABaseImagem (final X hpa_estrutura_referencia_construtor)
  {
    
    
    this.hpaAtribuirAEstrutura (hpa_estrutura_referencia_construtor);
  }
  
  
  protected final synchronized void hpaAtribuirAEstrutura (final X hpa_estrutura_referencia)
  {
    
    
    assert (hpa_estrutura_referencia != null);
    this.hpa_estrutura_buscada = hpa_estrutura_referencia;
  }
  
  
  public final synchronized X hpaRetornarEstruturaBuscada ()
  {
    
    
    if ( this.hpa_estrutura_buscada != null )
    {
      return this.hpa_estrutura_buscada;
    }
    else
    {
      return null;
    }
  }
}
