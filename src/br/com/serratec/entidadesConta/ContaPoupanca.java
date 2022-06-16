package br.com.serratec.entidadesConta;

import br.com.serratec.entidades.Pessoa;
import br.com.serratec.enums.Agencia;

public class ContaPoupanca extends Conta{
		protected Double rendimento;

		public ContaPoupanca(Pessoa pessoa,Agencia agencia) {
			super(pessoa,agencia);
			this.rendimento = 0.001;
			this.tipoConta = "Poupança";
		}

		public Double simularRendimento(Double valor, Integer dias){
			// Aqui seria interessante converter para meses antes de fazer a potenciação, assim ficaria mais próximo do real
			// int meses = dias/30;
			// return (valor*(Math.pow((1+this.rendimento), meses)));
			return (valor*(Math.pow((1+this.rendimento), dias)));
		}

}
