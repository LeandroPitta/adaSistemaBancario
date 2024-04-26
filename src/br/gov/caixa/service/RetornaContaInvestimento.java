package br.gov.caixa.service;

import br.gov.caixa.model.Cliente;
import br.gov.caixa.model.Conta;
import br.gov.caixa.model.ContaInvestimento;

import java.util.List;

public class RetornaContaInvestimento {

    public static Conta retornarConta(List<Conta> contas, Long idCliente) {
        Cliente cliente;
        return contas.stream()
                .filter(conta -> conta.getCliente().getId() == idCliente && conta instanceof ContaInvestimento)
                .findFirst()
                .orElseGet(() -> new ContaInvestimento(conta.get));  //CORRIGIR POIS idCliente DEVE SER conta.getCliente()
    }
}
