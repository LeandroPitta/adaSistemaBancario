package br.gov.caixa.contas.services.operacoes;

import br.gov.caixa.contas.Conta;

public interface Saque {
    void sacar(Conta conta, double valorPretendido);
}
