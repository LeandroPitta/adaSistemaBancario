package br.gov.caixa.contas.services;

import br.gov.caixa.contas.Conta;
import br.gov.caixa.contas.HistoricoAcao;
import br.gov.caixa.enums.TipoAcaoConta;

import java.util.Date;

public class TransferenciaPadrao implements Transferencia {

    @Override
    public void transferir(Conta conta, double valorPretendido, int idDestino) {
        if (valorPretendido > conta.getSaldo()) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            return;
        }
        conta.setSaldo(conta.getSaldo() - valorPretendido);
    }
}
