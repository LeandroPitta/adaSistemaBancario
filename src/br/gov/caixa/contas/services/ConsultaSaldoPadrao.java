package br.gov.caixa.contas.services;

import br.gov.caixa.contas.Conta;

public class ConsultaSaldoPadrao implements ConsultaSaldo{

    @Override
    public double consultarSaldo(Conta conta) {
        return conta.getSaldo();
    }
}
