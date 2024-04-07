package br.gov.caixa.contas.services.operacoes;

import br.gov.caixa.contas.Conta;

public class TransferenciaPadrao implements Transferencia {

    @Override
    public void transferir(Conta conta, double valorPretendido, int idDestino) {
        if (ConfereSaldoSuficiente.conferir(conta, valorPretendido)) {
            conta.setSaldo(conta.getSaldo() - valorPretendido);
        }
    }
}
