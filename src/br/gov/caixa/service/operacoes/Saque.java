package br.gov.caixa.service.operacoes;

public interface Saque {
    void sacar(Conta conta, double valorPretendido);
}
