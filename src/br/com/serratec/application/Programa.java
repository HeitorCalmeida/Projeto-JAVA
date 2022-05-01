package br.com.serratec.application;

import java.util.*;

import br.com.serratec.entidades.Cliente;
import br.com.serratec.entidades.Diretor;
import br.com.serratec.entidades.Gerente;
import br.com.serratec.entidades.Pessoa;
import br.com.serratec.entidades.Presidente;
import br.com.serratec.entidadesConta.Conta;
import br.com.serratec.entidadesConta.ContaCorrente;
import br.com.serratec.entidadesConta.ContaPoupanca;

import static br.com.serratec.enums.Agencia.*;
import static java.lang.Thread.sleep;

public class Programa {

    private static final Scanner sc = new Scanner(System.in);
    private static Pessoa usuario = null;
    private static List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
    private static List<Conta> listaContas = new ArrayList<Conta>();

    public static void main(String[] args) {

        sc.useLocale(Locale.ENGLISH);

        //- Cria os objetos do tipo pessoa e coloca em uma lista -------------------------------------------------------
        Pessoa cl1 = new Cliente("77345678910", "Pedro", "22374");
        listaPessoas.add(cl1);
        listaContas.add(new ContaPoupanca(cl1, A001, 0.15));
        listaContas.add(new ContaCorrente(cl1, A002, 7000.00));

        Pessoa dir1 = new Diretor("13128451550", "Gabriel", "12345");
        listaPessoas.add(dir1);
        listaContas.add(new ContaPoupanca(dir1, A001, 0.15));
        listaContas.add(new ContaCorrente(dir1, A002, 7000.00));

        Pessoa dir2 = new Diretor("06445419155", "Leticia", "917775");
        listaPessoas.add(dir2);
        listaContas.add(new ContaPoupanca(dir2, A001, 0.15));
        listaContas.add(new ContaCorrente(dir2, A002, 7000.00));

        Pessoa ger1 = new Gerente("90345678910", "Amanda", "892374", A001);
        listaPessoas.add(ger1);
        listaContas.add(new ContaPoupanca(ger1, A001, 0.15));
        listaContas.add(new ContaCorrente(ger1, A002, 7000.00));


        Pessoa pres1 = new Presidente("00345678910", "Heitor", "00374");
        listaPessoas.add(pres1);
        listaContas.add(new ContaPoupanca(pres1, A001, 0.15));
        listaContas.add(new ContaCorrente(pres1, A002, 7000.00));
        //--------------------------------------------------------------------------------------------------------------


        //- Faz o login do usuario
        while (usuario == null) {
            usuario = login();
        }
        boolean continuar = true;
        boolean erro = false;
        do {
            menu();
            do{
                erro = false;
                try {
                    System.out.print("\nDeseja sair do sistema (s/n): ");
                    String c = sc.next();
                    if(!c.equals("s") && !c.equals("S") && !c.equals("n") && !c.equals("N")){
                        System.out.println("\nOpção invalida!\nInforme uma opção valida!!!");
                        erro = true;
                    }else{
                        if(c.equals("s") || c.equals("S")){
                            continuar = false;
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\nOpção invalida!\nInforme uma opção valida!!!");
                    erro = true;
                    sc.next();
                }
            } while (erro);
        } while (continuar);

        //--------------------------------------------------------------------------------------------------------------

        sc.close();
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

        System.out.println("O usuario não existe!");
        return null;
    }

    private static void menu() {
        String opt = "" +
                "\n------------------- Escolha a operação desejada ------------------- " +
                "\n#Movimentações na Conta#" +
                "\n1 - Saque" +
                "\n2 - Depósito" +
                "\n3 - Transferência" +
                "\n#Relatórios#" +
                "\n4 - Saldo" +
                "\n5 - Tributação da conta corrente" +
                "\n6 - Rendimento da poupança";
        if (usuario.getTipo() == 1) {
            menuCliente((Cliente) usuario, opt);
        }
        if (usuario.getTipo() == 2) {
            menuGerente((Gerente) usuario, opt);
        }
        if (usuario.getTipo() == 3) {
            menuDiretor((Diretor) usuario, opt);
        }
        if (usuario.getTipo() == 4) {
            menuPresidente((Presidente) usuario, opt);
        }
    }

    private static void menuCliente(Cliente cliente, String opt) {
        System.out.println(opt);
        Integer opcoaoEscolhida = null;
        while (opcoaoEscolhida == null) {
            System.out.print("Digite a opção desejada: ");
            try {
                opcoaoEscolhida = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nOpção invalida!\nInforme uma opção valida!!!\n");
            }
        }

        switch (opcoaoEscolhida) {
            case 1:
                fazerSaque();
                break;
            case 2:
                fazerDeposito();
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
            case 6:
                System.out.println("6");
                break;
            default:
                System.out.println("Looking forward to the Weekend");
        }
    }

    private static void menuGerente(Gerente gerente, String opt) {

    }

    private static void menuDiretor(Diretor diretor, String opt) {
        opt = opt + "\n04 - Diretor";
        System.out.println(opt);
    }

    private static void menuPresidente(Presidente presidente, String opt) {

    }

    private static void fazerSaque() {
        Integer contaEscolhida = null;
        boolean continuar = false;
        boolean contaInvalida = true;
        while ((contaEscolhida == null) || (!continuar)) {
            try {
                System.out.println("Escolha uma conta!");
                for (Conta conta : listaContas) {
                    if (conta.getPessoa() == usuario) {
                        System.out.println("Conta: " + conta.getNumeroConta() + " / Tipo: " + conta.getTipoConta());
                    }
                }
                System.out.print("Numero da conta: ");
                contaEscolhida = sc.nextInt();
                for (Conta conta : listaContas) {
                    if (conta.getPessoa() == usuario) {
                        if (conta.getNumeroConta().equals(contaEscolhida)) {
                            contaInvalida = false;
                            continuar = true;

                            System.out.println("\nRealizar saque!");
                            System.out.printf("Saldo: %.2f\n", conta.getSaldo());
                            if (conta.getSaldo() == 0) {
                                try {
                                    System.out.println("Saldo insuficiente para saque!");
                                    sleep(3000);
                                } catch (InterruptedException e) {
                                    continuar = false;
                                    System.out.println("Aconteceu um erro durante a operação!");
                                }
                            } else {
                                try {
                                    System.out.print("Valor para saque: ");
                                    double valorSaque = sc.nextDouble();
                                    if (conta.saque(valorSaque)) {
                                        System.out.println("\nSaque realizado com sucesso!");
                                        System.out.printf("Saldo: %.2f\n", conta.getSaldo());
                                        System.out.println("Taxa paga: " + conta.getTaxa());
                                    }else{
                                        continuar = false;
                                        System.out.println("Não foi possivel realizar o saque, varifique o valor!\n");
                                    }
                                } catch (InputMismatchException e) {
                                    continuar = false;
                                    System.out.println("Valor invalido!");
                                    System.out.println("Informe um valor do tipo double (exemplo: 10.00).");
                                    sc.next();
                                }
                            }
                            break;
                        }
                    }
                }

                if (contaInvalida) {
                    System.out.println("Esta conta não existe!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Conta invalida!");
                sc.next();
            }
        }
    }

    private static void fazerDeposito() {
        Integer contaEscolhida = null;
        boolean continuar = false;
        boolean contaInvalida = true;
        while ((contaEscolhida == null) || (!continuar)) {
            try {
                System.out.println("\nEscolha uma conta!");
                for (Conta conta : listaContas) {
                    if (conta.getPessoa() == usuario) {
                        System.out.println("Conta: " + conta.getNumeroConta() + " / Tipo: " + conta.getTipoConta());
                    }
                }
                System.out.print("Numero da conta: ");
                contaEscolhida = sc.nextInt();
                for (Conta conta : listaContas) {
                    if (conta.getPessoa() == usuario) {
                        if (conta.getNumeroConta().equals(contaEscolhida)) {
                            try {
                                contaInvalida = false;
                                continuar = true;

                                System.out.println("\nRealizar deposito!");
                                System.out.printf("Saldo: %.2f\n", conta.getSaldo());
                                System.out.print("Valor para deposito: ");
                                Double valorDeposito = sc.nextDouble();
                                if (conta.deposito(valorDeposito)) {
                                    System.out.println("\nDeposito realizado com sucesso!");
                                    System.out.printf("Saldo: %.2f\n", conta.getSaldo());
                                    System.out.println("Taxa paga: " + conta.getTaxa());
                                }else{
                                    System.out.println("\nNão foi possivel realizar o deposito!!");
                                    System.out.printf("Saldo: %.2f\n", conta.getSaldo());
                                }
                            } catch (Exception e) {
                                System.out.println(e);
                                continuar = false;
                                System.out.println("Valor invalido!");
                                System.out.println("Informe um valor do tipo double (exemplo: 10.00).\n");
                            }
                            break;
                        }
                    }
                }

                if (contaInvalida) {
                    System.out.println("Esta conta não existe!\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nConta invalida!");
                sc.next();
            }

        }

    }

}
