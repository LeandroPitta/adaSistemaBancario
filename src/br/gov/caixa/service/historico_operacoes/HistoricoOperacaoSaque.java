package br.gov.caixa.service.historico_operacoes;

import br.gov.caixa.service.TipoOperacaoConta;

import java.util.Date;

public class HistoricoOperacaoSaque extends HistoricoOperacao {
    public HistoricoOperacaoSaque(Date data, TipoOperacaoConta tipo, double valorPretendido, double valorReal, Conta contaOrigem, String observacao) {
        setData(new Date());
        setTipo(tipo);
        setValorPretendido(valorPretendido);
        setValorReal(valorReal);
        setContaOrigem(contaOrigem);
        setObservacao(observacao);
        ListaHistoricoOperacoes.adicionarHistoricoOperacao(this);
    }
}
