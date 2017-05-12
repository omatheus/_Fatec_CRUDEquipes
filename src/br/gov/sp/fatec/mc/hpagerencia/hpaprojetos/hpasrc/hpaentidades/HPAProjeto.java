package br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpaentidades;



public class HPAProjeto
{
 
  private long hpat_projeto_primaria;
  private String hpat_identificador;
  private String hpat_descricao;
  private long hpat_gestor;
  
  
  public HPAProjeto (long hpat_projeto_primaria,String hpat_identificador,String hpat_descricao,long hpat_gestor,String hpat_equipe)
  {
  
  
    this.hpat_projeto_primaria = hpat_projeto_primaria;
    this.hpat_identificador = hpat_identificador;
    this.hpat_descricao = hpat_descricao;
    this.hpat_gestor = hpat_gestor;
    this.hpat_equipe = hpat_equipe;
  }
  
  
  public long getHpat_projeto_primaria ()
  {
    
    
    return hpat_projeto_primaria;
  }
  
  
  public void setHpat_projeto_primaria (final long hpat_projeto_primaria)
  {
    
    
    this.hpat_projeto_primaria = hpat_projeto_primaria;
  }
  
  
  public String getHpat_identificador ()
  {
    
    
    return hpat_identificador;
  }
  
  
  public void setHpat_identificador (final String hpat_identificador)
  {
    
    
    this.hpat_identificador = hpat_identificador;
  }
  
  
  public String getHpat_descricao ()
  {
    
    
    return hpat_descricao;
  }
  
  
  public void setHpat_descricao (final String hpat_descricao)
  {
    
    
    this.hpat_descricao = hpat_descricao;
  }
  
  
  public long getHpat_gestor ()
  {
    
    
    return hpat_gestor;
  }
  
  
  public void setHpat_gestor (final long hpat_gestor)
  {
    
    
    this.hpat_gestor = hpat_gestor;
  }
  
  
  public String getHpat_equipe ()
  {
    
    
    return hpat_equipe;
  }
  
  
  public void setHpat_equipe (final String hpat_equipe)
  {
    
    
    this.hpat_equipe = hpat_equipe;
  }
  
  
  private String hpat_equipe;
  
}
