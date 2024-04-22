package br.gov.caixa.service.operacoes;

public class RendimentoInvestimentoPF implements RendimentoInvestimento {

    private final double TAXARENDIMENTOPF = 0.01;

    @Override
    public void render(Conta conta) {
        conta.setSaldo(conta.getSaldo() + (conta.getSaldo() * TAXARENDIMENTOPF));
    }
}
