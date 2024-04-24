package br.gov.caixa.service;

import br.gov.caixa.model.Conta;

public class RendimentoInvestimento {

    private static final double TAXARENDIMENTOPF = 0.01;
    private static final double TAXARENDIMENTOPJ = 0.02;

    public static void render(Conta conta) {
        if (conta.getCliente().getTipoCliente().equals("CLIENTE_PF")) {
            conta.setSaldo(conta.getSaldo() + (conta.getSaldo() * TAXARENDIMENTOPF));
        } else if (conta.getCliente().getTipoCliente().equals("CLIENTE_PJ")) {
            conta.setSaldo(conta.getSaldo() + (conta.getSaldo() * TAXARENDIMENTOPJ));
        }
    }
}
