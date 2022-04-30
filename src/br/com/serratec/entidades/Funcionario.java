package br.com.serratec.entidades;

public abstract class Funcionario extends Pessoa{

	public Funcionario(String cpf, String nome, String senha, Integer tipo) {
		super(cpf, nome, senha, tipo);
		
	}

	public Integer getTipo() {
		return tipo;

	}

	@Override
	public String toString() {
		return 	"NOME: "
				+ nome
				+ "\nCPF: " 
				+ cpf
				+ "\nSENHA: "
				+ senha
				+ "\nTIPO: "
				+ tipo;
							
	}
}
