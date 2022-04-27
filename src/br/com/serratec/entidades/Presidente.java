package br.com.serratec.entidades;

public class Presidente extends Funcionario{
	
	public Presidente(String cpf, String nome, String senha) {
		super(cpf, nome, senha);
		this.cargo = "Presidente";
		
	}
	
}
