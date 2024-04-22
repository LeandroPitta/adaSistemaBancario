package br.gov.caixa.service.operacoes;

public interface Transferencia {

    void transferir(Conta conta, double valorPretendido, Conta contaDestino);
}
