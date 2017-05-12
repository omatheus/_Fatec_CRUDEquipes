package br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpamodelo.hpabaseadmin;


import java.util.TreeMap;


public interface HPABaseInterface
{
  
  
  public abstract void hpaInicilizar ();
  
  
  public abstract void hpaConectar ();
  
  
  public abstract void hpaFinalizar ();
  
  
  public abstract <U extends Object> U hpaProcessarImagem (final String hpa_chamada);
  
  
  public abstract <T> HPABaseSimbolo hpaRetonarImagem (final String hpa_chamada);
  
  
  public abstract <Z> TreeMap<Integer, Z> hpaRetonarImagens (final String hpa_chamada);
  
  
  public abstract void hpaExecutarSimples (final String hpa_base,String... hpa_valores);
  
}
