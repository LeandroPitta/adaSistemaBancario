package br.gov.caixa.service.operacoes;

public class DepositoPadrao implements Deposito {

    @Override
    public void depositar(Conta conta, double valorPretendido) {
        conta.setSaldo(conta.getSaldo() + valorPretendido);
   }
}
