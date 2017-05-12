package br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpaentidades;


public class HPAUsuario
{
  
  
  private long hpat_primaria;
  
  
  private String hpat_nome;
  
  
  private String hpat_habilidades;
  
  
  
  public HPAUsuario (long hpat_primaria,String hpat_nome,String hpat_habilidades)
  {
    
    
    this.hpat_primaria = hpat_primaria;
    this.hpat_nome = hpat_nome;
    this.hpat_habilidades = hpat_habilidades;
  }
  
  
  public String getHpat_nome ()
  {
    
    
    return hpat_nome;
  }
  
  
  public void setHpat_nome (final String hpat_nome)
  {
    
    
    this.hpat_nome = hpat_nome;
  }
  
  
  public String getHpat_habilidades ()
  {
    
    
    return hpat_habilidades;
  }
  
  
  public void setHpat_habilidades (final String hpat_habilidades)
  {
    
    
    this.hpat_habilidades = hpat_habilidades;
  }
  
  
  public long getHpat_primaria ()
  {
    
    
    return hpat_primaria;
  }
  
  
  public void setHpat_primaria (final long hpat_primaria)
  {
    
    
    this.hpat_primaria = hpat_primaria;
  }
  
  
  
}
