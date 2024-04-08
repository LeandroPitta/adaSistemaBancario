package br.gov.caixa.contas.services.operacoes;

import br.gov.caixa.contas.Conta;

public class RendimentoInvestimentoPJ implements RendimentoInvestimento {

    private final double TAXARENDIMENTOPJ = 0.02;

    @Override
    public void render(Conta conta) {
        conta.setSaldo(conta.getSaldo() + (conta.getSaldo() * TAXARENDIMENTOPJ));
    }
}
