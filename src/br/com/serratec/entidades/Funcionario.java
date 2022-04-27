package br.com.serratec.entidades;

public class Funcionario extends Usuario{
	private String cargo;
	
	public Funcionario(String cpf, String nome, String senha) {
		super(cpf, nome, senha);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
