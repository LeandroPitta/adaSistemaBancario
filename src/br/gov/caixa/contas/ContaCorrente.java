package br.gov.caixa.contas;

import br.gov.caixa.enums.ClassificacaoUsuario;

public final class ContaCorrente extends Conta {

    public ContaCorrente(int idUsuario, ClassificacaoUsuario classificacao) {
        super(idUsuario, classificacao);
    }


    public void investir(double valorPretendido, int idContaDestino) {
        if (valorPretendido > saldo) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            return;
        }
        saldo -= valorPretendido;
    }
}
