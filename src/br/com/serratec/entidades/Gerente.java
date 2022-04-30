package br.com.serratec.entidades;

public class Gerente extends Funcionario{
	public char agencia;

	public Gerente(String cpf, String nome, String senha) {
		super(cpf, nome, senha, 2);
		this.agencia = agencia;

	}

	public char getAgencia() {
		return agencia;
	}

	public void setAgencia(char agencia) {
		this.agencia = agencia;
	}
	

}
