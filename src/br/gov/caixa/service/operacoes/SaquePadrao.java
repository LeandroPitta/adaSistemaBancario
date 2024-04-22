package br.gov.caixa.service.operacoes;

public class SaquePadrao implements Saque {

    @Override
    public void sacar(Conta conta, double valorPretendido) {
        if (ConfereSaldoSuficiente.conferir(conta, valorPretendido)) {
            conta.setSaldo(conta.getSaldo() - valorPretendido);
        }
    }
}