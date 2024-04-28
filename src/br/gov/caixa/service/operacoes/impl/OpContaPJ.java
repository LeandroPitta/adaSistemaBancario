package br.gov.caixa.service.operacoes.impl;

import br.gov.caixa.model.ClientePJ;
import br.gov.caixa.model.Conta;
import br.gov.caixa.model.ContaInvestimento;
import br.gov.caixa.repository.ContaRepositorio;
import br.gov.caixa.service.historico.HistoricoInvestimento;
import br.gov.caixa.service.historico.HistoricoSaque;
import br.gov.caixa.service.operacoes.OpConta;

import java.math.BigDecimal;

public class OpContaPJ implements OpConta<ClientePJ> {

    private static final BigDecimal TAXA_RETIRADA = BigDecimal.valueOf(1.005);

    @Override
    public void investir(ClientePJ cliente, BigDecimal valor) {

        Conta conta = OpConta.super.getContaInvestimentoCliente(cliente);
        if (conta == null) {
            conta = new ContaInvestimento(cliente);
            ContaRepositorio.getInstance().adicionar(conta);
        }
        conta.setSaldo(conta.getSaldo().add(valor));

        HistoricoInvestimento.salvar(valor, cliente.getContas().get(0), conta);

    }

    @Override
    public void sacar(ClientePJ cliente, long idConta, BigDecimal valor) {

        Conta conta = OpConta.super.getContaCliente(cliente, idConta);
        BigDecimal valorComTaxa = valor.multiply(TAXA_RETIRADA);
        OpConta.super.verificarSaldo(conta, valorComTaxa);
        conta.setSaldo(conta.getSaldo().subtract(valorComTaxa));

        HistoricoSaque.salvar(valor, valorComTaxa, conta);
    }

}
