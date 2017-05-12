package br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpamodelo.hpabaseadmin;


/*
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

public class HPABaseSimbolo<X> extends HPABaseImagem
{
  
  
  public HPABaseSimbolo (X hpa_estrutura_referencia_construtor)
  {
    
    
    super (hpa_estrutura_referencia_construtor);
  }
  
  
  public final X retornar ()
  {
    
    
    return (X) this.hpaRetornarEstruturaBuscada ();
  }
}
