package br.com.serratec.enums;

public enum Agencia {
	
	A001('1'),
	A002('2'),
	A003('3');
	
	public char idAgencia;

	private Agencia(char idAgencia) {
		this.idAgencia = idAgencia;
	}

	public char getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(char idAgencia) {
		this.idAgencia = idAgencia;
	}
	
	
}
