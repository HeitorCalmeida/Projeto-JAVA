package br.com.serratec.application;

import java.util.*;

import br.com.serratec.entidades.*;
import br.com.serratec.entidadesConta.Conta;
import br.com.serratec.entidadesConta.ContaCorrente;
import br.com.serratec.entidadesConta.ContaPoupanca;
import br.com.serratec.enums.Agencia;

import static br.com.serratec.enums.Agencia.*;
import static java.lang.Thread.sleep;

public class Programa {

	private static final Scanner sc = new Scanner(System.in);
	private static Pessoa usuario = null;
	private static List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
	private static List<Conta> listaContas = new ArrayList<Conta>();

	public static void main(String[] args) {

		sc.useLocale(Locale.ENGLISH);

		// - Cria os objetos do tipo pessoa e coloca em uma lista
		// -------------------------------------------------------
		Pessoa cl1 = new Cliente("77345678910", "Pedro", "22374");
		listaPessoas.add(cl1);
		listaContas.add(new ContaPoupanca(cl1, A001));
		listaContas.add(new ContaCorrente(cl1, A001));

		Pessoa cl2 = new Cliente("59468752136", "Marcos", "55669");
		listaPessoas.add(cl2);
		listaContas.add(new ContaPoupanca(cl2, A002));
		listaContas.add(new ContaCorrente(cl2, A002));

		Pessoa cl3 = new Cliente("78513264591", "Mylena", "56321");
		listaPessoas.add(cl3);
		listaContas.add(new ContaPoupanca(cl3, A003));
		listaContas.add(new ContaCorrente(cl3, A003));

		Pessoa ger1 = new Gerente("90345678910", "Amanda", "892374", A001);
		listaPessoas.add(ger1);
		listaContas.add(new ContaPoupanca(ger1, A001));
		listaContas.add(new ContaCorrente(ger1, A001));

		Pessoa ger2 = new Gerente("13128451550", "Gabriel", "12345", A002);
		listaPessoas.add(ger2);
		listaContas.add(new ContaPoupanca(ger2, A002));
		listaContas.add(new ContaCorrente(ger2, A002));

		Pessoa ger3 = new Gerente("51263498632", "Lucas", "vihuchi", A003);
		listaPessoas.add(ger3);
		listaContas.add(new ContaPoupanca(ger3, A003));
		listaContas.add(new ContaCorrente(ger3, A003));

		Pessoa dir2 = new Diretor("06445419155", "Leticia", "917775");
		listaPessoas.add(dir2);
		listaContas.add(new ContaPoupanca(dir2, A002));
		listaContas.add(new ContaCorrente(dir2, A002));

		Pessoa pres1 = new Presidente("00345678910", "Heitor", "00374");
		listaPessoas.add(pres1);
		listaContas.add(new ContaPoupanca(pres1, A001));
		listaContas.add(new ContaCorrente(pres1, A001));

		// --------------------------------------------------------------------------------------------------------------

		// - Roda o menu
		// ------------------------------------------------------------------------------------------------
		do {
			// - Faz o login do usuario
			// -------------------------------------------------------------------------------------
			while (usuario == null) {
				usuario = login();
			}
			// --------------------------------------------------------------------------------------------------------------
			menuGeral();
		} while (true);
		// --------------------------------------------------------------------------------------------------------------
	}

	private static Pessoa login() {
		System.out.println("------------- LOGIN -------------");
		System.out.print("Digite seu CPF: ");
		String cpf = sc.next();
		System.out.print("Digite sua senha: ");
		String senha = sc.next();
		System.out.println("---------------------------------");

		for (Pessoa auth : listaPessoas) {
			if (auth.getCpf().equals(cpf)) {
				if (auth.getSenha().equals(senha)) {
					System.out.println("Autenticado com sucesso!");
					System.out.printf("Bem-Vindo %s!", auth.getNome());
					return auth;
				} else {
					System.out.println("Senha invalida!");
					return null;
				}
			}
		}

		System.out.println("O usuario n??o existe!");
		return null;
	}

