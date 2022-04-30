package br.com.serratec.entidades;

import br.com.serratec.enums.Agencia;

public class Gerente extends Funcionario{
	private Agencia agencia;

	public Gerente(String cpf, String nome, String senha, Agencia agencia) {
		super(cpf, nome, senha, 2);
		this.agencia = agencia;

	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	

}
