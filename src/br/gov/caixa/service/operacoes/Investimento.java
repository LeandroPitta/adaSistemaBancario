package br.gov.caixa.service.operacoes;

public interface Investimento {
    void investir(Conta conta, double valorPretendido, Conta contaInvestimento);
}
