package br.gov.caixa.contas.services.operacoes;

import br.gov.caixa.contas.Conta;

public class TransferenciaContaPj implements Transferencia {

    private final double TARIFADEBITOPJ = 0.005;
    private double valorReal;

    @Override
    public void transferir(Conta conta, double valorPretendido, Conta contaDestino) {
        this.valorReal = valorPretendido + (valorPretendido * TARIFADEBITOPJ);
        if (ConfereSaldoSuficiente.conferir(conta, valorReal)) {
            conta.setSaldo(conta.getSaldo() - valorReal);
            contaDestino.setSaldo(contaDestino.getSaldo() + valorPretendido);
        }
    }

    public double getValorReal() {
        return valorReal;
    }
}
