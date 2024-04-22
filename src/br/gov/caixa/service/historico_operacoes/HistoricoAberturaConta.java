package br.gov.caixa.service.historico_operacoes;

import br.gov.caixa.util.TipoOperacaoConta;

import java.util.Date;

public class HistoricoAberturaConta extends HistoricoOperacao {

    public HistoricoAberturaConta(Date data, TipoOperacaoConta tipo, Conta contaOrigem, String observacao) {
        setContaOrigem(contaOrigem);
        setTipo(tipo);
        setData(new Date());
        setObservacao(observacao);
        ListaHistoricoOperacoes.adicionarHistoricoOperacao(this);
    }
}
