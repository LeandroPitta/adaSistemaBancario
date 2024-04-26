package br.gov.caixa.service;

import br.gov.caixa.model.Cliente;
import br.gov.caixa.model.Conta;
import br.gov.caixa.model.ContaInvestimento;

import java.util.List;

public class RetornaContaInvestimento {

    public static Conta retornarConta(Long idCliente) {

        List<Conta> contas = ContaService.listarContas();

        return contas.stream()
                .filter(conta -> conta.getCliente().getId() == idCliente && conta instanceof ContaInvestimento)
                .findFirst()
                .orElseGet(() -> {
                    Cliente cliente = ClienteService.buscarCliente(idCliente);
                    return new ContaInvestimento(cliente);
                });
    }
}