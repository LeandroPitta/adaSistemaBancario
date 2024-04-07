package br.gov.caixa.contas.services.operacoes;

import br.gov.caixa.contas.Conta;

public interface Deposito {

    void depositar(Conta conta, double valorPretendido);
}
