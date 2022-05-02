package br.com.serratec.entidadesConta;

import br.com.serratec.entidades.Pessoa;
import br.com.serratec.enums.Agencia;

public class ContaCorrente extends Conta {

    public ContaCorrente(Pessoa pessoa, Agencia agencia) {
        super(pessoa, agencia);
        this.tipoConta = "Corrente";
    }

    @Override
    public String toString() {
        return
                "Dono da Conta:\n"
                        + pessoa
                        + "\nSALDO: "
                        + saldo
                        + "\nTIPO: "
                        + tipoConta;

    }
}