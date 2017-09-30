package br.com.acme.model;

public class Departamento {
	
	private int id;
	private String nome;
	private Funcionario funcionario;
	private String chefe;
	
	public Departamento(){}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public String getChefe() {
		return chefe;
	}
	public void setChefe(String chefe) {
		this.chefe = chefe;
	}
}
