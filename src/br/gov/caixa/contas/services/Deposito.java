package br.gov.caixa.contas.services;

import br.gov.caixa.contas.Conta;

public interface Deposito {

    void depositar(Conta conta, double valorPretendido);
}
