package br.com.serratec.entidadesConta;

import br.com.serratec.entidades.Arquivos;
import br.com.serratec.entidades.Pessoa;
import br.com.serratec.enums.Agencia;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {

    protected Double saldo;
    // Esse atributo poderia ser estático, já que uma conta corrente sempre será do tipo corrente, por exemplo.
    // Inclusive, poderia ser um enum para limitar melhor as opções
    protected String tipoConta;
    protected Pessoa pessoa;
    protected List<String> taxasPagas = new ArrayList<String>();
    protected Double taxasPagasTotal;
    protected Agencia agencia;
    protected Integer numeroConta;
    // Essas taxas poderia ser externas à conta. Poderiam estar em um enum
    protected Double taxa;
    protected Double taxaTrans;

    public Conta(Pessoa pessoa, Agencia agencia) {
        this.pessoa = pessoa;
        this.agencia = agencia;
        this.saldo = 0.00;
        this.taxasPagasTotal = 0.00;
        this.taxa = 0.10;
        this.taxaTrans = 0.20;
        // Boa ideia, um algoritmo mais aleatório seria usar a própria função de hash do java para gerar o numero da conta
        this.numeroConta = (int) Math.floor(Math.random() * (999999999 - 1 + 1) + 0);

    }

    public Double getSaldo() {
        return this.saldo;
    }

    public void receberTrans(Double quantidade) {
        this.saldo = this.saldo + quantidade;
    }

    public Boolean deposito(Double quantidade) {
        try {
            if (quantidade > this.taxa) {
                this.saldo += (quantidade - this.taxa);
                this.taxasPagasTotal = (this.taxasPagasTotal + this.taxa);
                this.taxasPagas.add("Taxa de deposito: " + this.taxa);
                Arquivos.salvarOperacao("Deposito", quantidade, this.taxa, this.numeroConta, this.pessoa.getNome());
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Boolean saque(Double quantidade) {
        try {
            if (this.saldo >= (quantidade + this.taxa)) {
                this.saldo = this.saldo - (quantidade + this.taxa);
                this.taxasPagasTotal = (this.taxasPagasTotal + this.taxa);
                this.taxasPagas.add("Taxa de saque: " + this.taxa);
                Arquivos.salvarOperacao("Saque", quantidade, this.taxa, this.numeroConta, this.pessoa.getNome());
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    public Boolean transferencia(Double quantidade, Conta contaDestino) {
        try {
            if (this.saldo >= (quantidade + this.taxaTrans)) {
                this.saldo = this.saldo - (quantidade + this.taxaTrans);
                contaDestino.receberTrans(quantidade);
                this.taxasPagasTotal = (this.taxasPagasTotal + this.taxaTrans);
                this.taxasPagas.add("Taxa de tranferencia: " + this.taxaTrans);
                Arquivos.salvarOperacao("Tranferencia", quantidade, this.taxaTrans, this.numeroConta, this.pessoa.getNome());
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }

    }

    public String getTipoConta() {
        return this.tipoConta;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public Double getTaxasPagasTotal() {
        return this.taxasPagasTotal;
    }

    public List<String> getTaxasPagas() {
        return this.taxasPagas;
    }

    public Double getTaxa() {
        return this.taxa;
    }

    public Double getTaxaTrans() {
        return this.taxaTrans;
    }

    public Integer getNumeroConta() {
        return this.numeroConta;
    }

    public Agencia getAgencia() {
        return this.agencia;
    }

    @Override
    public String toString() {
        return "Dono da Conta:\n" + this.pessoa + "\nSALDO: " + this.saldo + "\nTIPO: " + this.tipoConta + "\nNUMERO DA CONTA: " + this.numeroConta;

    }

}
