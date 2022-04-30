package br.com.serratec.enums;

public enum Agencia {
	
	A001("Ag 001"),
	A002("Ag 002"),
	A003("Ag 003");
	
	public String idAgencia;

	private Agencia(String idAgencia) {
		this.idAgencia = idAgencia;
	}

	public String getNomeAgencia() {
		return idAgencia;
	}

}
