package br.gov.caixa.contas.services.operacoes;

import br.gov.caixa.contas.Conta;

public interface Transferencia {

    void transferir(Conta conta, double valorPretendido, Conta contaDestino);
}
