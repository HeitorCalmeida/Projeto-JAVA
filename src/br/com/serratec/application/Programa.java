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

import static br.com.serratec.enums.Agencia.*;

public class Programa {

    private static final Scanner sc = new Scanner(System.in);
    private static Pessoa usuario = null;

    public static void main(String[] args) {

        //- Cria os objetos do tipo pessoa e coloca em uma lista -------------------------------------------------------
        List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
        List<Conta> listaContas = new ArrayList<Conta>();

        Pessoa cl1 = new Cliente("77345678910", "Pedro", "22374");
        Conta cl1Conta1 = new ContaPoupanca(cl1, A001, 0.15);
        Conta cl1Conta2 = new ContaCorrente(cl1, A002, 7000.00);
        listaPessoas.add(cl1);
        listaContas.add(cl1Conta1);
        listaContas.add(cl1Conta2);

        Pessoa dir1 = new Diretor("13128451550", "Gabriel", "12345");
        Conta dir1Conta1 = new ContaPoupanca(dir1, A001, 0.15);
        Conta dir1Conta2 = new ContaCorrente(dir1, A002, 7000.00);
        listaPessoas.add(dir1);
        listaContas.add(dir1Conta1);
        listaContas.add(dir1Conta2);

        Pessoa dir2 = new Diretor("06445419155", "Leticia", "917775");
        Conta dir2Conta1 = new ContaPoupanca(dir2, A001, 0.15);
        Conta dir2Conta2 = new ContaCorrente(dir2, A002, 7000.00);
        listaPessoas.add(dir2);
        listaContas.add(dir2Conta1);
        listaContas.add(dir2Conta2);

        Pessoa ger1 = new Gerente("90345678910", "Amanda", "892374", A001);
        Conta ger1Conta1 = new ContaPoupanca(ger1, A001, 0.15);
        Conta ger1Conta2 = new ContaCorrente(ger1, A002, 7000.00);
        listaPessoas.add(ger1);
        listaContas.add(ger1Conta1);
        listaContas.add(ger1Conta2);


        Pessoa pres1 = new Presidente("00345678910", "Heitor", "00374");
        Conta pres1Conta1 = new ContaPoupanca(pres1, A001, 0.15);
        Conta pres1Conta2 = new ContaCorrente(pres1, A002, 7000.00);
        listaPessoas.add(pres1);
        listaContas.add(pres1Conta1);
        listaContas.add(pres1Conta2);
        //--------------------------------------------------------------------------------------------------------------


        //- Faz o login do usuario
        boolean estaLogado = false;
        while (!estaLogado){
            usuario = login(listaPessoas);
            if(usuario != null){
                estaLogado = true;
            }
        }
        menu();

        //--------------------------------------------------------------------------------------------------------------

        sc.close();
    }

    private static Pessoa login(List<Pessoa> listaPessoas){
        System.out.print("------------- LOGIN -------------\nDigite seu CPF: ");
        String cpf = sc.next();
        System.out.print("Digite sua senha: ");
        String senha = sc.next();
        System.out.print("---------------------------------\n");

        for (Pessoa auth : listaPessoas) {
            if (auth.getCpf().equals(cpf)) {
                if (auth.getSenha().equals(senha)) {
                    System.out.println("Autenticado com sucesso!");
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

    private static void menu(){
        String opt = "" +
                "\n------------------- Escolha a operação desejada ------------------- " +
                "\n1 - oi" +
                "\n2 - oioi" +
                "\n3 - oioioi";
        if(usuario.getTipo() == 1){
            menuCliente((Cliente) usuario, opt);
        }
        if(usuario.getTipo() == 2){
            menuGerente((Gerente) usuario, opt);
        }
        if(usuario.getTipo() == 3){
            menuDiretor((Diretor) usuario, opt);
        }
        if(usuario.getTipo() == 4){
            menuPresidente((Presidente) usuario, opt);
        }
    }

    private static void menuCliente(Cliente cliente, String opt){
        opt = opt + "\n04 - Cliente";
        System.out.println(opt);
    }

    private static void menuGerente(Gerente gerente, String opt){

    }

    private static void menuDiretor(Diretor diretor, String opt){
        opt = opt + "\n04 - Diretor";
        System.out.println(opt);
    }

    private static void menuPresidente(Presidente presidente, String opt){

    }

}
