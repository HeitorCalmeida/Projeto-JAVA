package br.com.serratec.enums;

public enum Agencia {
	
//	Interessante, essa sintaxe não conhecia, mas nesse caso o toString é desnecessário, porque Enums já retornam por padrão essa resposta
//	Ex.: Sytem.out.println(Agencia.A001) já retorna "A001" mesmo sem o Override
	A001 {
		@Override
		public String toString() {
			return "A001";
		}
	},
	A002 {
		@Override
		public String toString() {
			return "A002";
		}
	},
	A003 {
		@Override
		public String toString() {
			return "A003";
		}
	};

}
