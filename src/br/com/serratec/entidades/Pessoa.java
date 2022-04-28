package br.com.serratec.entidades;

public abstract class Pessoa {
	protected String cpf;
	protected String nome;
	protected String senha;
	
	public Pessoa(String cpf, String nome, String senha) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getSenha() {
		return senha;
	}

}
