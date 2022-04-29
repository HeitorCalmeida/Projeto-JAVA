package br.com.serratec.entidades;

public class Gerente extends Funcionario{
	public char agencia;

	public Gerente(String cpf, String nome, String senha) {
		super(cpf, nome, senha);
		this.agencia = agencia;
		this.cargo = "Gerente";

	}

	public char getAgencia() {
		return agencia;
	}

	public void setAgencia(char agencia) {
		this.agencia = agencia;
	}
	

}
