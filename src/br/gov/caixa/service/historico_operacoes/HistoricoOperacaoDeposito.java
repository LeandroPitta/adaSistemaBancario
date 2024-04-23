package br.gov.caixa.service.historico_operacoes;

import br.gov.caixa.service.TipoOperacaoConta;

import java.util.Date;

public class HistoricoOperacaoDeposito extends HistoricoOperacao {

    public HistoricoOperacaoDeposito(Date data, TipoOperacaoConta tipo, double valorPretendido, double valorReal, Conta contaDestino, String observacao) {
        setData(new Date());
        setTipo(tipo);
        setValorPretendido(valorPretendido);
        setValorReal(valorReal);
        setContaDestino(contaDestino);
        setObservacao(observacao);
        ListaHistoricoOperacoes.adicionarHistoricoOperacao(this);
    }
}
