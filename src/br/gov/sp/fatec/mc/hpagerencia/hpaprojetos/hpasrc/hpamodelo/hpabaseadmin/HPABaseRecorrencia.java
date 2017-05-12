package br.gov.sp.fatec.mc.hpagerencia.hpaprojetos.hpasrc.hpamodelo.hpabaseadmin;


public abstract class HPABaseRecorrencia
{
  
  
  public static final String hpa_conexao_tradicional = "jdbc:firebirdsql://localhost:3050//var/cache/firebird/d/fatec_h1e.fdb";
  
  
  public static final String hpa_conexao_por_usuario = "arujanix1db";
  
  
  public static final String hpa_segredo = "m9m9m9";
  
  
  public static final String hpa_sql_selecionar_projetos = "select * from hpaprojeto;";
  
  
  public static final String hpa_sql_selecionar_projeto_pid = "select * from hpaprojeto where hpatprojetoprimaria=";
  
  
  public static final String hpa_sql_selecionar_usuarios = "select * from hpausuario;";
  
  
  public static final String hpa_sql_selecionar_usuarios_pid = "select * from hpausuario where hpatprimaria=";
  
  
  public static final String hpa_sql_atualizar_novo_integrante = "update hpaprojeto set hpatequipe = hpatequipe ||";
}
