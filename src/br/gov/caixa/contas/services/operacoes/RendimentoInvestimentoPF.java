package br.gov.caixa.contas.services.operacoes;

import br.gov.caixa.contas.Conta;

public class RendimentoInvestimentoPF implements RendimentoInvestimento {

    private final double TAXARENDIMENTOPF = 0.01;

    @Override
    public void render(Conta conta) {
        conta.setSaldo(conta.getSaldo() + (conta.getSaldo() * TAXARENDIMENTOPF));
    }
}
