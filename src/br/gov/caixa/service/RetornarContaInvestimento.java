package br.gov.caixa.service;

import br.gov.caixa.model.Conta;
import br.gov.caixa.model.ContaInvestimento;

import java.util.List;

public class RetornarContaInvestimento {

    public static Conta retornarConta(List<Conta> contas, Long idCliente) {
        return contas.stream()
                .filter(conta -> conta.getIdCliente() == idCliente && conta instanceof ContaInvestimento)
                .findFirst()
                .orElseGet(() -> new ContaInvestimento(idCliente));
    }
}
