package br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpamodelo.hpabaseadmin;


import java.util.TreeMap;


/*
 *   This Source Code Form is subject to the terms of the Mozilla Public
 *   License, v. 2.0. If a copy of the MPL was not distributed with this
 *   file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

public interface HPABaseInterface
{
  
  
  public abstract void hpaInicilizar ();
  
  
  public abstract void hpaConectar ();
  
  
  public abstract void hpaFinalizar ();
  
  
  public abstract <U extends Object> U hpaProcessarImagem (final String hpa_chamada);
  
  
  public abstract <T> HPABaseSimbolo hpaRetonarImagem (final String hpa_chamada);
  
  
  public abstract <Z> TreeMap<Integer, Z> hpaRetonarImagens (final String hpa_chamada);
  
  
  public abstract void hpaExecutarSimples (final String hpa_base,String... hpa_valores);
  
  
  public abstract <A> A hpaRetornoDe (final String hpa_chamada);
  
}
