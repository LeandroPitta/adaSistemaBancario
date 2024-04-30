package br.gov.caixa.service;

import br.gov.caixa.model.Cliente;
import br.gov.caixa.model.Conta;
import br.gov.caixa.model.ContaCorrente;
import br.gov.caixa.model.ContaPoupanca;
import br.gov.caixa.repository.ContaRepositorio;

public class ContaService {

    private static ContaService instance;

    private ContaService() {}

    public static ContaService getInstance() {
        if (instance == null) {
            instance = new ContaService();
        }
        return instance;
    }

    public Conta aberturaContaCorrente(Cliente cliente) {

        Conta conta = new ContaCorrente(cliente);
        cliente.addEmContas(conta);
        ContaRepositorio.getInstance().adicionar(conta);
        HistoricoService.historicoAberturaConta(conta);
        return conta;
    }

    public Conta aberturaContaPoupanca(Cliente cliente) {

        Conta conta = new ContaPoupanca(cliente);
        cliente.addEmContas(conta);
        ContaRepositorio.getInstance().adicionar(conta);
        HistoricoService.historicoAberturaConta(conta);
        return conta;
    }
}
