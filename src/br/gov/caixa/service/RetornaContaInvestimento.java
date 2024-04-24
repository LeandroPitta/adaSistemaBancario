package br.gov.caixa.service;

import br.gov.caixa.model.Conta;
import br.gov.caixa.model.ContaInvestimento;

import java.util.List;

public class RetornaContaInvestimento {

    public static Conta retornarConta(List<Conta> contas, Long idCliente) {
        return contas.stream()
                .filter(conta -> conta.getCliente().getId() == idCliente && conta instanceof ContaInvestimento)
                .findFirst()
                .orElseGet(() -> new ContaInvestimento(idCliente));  //CORRIGIR POIS idCliente DEVE SER conta.getCliente()
    }
}
