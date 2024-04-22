package br.gov.caixa.service.operacoes;

public class InvestimentoPadrao implements Investimento {

    @Override
    public void investir(Conta conta, double valorPretendido, Conta contaInvestimento) {
        if (ConfereSaldoSuficiente.conferir(conta, valorPretendido)) {
            conta.setSaldo(conta.getSaldo() - valorPretendido);
            contaInvestimento.setSaldo(contaInvestimento.getSaldo() + valorPretendido);
        }
    }
}
