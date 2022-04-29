package br.com.serratec.entidades;

public class Pessoa {
	
	protected String cpf;
	protected String nome;
	protected String senha;
	
	public Pessoa(String cpf, String nome, String senha) {
		if(cpf.length() == 11) {
			this.cpf = cpf;
			this.nome = nome;
			this.senha = senha;
		}	
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
	@Override
	public String toString() {
		return 	"NOME: "
				+ nome
				+ "\nCPF: " 
				+ cpf
				+ "\nSENHA: "
				+ senha;
				
			
				
	}

	
}
