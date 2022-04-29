package br.com.serratec.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.serratec.entidades.Cliente;
import br.com.serratec.entidades.Diretor;
import br.com.serratec.entidades.Gerente;
import br.com.serratec.entidades.Pessoa;
import br.com.serratec.entidades.Presidente;
import br.com.serratec.entidadesConta.Conta;
import br.com.serratec.entidadesConta.ContaCorrente;
import br.com.serratec.entidadesConta.ContaPoupanca;

public class Programa {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		List<Conta> listaContas = new ArrayList<Conta>();

/*		List<Cliente> listaClientes = new ArrayList<Cliente>();
		List<Diretor> listaDiretores = new ArrayList<Diretor>();
		List<Gerente> listaGerentes = new ArrayList<Gerente>();
		List<Presidente> listaPresidentes = new ArrayList<Presidente>();           */

		Pessoa dir = new Diretor("13128451550","Gabriel","12345");
		Conta conta1 = new ContaCorrente(dir,800);
		//listaPessoas.add(dir);
		listaContas.add(conta1);
		
		Pessoa dir2 = new Diretor("06445419155","Leticia","917775");
		Conta conta5 = new ContaPoupanca(dir2,2000);
		//listaPessoas.add(dir2);
		listaContas.add(conta5);

		Pessoa cl1 = new Cliente("77345678910","Pedro","22374");
		Conta conta2 = new ContaCorrente(cl1,1200);
		Conta conta7 = new ContaPoupanca(cl1, 2000);
		//listaPessoas.add(cl1);
		listaContas.add(conta2);
		listaContas.add(conta7);
		
		Pessoa ger1 = new Gerente("90345678910","Amanda","892374");
		Conta conta3 = new ContaCorrente(ger1,1860);
		//listaPessoas.add(ger1);
		listaContas.add(conta3);

		Pessoa pres1 = new Presidente("00345678910","Heitor","00374");
		Conta conta4 = new ContaPoupanca(pres1,5000);
		//listaPessoas.add(pres1);
		listaContas.add(conta4);
		
		
		
		
/*		System.out.println("-=-= Pessoas =-=-\n-------------------");
		for(Pessoa pessoaAtual : listaPessoas) {
			System.out.println(pessoaAtual);
			System.out.println("-------------------");   
		}    
*/
		System.out.println("");
		System.out.println("-=-= Contas =-=-\n-------------------");
		for(Conta contaAtual : listaContas) {
			System.out.println(contaAtual);
			System.out.println("-------------------");
		}
		
	
		System.out.print("------------- LOGIN -------------\nDigite seu CPF: ");
		String cpf = sc.next();
		System.out.print("Digite sua senha: ");
		String senha = sc.next();
		System.out.print("---------------------------------\n");
		
		for(Conta auth : listaContas) {
			if(auth.getPessoa().getCpf().equals(cpf)) {
				if(auth.getPessoa().getSenha().equals(senha)) {
					System.out.println("autenticado com sucesso!");				
				}
			}	
			
		}
	
		
		sc.close();
	}

}
