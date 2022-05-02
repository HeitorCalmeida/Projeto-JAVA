package br.com.serratec.entidades;

import br.com.serratec.entidadesConta.Conta;
import br.com.serratec.enums.Agencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Arquivos {
    public static void salvarOperacao(String tipo, Double valor, Double taxa, Integer conta, String done) {
        System.out.println("Salvando operação...");
        File arquivo = new File("operacoes.csv");
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Ocorreu um erro durante a criação do arquivo");
            }
        }

        try {
            FileWriter escritorArquivo = new FileWriter(arquivo, true);
            BufferedWriter escritorBffArquivo = new BufferedWriter(escritorArquivo);

            escritorBffArquivo.write(tipo + ", " + valor + ", " + taxa + ", " + conta + ", " + done);
            escritorBffArquivo.newLine();

            escritorBffArquivo.flush();
            escritorBffArquivo.close();
            escritorArquivo.close();
            System.out.println("Operação salva!!!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a escrita do arquivo");
        }
    }

    public static void salvarRelatorioTotalNoBanco(String titulo, List<Conta> dados, String extra) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Salvando operação...");
        File arquivo = new File("totalNoBanco"+dtf.format(now)+".txt");
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Ocorreu um erro durante a criação do arquivo");
            }
        }

        try {
            FileWriter escritorArquivo = new FileWriter(arquivo, true);
            BufferedWriter escritorBffArquivo = new BufferedWriter(escritorArquivo);

            escritorBffArquivo.write(titulo);
            escritorBffArquivo.newLine();
            escritorBffArquivo.newLine();
            for(Conta conta : dados){
                escritorBffArquivo.write(conta.getPessoa().getNome() +": "+conta.getSaldo());
                escritorBffArquivo.newLine();
            }
            escritorBffArquivo.write(extra);
            escritorBffArquivo.newLine();

            escritorBffArquivo.flush();
            escritorBffArquivo.close();
            escritorArquivo.close();
            System.out.println("Operação salva!!!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a escrita do arquivo");
        }
    }

    public static void salvarRelatorioTotalClientes(String titulo, List<Conta> dados) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Salvando operação...");
        File arquivo = new File("totalClientes"+dtf.format(now)+".txt");
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Ocorreu um erro durante a criação do arquivo");
            }
        }

        try {
            FileWriter escritorArquivo = new FileWriter(arquivo, true);
            BufferedWriter escritorBffArquivo = new BufferedWriter(escritorArquivo);

            escritorBffArquivo.write(titulo);
            escritorBffArquivo.newLine();
            escritorBffArquivo.newLine();
            for(Conta conta : dados){
                escritorBffArquivo.write("Dono: " + conta.getPessoa().getNome() + " / Cpf: " + conta.getPessoa().getCpf() + " / Conta: " + conta.getNumeroConta() + " / Tipo: " + conta.getTipoConta() + " / Agencia: " + conta.getAgencia().toString());
                escritorBffArquivo.newLine();
            }

            escritorBffArquivo.flush();
            escritorBffArquivo.close();
            escritorArquivo.close();
            System.out.println("Operação salva!!!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a escrita do arquivo");
        }
    }

    public static void salvarRelatorioClientesAgencia(String titulo, List<Conta> dados, Agencia agencia) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Salvando operação...");
        File arquivo = new File("totalClientesAgencia"+dtf.format(now)+".txt");
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Ocorreu um erro durante a criação do arquivo");
            }
        }

        try {
            FileWriter escritorArquivo = new FileWriter(arquivo, true);
            BufferedWriter escritorBffArquivo = new BufferedWriter(escritorArquivo);

            escritorBffArquivo.write(titulo);
            escritorBffArquivo.newLine();
            escritorBffArquivo.newLine();
            for (Conta conta : dados) {
                if (conta.getAgencia() == agencia) {
                    escritorBffArquivo.write("Conta: " + conta.getNumeroConta() + " / Tipo: " + conta.getTipoConta() + " / Dono: " + conta.getPessoa().getNome() + " / Agencia: " + agencia.toString());
                    escritorBffArquivo.newLine();
                }
            }

            escritorBffArquivo.flush();
            escritorBffArquivo.close();
            escritorArquivo.close();
            System.out.println("Operação salva!!!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a escrita do arquivo");
        }
    }

    public static void salvarRelatorioClientesAgenciaGerente(String titulo, List<Conta> dados, Agencia agencia) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Salvando operação...");
        File arquivo = new File("totalClientesAgenciaGerente"+dtf.format(now)+".txt");
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Ocorreu um erro durante a criação do arquivo");
            }
        }

        try {
            FileWriter escritorArquivo = new FileWriter(arquivo, true);
            BufferedWriter escritorBffArquivo = new BufferedWriter(escritorArquivo);

            escritorBffArquivo.write(titulo);
            escritorBffArquivo.newLine();
            escritorBffArquivo.newLine();
            for (Conta conta : dados) {
                if (conta.getAgencia() == agencia) {
                    escritorBffArquivo.write("Conta: " + conta.getNumeroConta() + " / Tipo: " + conta.getTipoConta() + " / Dono: " + conta.getPessoa().getNome() + " / Agencia: " + agencia.toString());
                    escritorBffArquivo.newLine();
                }
            }

            escritorBffArquivo.flush();
            escritorBffArquivo.close();
            escritorArquivo.close();
            System.out.println("Operação salva!!!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a escrita do arquivo");
        }
    }

    public static void salvarRelatorioSaldo(String titulo, Conta conta) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Salvando operação...");
        File arquivo = new File("saldo"+dtf.format(now)+".txt");
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Ocorreu um erro durante a criação do arquivo");
            }
        }

        try {
            FileWriter escritorArquivo = new FileWriter(arquivo, true);
            BufferedWriter escritorBffArquivo = new BufferedWriter(escritorArquivo);

            escritorBffArquivo.write(titulo);
            escritorBffArquivo.newLine();
            escritorBffArquivo.newLine();

            escritorBffArquivo.write("Conta: " + conta.getNumeroConta());
            escritorBffArquivo.newLine();
            escritorBffArquivo.write("Tipo: " + conta.getTipoConta());
            escritorBffArquivo.newLine();
            escritorBffArquivo.write("Saldo: " + conta.getSaldo());
            escritorBffArquivo.newLine();

            escritorBffArquivo.flush();
            escritorBffArquivo.close();
            escritorArquivo.close();
            System.out.println("Operação salva!!!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a escrita do arquivo");
        }
    }

    public static void salvarRelatorioTaxas(String titulo, Conta conta) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Salvando operação...");
        File arquivo = new File("taxas"+dtf.format(now)+".txt");
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Ocorreu um erro durante a criação do arquivo");
            }
        }

        try {
            FileWriter escritorArquivo = new FileWriter(arquivo, true);
            BufferedWriter escritorBffArquivo = new BufferedWriter(escritorArquivo);

            escritorBffArquivo.write(titulo);
            escritorBffArquivo.newLine();
            escritorBffArquivo.newLine();

            escritorBffArquivo.write("Total pago: " + conta.getTaxasPagasTotal());
            escritorBffArquivo.newLine();
            escritorBffArquivo.write("Taxa deposito/saque: " + conta.getTaxa());
            escritorBffArquivo.newLine();
            escritorBffArquivo.write("Taxa tranferencia: " + conta.getTaxaTrans());
            escritorBffArquivo.newLine();
            escritorBffArquivo.newLine();
            escritorBffArquivo.write("---- Detalhes ----");
            escritorBffArquivo.newLine();
            for (String taxas : conta.getTaxasPagas()) {
                escritorBffArquivo.write(taxas);
                escritorBffArquivo.newLine();
            }

            escritorBffArquivo.flush();
            escritorBffArquivo.close();
            escritorArquivo.close();
            System.out.println("Operação salva!!!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a escrita do arquivo");
        }
    }

    public static void salvarRelatorioSimulacao(String titulo, Double valorInicial, Integer dias, Double valorFinal) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Salvando operação...");
        File arquivo = new File("simulacaoPoupanca"+dtf.format(now)+".txt");
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                System.out.println("Ocorreu um erro durante a criação do arquivo");
            }
        }

        try {
            FileWriter escritorArquivo = new FileWriter(arquivo, true);
            BufferedWriter escritorBffArquivo = new BufferedWriter(escritorArquivo);

            escritorBffArquivo.write(titulo);
            escritorBffArquivo.newLine();
            escritorBffArquivo.newLine();

            escritorBffArquivo.write("Valor inicia: " + valorInicial);
            escritorBffArquivo.newLine();
            escritorBffArquivo.write("Dias: " + dias);
            escritorBffArquivo.newLine();
            escritorBffArquivo.write("Rendimento " + valorFinal);
            escritorBffArquivo.newLine();

            escritorBffArquivo.flush();
            escritorBffArquivo.close();
            escritorArquivo.close();
            System.out.println("Operação salva!!!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro durante a escrita do arquivo");
        }
    }
}
