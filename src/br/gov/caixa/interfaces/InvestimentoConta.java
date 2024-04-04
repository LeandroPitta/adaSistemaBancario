package br.gov.caixa.interfaces;

public interface InvestimentoConta extends Conta {
    void investir(double valorPretendido, int idContaDestino);
}
