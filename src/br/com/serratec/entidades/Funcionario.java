package br.com.serratec.entidades;

public abstract class Funcionario extends Pessoa{
	protected String cargo;
	
	public Funcionario(String cpf, String nome, String senha) {
		super(cpf, nome, senha);
		
	}

	public String getCargo() {
		return cargo;
	}
}
