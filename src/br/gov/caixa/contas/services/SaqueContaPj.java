package br.gov.caixa.contas.services;

import br.gov.caixa.contas.Conta;

public class SaqueContaPj implements Saque {

    @Override
    public void sacar(Conta conta, double valorPretendido) {
        if (valorPretendido > conta.getSaldo()) {
            System.out.println("Saldo insuficiente para realizar o saque.");
            return;
        }
        conta.setSaldo(conta.getSaldo() - (valorPretendido * 0.005));
    }
}
