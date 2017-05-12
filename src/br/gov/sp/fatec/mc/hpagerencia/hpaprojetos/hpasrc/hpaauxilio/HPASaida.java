package br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpaauxilio;


public abstract class HPASaida
{
  
  
  private static int hpa_ciclo_contador = 0;
  
  
  public final static void hpaImprimir (final String conteudo)
  {
    
    
    hpa_ciclo_contador += 1;
    
    System.out.println (String.valueOf (hpa_ciclo_contador) + "::HPAS::");
    System.out.println ("  ::----::");
    System.out.println ();
    System.out.println ("\t" + conteudo);
    System.out.println ();
    System.out.println ("::----::");
    System.out.println ("::HPAS::");
    System.out.println ();
    
    
  }
  
}
