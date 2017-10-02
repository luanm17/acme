package br.com.acme.model;

public class Departamento {
	
	private int id;
	private String nome;
	private String funcionario;
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

	public String getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	public String getChefe() {
		return chefe;
	}

	public void setChefe(String chefe) {
		this.chefe = chefe;
	}
	
}
