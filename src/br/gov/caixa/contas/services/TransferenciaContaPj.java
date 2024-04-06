package br.gov.caixa.contas.services;

import br.gov.caixa.contas.Conta;
import br.gov.caixa.enums.ClassificacaoUsuario;

public class TransferenciaContaPj implements Transferencia {

    @Override
    public void transferir(Conta conta, double valorPretendido, int idDestino) {
        if (valorPretendido > conta.getSaldo()) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            return;
        }
        conta.setSaldo(conta.getSaldo() - (valorPretendido * 0.005));
    }
}
