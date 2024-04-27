package br.gov.caixa.service.operacoes.impl;

import br.gov.caixa.model.ClientePJ;
import br.gov.caixa.model.Conta;
import br.gov.caixa.model.ContaInvestimento;
import br.gov.caixa.service.ContaService;
import br.gov.caixa.service.operacoes.OpConta;

import java.math.BigDecimal;

public class OpContaPJ implements OpConta<ClientePJ> {

    private static final BigDecimal TAXA_RETIRADA = BigDecimal.valueOf(1.005);

    @Override
    public void investir(ClientePJ cliente, BigDecimal valor) {
        Conta conta = OpConta.super.getContaInvestimentoCliente(cliente);
        if (conta == null) {
            conta = new ContaInvestimento(cliente);
            ContaService.getInstance().adicionarConta(conta);
        }
        conta.setSaldo(conta.getSaldo().add(valor));
    }

    @Override
    public void sacar(ClientePJ cliente, long idConta, BigDecimal valor) {
        Conta conta = OpConta.super.getContaCliente(cliente, idConta);
        valor = valor.multiply(TAXA_RETIRADA);
        OpConta.super.verificarSaldo(conta, valor);
        conta.setSaldo(conta.getSaldo().subtract(valor));
    }

}
