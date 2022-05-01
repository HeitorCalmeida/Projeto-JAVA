package br.com.serratec.entidadesConta;

import br.com.serratec.entidades.Pessoa;
import br.com.serratec.enums.Agencia;

public class ContaPoupanca extends Conta{
		protected Double rendimento;
		protected Double rendimentoDias;

		public ContaPoupanca(Pessoa pessoa,Agencia agencia, Double rendimento) {
			super(pessoa,agencia);
			this.rendimento = rendimento;
			this.rendimentoDias = 0.001;
			this.tipoConta = "Poupança";
		}

		public Double getRendimento() {
			return this.rendimento;
		}
		
		public void render() {
	        if(this.saldo >= 400000.00) {
				this.rendimento = this.saldo * 0.007;
	        }else if (this.saldo < 200000.00) {
				this.rendimento = this.saldo * 0.003;
	        }else {
				this.rendimento = this.saldo *0.005;
	        }
			this.saldo += this.rendimento;
	    }

		public Double simularRendimento(Double valor, Integer dias){
			return (valor*(Math.pow((1+this.rendimentoDias), dias)));
		}

}
