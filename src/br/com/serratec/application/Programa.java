package br.com.serratec.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.serratec.entidades.Cliente;
import br.com.serratec.entidades.Diretor;
import br.com.serratec.entidades.Gerente;
import br.com.serratec.entidades.Pessoa;
import br.com.serratec.entidades.Presidente;

public class Programa {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //- Cria os objetos do tipo pessoa e coloca em uma lista -------------------------------------------------------
        List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

        Pessoa dir = new Diretor("13128451550", "Gabriel", "12345");
        listaPessoas.add(dir);

        Pessoa dir2 = new Diretor("06445419155", "Leticia", "917775");
        listaPessoas.add(dir2);

        Pessoa cl1 = new Cliente("77345678910", "Pedro", "22374");
        listaPessoas.add(cl1);

        Pessoa ger1 = new Gerente("90345678910", "Amanda", "892374");
        listaPessoas.add(ger1);

        Pessoa pres1 = new Presidente("00345678910", "Heitor", "00374");
        listaPessoas.add(pres1);
        //--------------------------------------------------------------------------------------------------------------


        //- Faz o login do usuario
        boolean estaLogado = false;
        Pessoa usuario = null;
        while (!estaLogado){
            usuario = login(listaPessoas);
            if(usuario != null){
                estaLogado = true;
            }
        }
        //--------------------------------------------------------------------------------------------------------------

        System.out.println(usuario.getNome());

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

}
