package br.com.serratec.entidades;

public class Diretor extends Funcionario {

	public Diretor(String cpf, String nome, String senha) {
		super(cpf, nome, senha);
		this.cargo = "Diretor";
	}
}
