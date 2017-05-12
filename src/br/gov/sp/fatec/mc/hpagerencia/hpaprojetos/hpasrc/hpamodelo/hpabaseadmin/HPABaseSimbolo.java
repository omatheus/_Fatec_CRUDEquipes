package br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpamodelo.hpabaseadmin;


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
