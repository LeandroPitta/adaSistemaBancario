package br.gov.caixa.contas.services.operacoes;

import br.gov.caixa.contas.Conta;

public abstract class ConfereSaldoSuficiente {

    public static boolean conferir(Conta conta, double valorPretendido) {
        if (valorPretendido > conta.getSaldo()) {
            System.out.println("Saldo insuficiente para realizar a operação.");
            return false;
        }
        return true;
    }
}
