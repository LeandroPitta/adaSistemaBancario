package br.gov.caixa.service.operacoes.impl;

import br.gov.caixa.model.ClientePF;
import br.gov.caixa.model.Conta;
import br.gov.caixa.model.ContaInvestimento;
import br.gov.caixa.repository.ContaRepositorio;
import br.gov.caixa.service.historico.HistoricoInvestimento;
import br.gov.caixa.service.historico.HistoricoSaque;
import br.gov.caixa.service.operacoes.OpConta;

import java.math.BigDecimal;

public class OpContaPF implements OpConta<ClientePF> {

    @Override
    public void sacar(ClientePF cliente, long idConta, BigDecimal valor) {

        Conta conta = OpConta.super.getContaCliente(cliente, idConta);
        OpConta.super.verificarSaldo(conta, valor);
        conta.setSaldo(conta.getSaldo().subtract(valor));

        HistoricoSaque.salvar(valor, valor, conta);
    }

    @Override
    public void investir(ClientePF cliente, BigDecimal valor) {

        Conta conta = OpConta.super.getContaInvestimentoCliente(cliente);
        if (conta == null) {
            conta = new ContaInvestimento(cliente);
            ContaRepositorio.getInstance().adicionar(conta);
        }
        conta.setSaldo(conta.getSaldo().add(valor));

        HistoricoInvestimento.salvar(valor, cliente.getContas().get(0), conta);

    }

}
