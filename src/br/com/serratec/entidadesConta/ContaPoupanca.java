package br.com.serratec.entidadesConta;

import br.com.serratec.entidades.Pessoa;
import br.com.serratec.enums.Agencia;

public class ContaPoupanca extends Conta{
		private double rendimento;

		public ContaPoupanca(Pessoa pessoa,Agencia agencia, double rendimento) {
			super(pessoa,agencia);
			this.rendimento = rendimento;
			this.tipoConta = "Conta-Poupança";
		}

		public double getRendimento() {
			return rendimento;
		}
		
		public void render() {
	        if(saldo >= 400000.00) {
	            rendimento = saldo * 0.007;
	        }else if (saldo < 200000.00) {
	                rendimento = saldo * 0.003;
	        }else {
	            rendimento = saldo *0.005;
	        }
	        saldo += rendimento;
	    }

}
