package br.gov.caixa.contas.services.operacoes;

import br.gov.caixa.contas.Conta;

public class SaquePadrao implements Saque {

    @Override
    public void sacar(Conta conta, double valorPretendido) {
        if (ConfereSaldoSuficiente.conferir(conta, valorPretendido)) {
            conta.setSaldo(conta.getSaldo() - valorPretendido);
        }
    }
}