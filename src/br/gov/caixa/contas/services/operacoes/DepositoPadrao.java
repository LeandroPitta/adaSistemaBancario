package br.gov.caixa.contas.services.operacoes;

import br.gov.caixa.contas.Conta;

public class DepositoPadrao implements Deposito {

    @Override
    public void depositar(Conta conta, double valorPretendido) {
        conta.setSaldo(conta.getSaldo() + valorPretendido);
   }
}
