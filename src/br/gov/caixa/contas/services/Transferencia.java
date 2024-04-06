package br.gov.caixa.contas.services;

import br.gov.caixa.contas.Conta;

public interface Transferencia {

    void transferir(Conta conta, double valorPretendido, int idDestino);
}
