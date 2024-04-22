package br.gov.caixa.service.operacoes;

public class RendimentoInvestimentoPJ implements RendimentoInvestimento {

    private final double TAXARENDIMENTOPJ = 0.02;

    @Override
    public void render(Conta conta) {
        conta.setSaldo(conta.getSaldo() + (conta.getSaldo() * TAXARENDIMENTOPJ));
    }
}
