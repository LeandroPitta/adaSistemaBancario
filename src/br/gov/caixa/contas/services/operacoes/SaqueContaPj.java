package br.gov.caixa.contas.services.operacoes;

import br.gov.caixa.contas.Conta;

public class SaqueContaPj implements Saque {

    private final double TARIFADEBITOPJ = 0.005;
    private double valorReal;

    @Override
    public void sacar(Conta conta, double valorPretendido) {
        valorReal = valorPretendido + (valorPretendido * TARIFADEBITOPJ);
        if (ConfereSaldoSuficiente.conferir(conta, valorReal)) {
            conta.setSaldo(conta.getSaldo() - valorReal);
        }
    }
}
