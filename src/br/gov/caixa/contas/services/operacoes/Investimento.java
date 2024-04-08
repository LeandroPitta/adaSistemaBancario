package br.gov.caixa.contas.services.operacoes;

import br.gov.caixa.contas.Conta;

public interface Investimento {
    void investir(Conta conta, double valorPretendido, Conta contaInvestimento);
}
