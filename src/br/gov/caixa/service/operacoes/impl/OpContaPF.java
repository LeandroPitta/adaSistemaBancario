package br.gov.caixa.service.operacoes.impl;

import br.gov.caixa.model.ClientePF;
import br.gov.caixa.model.Conta;
import br.gov.caixa.model.ContaInvestimento;
import br.gov.caixa.service.ContaService;
import br.gov.caixa.service.operacoes.OpConta;

import java.math.BigDecimal;

public class OpContaPF implements OpConta<ClientePF> {

    @Override
    public void sacar(ClientePF cliente, long idConta, BigDecimal valor) {
        Conta conta = OpConta.super.getContaCliente(cliente, idConta);
        OpConta.super.verificarSaldo(conta, valor);
        conta.setSaldo(conta.getSaldo().subtract(valor));
    }

    @Override
    public void investir(ClientePF cliente, BigDecimal valor) {
        Conta conta = OpConta.super.getContaInvestimentoCliente(cliente);
        if (conta == null) {
            conta = new ContaInvestimento(cliente);
            ContaService.getInstance().adicionarConta(conta);
        }
        conta.setSaldo(conta.getSaldo().add(valor));
    }

}