	private static void sair() {
		// - Verifica se deseja sair do sistema
		// ---------------------------------------------------------------------
		boolean erro;
		do {
			erro = false;
			try {
				System.out.print("\nDeseja sair do sistema (s/n): ");
				String c = sc.next();
				if (!c.equals("s") && !c.equals("S") && !c.equals("n") && !c.equals("N")) {
					System.out.println("\nOp????o invalida!\nInforme uma op????o valida!!!");
					erro = true;
				} else {
					if (c.equals("s") || c.equals("S")) {
						usuario = null;
						System.out.println("\n\n\n\n\n\n\n\n\n");
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("Op????o invalida!\nInforme uma op????o valida!!!");
				erro = true;
				sc.next();
			}
		} while (erro);
		// ----------------------------------------------------------------------------------------------------------
	}

	private static void menuGeral() {
		String opt = "" + "\n------------------- Escolha a opera????o desejada ------------------- " + "\n0 - Sair"
				+ "\n1 - Saque" + "\n2 - Dep??sito" + "\n3 - Transfer??ncia" + "\n4 - Saldo" + "\n5 - Tributa????o da conta"
				+ "\n6 - Rendimento da poupan??a";

		switch (usuario.getTipo()) {
		case 1:
			menuCliente((Cliente) usuario, opt);
			break;
		case 2:
			menuGerente((Gerente) usuario, opt);
			break;
		case 3:
			menuDiretor((Diretor) usuario, opt);
			break;
		case 4:
			menuPresidente((Presidente) usuario, opt);
			break;
		}
	}

	private static void menuCliente(Cliente cliente, String opt) {
		System.out.println(opt);
		Integer opcoaoEscolhida = null;
		while (opcoaoEscolhida == null) {
			System.out.print("Digite a op????o desejada: ");
			try {
				opcoaoEscolhida = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nOp????o invalida!\nInforme uma op????o valida!!!\n");
			}
		}

		switch (opcoaoEscolhida) {
		case 0:
			sair();
			break;
		case 1:
			fazerSaque();
			break;
		case 2:
			fazerDeposito();
			break;
		case 3:
			fazerTransferencia();
			break;
		case 4:
			mostarSaldo();
			break;
		case 5:
			mostarTaxas();
			break;
		case 6:
			rendimentoPoupanca();
			break;
		default:
			System.out.print("Op????o invalida");
			System.exit(1);
		}
	}

	private static void menuGerente(Gerente gerente, String opt) {
		opt = opt + "" + "\n7 - Contas na sua agencia";
		System.out.println(opt);
		Integer opcoaoEscolhida = null;
		while (opcoaoEscolhida == null) {
			System.out.print("Digite a op????o desejada: ");
			try {
				opcoaoEscolhida = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nOp????o invalida!\nInforme uma op????o valida!!!\n");
			}
		}
		System.out.println("\n");

		switch (opcoaoEscolhida) {
		case 0:
			sair();
			break;
		case 1:
			fazerSaque();
			break;
		case 2:
			fazerDeposito();
			break;
		case 3:
			fazerTransferencia();
			break;
		case 4:
			mostarSaldo();
			break;
		case 5:
			mostarTaxas();
			break;
		case 6:
			rendimentoPoupanca();
			break;
		case 7:
			mostrarContasNaAgenciaGerente(gerente);
			break;
		default:
			System.out.print("Op????o invalida");
			System.exit(1);
		}
	}

	private static void menuDiretor(Diretor diretor, String opt) {
		opt = opt + "" + "\n7 - Contas por agencia" + "\n8 - Lista de clientes";
		System.out.println(opt);
		Integer opcoaoEscolhida = null;
		while (opcoaoEscolhida == null) {
			System.out.print("Digite a op????o desejada: ");
			try {
				opcoaoEscolhida = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nOp????o invalida!\nInforme uma op????o valida!!!\n");
			}
		}
		System.out.println("\n");

		switch (opcoaoEscolhida) {
		case 0:
			sair();
			break;
		case 1:
			fazerSaque();
			break;
		case 2:
			fazerDeposito();
			break;
		case 3:
			fazerTransferencia();
			break;
		case 4:
			mostarSaldo();
			break;
		case 5:
			mostarTaxas();
			break;
		case 6:
			rendimentoPoupanca();
			break;
		case 7:
			mostrarContasNaAgencia();
			break;
		case 8:
			mostrasTodasContas();
			break;
		default:
			System.out.print("Op????o invalida");
			System.exit(1);
		}
	}

	private static void menuPresidente(Presidente presidente, String opt) {
		opt = opt + "" + "\n7 - Contas por agencia" + "\n8 - Lista de clientes" + "\n9 - Total no banco";
		System.out.println(opt);
		Integer opcoaoEscolhida = null;
		while (opcoaoEscolhida == null) {
			System.out.print("Digite a op????o desejada: ");
			try {
				opcoaoEscolhida = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nOp????o invalida!\nInforme uma op????o valida!!!\n");
			}
		}
		System.out.println("\n");

		switch (opcoaoEscolhida) {
		case 0:
			sair();
			break;
		case 1:
			fazerSaque();
			break;
		case 2:
			fazerDeposito();
			break;
		case 3:
			fazerTransferencia();
			break;
		case 4:
			mostarSaldo();
			break;
		case 5:
			mostarTaxas();
			break;
		case 6:
			rendimentoPoupanca();
			break;
		case 7:
			mostrarContasNaAgencia();
			break;
		case 8:
			mostrasTodasContas();
			break;
		case 9:
			totalNoBanco();
			break;
		default:
			System.out.print("Op????o invalida");
			System.exit(1);
		}
	}

	private static void fazerSaque() {
		System.out.println("\n--------------------------- Saque ---------------------------");
		Integer contaEscolhida = null;
		boolean continuar = false;
		while ((contaEscolhida == null) || (!continuar)) {
			try {
				System.out.println("Escolha uma conta!");
				mostrasContas();
				System.out.print("Numero da conta: ");
				contaEscolhida = sc.nextInt();
				Conta conta = validaConta(contaEscolhida);
				if (conta != null) {
					continuar = true;
					System.out.printf("Saldo: %.2f\n", conta.getSaldo());
					if (conta.getSaldo() == 0) {
						try {
							System.out.println("Saldo insuficiente para saque!");
							sleep(3000);
						} catch (InterruptedException e) {
							continuar = false;
							System.out.println("Aconteceu um erro durante a opera????o!");
						}
					} else {
						try {
							System.out.print("Valor para saque: ");
							double valorSaque = sc.nextDouble();
							if (conta.saque(valorSaque)) {
								System.out.println("\nSaque realizado com sucesso!");
								System.out.printf("Saldo: %.2f\n", conta.getSaldo());
								System.out.println("Taxa paga: " + conta.getTaxa());
							} else {
								continuar = false;
								System.out.println("N??o foi possivel realizar o saque, varifique o valor!\n");
							}
						} catch (InputMismatchException e) {
							continuar = false;
							System.out.println("Valor invalido!");
							System.out.println("Informe um valor do tipo double (exemplo: 10.00).\n");
						}
					}
				} else {
					System.out.println("Esta conta n??o existe!\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("Conta invalida!\n");
			}
		}
	}

	private static void fazerDeposito() {
		System.out.println("\n--------------------------- Deposito ---------------------------");
		Integer contaEscolhida = null;
		boolean continuar = false;
		while ((contaEscolhida == null) || (!continuar)) {
			try {
				System.out.println("Escolha uma conta!");
				mostrasContas();
				System.out.print("Numero da conta: ");
				contaEscolhida = sc.nextInt();
				Conta conta = validaConta(contaEscolhida);
				if (conta != null) {
					try {
						continuar = true;
						System.out.printf("Saldo: %.2f\n", conta.getSaldo());
						System.out.print("Valor para deposito: ");
						Double valorDeposito = sc.nextDouble();
						if (conta.deposito(valorDeposito)) {
							System.out.println("\nDeposito realizado com sucesso!");
							System.out.printf("Saldo: %.2f\n", conta.getSaldo());
							System.out.println("Taxa paga: " + conta.getTaxa());
						} else {
							System.out.println("\nN??o foi possivel realizar o deposito!!");
							System.out.printf("Saldo: %.2f\n", conta.getSaldo());
						}
					} catch (Exception e) {
						continuar = false;
						System.out.println("Valor invalido!");
						System.out.println("Informe um valor do tipo double (exemplo: 10.00).\n");
					}
				} else {
					System.out.println("Esta conta n??o existe!\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("Conta invalida!\n");
			}
		}

	}

	private static void fazerTransferencia() {
		System.out.println("\n--------------------------- Tranferencia ---------------------------");
		Integer contaEscolhida = null;
		Integer contaEscolhidaDestino = null;
		boolean continuar = false;
		while ((contaEscolhida == null) || (!continuar)) {
			try {
				System.out.println("Escolha uma conta!");
				mostrasContas();
				System.out.print("Numero da conta: ");
				contaEscolhida = sc.nextInt();
				Conta conta = validaConta(contaEscolhida);

				if (conta != null) {
					while (contaEscolhidaDestino == null) {
						try {
							continuar = true;
							System.out.println("\nContas de destino: ");
							for (Conta contaDestino : listaContas) {
								if (!Objects.equals(contaDestino.getNumeroConta(), conta.getNumeroConta())) {
									System.out.println("Conta: " + contaDestino.getNumeroConta() + " / Tipo: "
											+ contaDestino.getTipoConta() + " / Dono: "
											+ contaDestino.getPessoa().getNome());
								}
							}
							System.out.print("\nEscolha uma conta de destino: ");
							contaEscolhidaDestino = sc.nextInt();
							Conta contaDestino = validaContaDestino(contaEscolhidaDestino);
							if (contaDestino != null) {
								System.out.printf("\nSeu saldo: %.2f\n", conta.getSaldo());
								System.out.print("Valor para tranferencia: ");
								Double valorDeposito = sc.nextDouble();
								if (conta.transferencia(valorDeposito, contaDestino)) {
									System.out.println("\nTranferencia realizada com sucesso!!");
									System.out.printf("Saldo: %.2f\n", conta.getSaldo());
								} else {
									System.out.println("\nN??o foi possivel realizar a tranferencia!!");
									System.out.printf("Saldo: %.2f\n", conta.getSaldo());
								}
							} else {
								System.out.println("Esta conta n??o existe!\n");
							}
						} catch (InputMismatchException e) {
							continuar = false;
							System.out.println("Conta invalida!\n");
						}
					}
				} else {
					System.out.println("Esta conta n??o existe!\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("Conta invalida!\n");
			}
		}
	}

	private static Conta validaConta(Integer conta) {
		for (Conta contas : listaContas) {
			if (contas.getPessoa() == usuario) {
				if (contas.getNumeroConta().equals(conta)) {
					return contas;
				}
			}
		}
		return null;
	}

	private static Conta validaContaPoupanca(Integer conta) {
		for (Conta contas : listaContas) {
			if (contas.getPessoa() == usuario) {
				if (contas.getTipoConta().equals("Poupan??a")) {
					if (contas.getNumeroConta().equals(conta)) {
						return contas;
					}
				}
			}
		}
		return null;
	}

	private static Conta validaContaDestino(Integer conta) {
		for (Conta contas : listaContas) {
			if (contas.getPessoa() != usuario) {
				if (contas.getNumeroConta().equals(conta)) {
					return contas;
				}
			}
		}
		return null;
	}

	private static Agencia validaAgencia(String agencia) {
		for (Agencia a : Agencia.values()) {
			if (Objects.equals(a.toString(), agencia)) {
				return a;
			}
		}
		return null;
	}

	private static void mostrarAgencias() {
		for (Agencia a : Agencia.values()) {
			System.out.println(a.toString());
		}
	}

	private static void mostrasContas() {
		for (Conta conta : listaContas) {
			if (conta.getPessoa() == usuario) {
				System.out.println("Conta: " + conta.getNumeroConta() + " / Tipo: " + conta.getTipoConta());
			}
		}
	}

	private static void mostrasTodasContas() {
		System.out.println("\n--------------------------- Lista de clientes ---------------------------");
		listaContas.sort(new Comparator<Conta>() {
			@Override
			public int compare(Conta u1, Conta u2) {
				return u1.getPessoa().getNome().compareTo(u2.getPessoa().getNome());
			}
		});
		System.out.println("Clientes:");
		for (Conta conta : listaContas) {
			System.out.println("Dono: " + conta.getPessoa().getNome() + " / Cpf: " + conta.getPessoa().getCpf()
					+ " / Conta: " + conta.getNumeroConta() + " / Tipo: " + conta.getTipoConta() + " / Agencia: "
					+ conta.getAgencia().toString());
		}

		Arquivos.salvarRelatorioTotalClientes(
				"--------------------------- Lista de clientes ---------------------------", listaContas);
	}

	private static void mostrasContasPoupanca() {
		for (Conta conta : listaContas) {
			if (conta.getPessoa() == usuario) {
				if (conta.getTipoConta().equals("Poupan??a")) {
					System.out.println("Conta: " + conta.getNumeroConta() + " / Tipo: " + conta.getTipoConta());
				}
			}
		}
	}

	private static void mostrarContasNaAgenciaGerente(Gerente gerente) {
		System.out.println("\n--------------------------- Clientes na sua agencia ---------------------------");
		System.out.println("Clientes: ");
		for (Conta conta : listaContas) {
			if (conta.getAgencia() == gerente.getAgencia()) {
				System.out.println("Conta: " + conta.getNumeroConta() + " / Tipo: " + conta.getTipoConta() + " / Dono: "
						+ conta.getPessoa().getNome());
			}
		}
		Arquivos.salvarRelatorioClientesAgenciaGerente(
				"--------------------------- Clientes na sua agencia ---------------------------", listaContas,
				gerente.getAgencia());
	}

	private static void mostrarContasNaAgencia() {
		System.out.println("\n--------------------------- Clientes por agencia ---------------------------");
		boolean con = false;
		while (!con) {
			try {
				System.out.println("Agencias: ");
				mostrarAgencias();
				System.out.println("Informe a agencia: ");
				String agencia = sc.next();
				Agencia a = validaAgencia(agencia);
				if (a != null) {
					con = true;
					for (Conta conta : listaContas) {
						if (conta.getAgencia() == a) {
							System.out.println("Conta: " + conta.getNumeroConta() + " / Tipo: " + conta.getTipoConta()
									+ " / Dono: " + conta.getPessoa().getNome());
						}
					}
					Arquivos.salvarRelatorioClientesAgencia(
							"--------------------------- Clientes por agencia ---------------------------", listaContas,
							a);
				} else {
					System.out.println("Esta agencia n??o existe!\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("Agencia invalida!\n");
			}
		}
	}

	private static void mostarSaldo() {
		System.out.println("\n--------------------------- Saldo ---------------------------");
		Integer contaEscolhida = null;
		boolean continuar = false;
		while ((contaEscolhida == null) || (!continuar)) {
			try {
				System.out.println("Escolha uma conta!");
				mostrasContas();
				System.out.print("Numero da conta: ");
				contaEscolhida = sc.nextInt();
				Conta conta = validaConta(contaEscolhida);
				if (conta != null) {
					continuar = true;
					System.out.printf("Saldo: %.2f\n", conta.getSaldo());
					Arquivos.salvarRelatorioSaldo("--------------------------- Saldo ---------------------------",
							conta);
				} else {
					System.out.println("Esta conta n??o existe!\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("Conta invalida!\n");
			}
		}
	}

	private static void mostarTaxas() {
		System.out.println("\n--------------------------- Tributa????o da conta ---------------------------");
		Integer contaEscolhida = null;
		boolean continuar = false;
		while ((contaEscolhida == null) || (!continuar)) {
			try {
				System.out.println("Escolha uma conta!");
				mostrasContas();
				System.out.print("Numero da conta: ");
				contaEscolhida = sc.nextInt();
				Conta conta = validaConta(contaEscolhida);
				if (conta != null) {
					continuar = true;
					System.out.printf("Total pago: %.2f\n", conta.getTaxasPagasTotal());
					System.out.printf("Taxa deposito/saque: %.2f\n", conta.getTaxa());
					System.out.printf("Taxa tranferencia: %.2f\n", conta.getTaxaTrans());
					System.out.println("---- Detalhes ----");
					for (String taxas : conta.getTaxasPagas()) {
						System.out.println(taxas);
					}
					Arquivos.salvarRelatorioTaxas(
							"--------------------------- Tributa????o da conta ---------------------------", conta);
				} else {
					System.out.println("Esta conta n??o existe!\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("Conta invalida!\n");
			}
		}
	}

	private static void rendimentoPoupanca() {
		System.out.println("\n--------------------------- Rendimento da poupan??a ---------------------------");
		Integer contaEscolhida = null;
		boolean continuar = false;
		while ((contaEscolhida == null) || (!continuar)) {
			try {
				System.out.println("Escolha uma conta!");
				mostrasContasPoupanca();
				System.out.print("Numero da conta: ");
				contaEscolhida = sc.nextInt();
				Conta conta = validaContaPoupanca(contaEscolhida);
				if (conta != null) {
					ContaPoupanca cp = (ContaPoupanca) conta;
					System.out.print("Informe o valor inicial: ");
					Double valorInicial = sc.nextDouble();
					System.out.print("Informe o numero de dias para o rendimento: ");
					Integer dias = sc.nextInt();

					if (valorInicial != 0 & dias != 0) {
						continuar = true;
						System.out.printf("\nValor inicial: %.2f\n", valorInicial);
						System.out.printf("Dias: %d\n", dias);
						Double valorFinal = cp.simularRendimento(valorInicial, dias);
						System.out.printf("Rendimento: %.2f\n", valorFinal);
						Arquivos.salvarRelatorioSimulacao(
								"--------------------------- Rendimento da poupan??a ---------------------------",
								valorInicial, dias, valorFinal);
					} else {
						System.out.println("N??o foi possivel simular o rendimento\n");
					}
				} else {
					System.out.println("Esta conta n??o existe!\n");
				}
			} catch (InputMismatchException e) {
				System.out.println("Conta invalida!\n");
			}
		}
	}

	private static void totalNoBanco() {
		System.out.println("\n--------------------------- Total no banco ---------------------------");
		System.out.println("Usuarios:");
		double total = 0.0;
		for (Conta conta : listaContas) {
			total = total + conta.getSaldo();
			System.out.printf("%s: %.2f\n", conta.getPessoa().getNome(), conta.getSaldo());
		}
		System.out.printf("\nTotal no banco: %f\n", total);

		Arquivos.salvarRelatorioTotalNoBanco("--------------------------- Total no banco ---------------------------",
				listaContas, "Total no banco: " + total);
	}

}
