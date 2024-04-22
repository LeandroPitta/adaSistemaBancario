package br.gov.caixa.service.historico_operacoes;

import br.gov.caixa.util.TipoOperacaoConta;

import java.util.Date;

public class HistoricoOperacaoSaldo extends HistoricoOperacao {

    public HistoricoOperacaoSaldo(Date data, TipoOperacaoConta tipo, double valorReal, Conta contaOrigem, String observacao) {
        setData(new Date());
        setTipo(tipo);
        setValorReal(valorReal);
        setContaOrigem(contaOrigem);
        setObservacao(observacao);
        ListaHistoricoOperacoes.adicionarHistoricoOperacao(this);
    }
}
