package br.gov.caixa.service.historico_operacoes;

import br.gov.caixa.service.TipoOperacaoConta;

import java.util.Date;

public class HistoricoOperacaoTransferencia extends HistoricoOperacao {

    public HistoricoOperacaoTransferencia(Date data, TipoOperacaoConta tipo, double valorPretendido, double valorReal, Conta contaOrigem, Conta contaDestino, String observacao) {
        setData(new Date());
        setTipo(tipo);
        setValorPretendido(valorPretendido);
        setValorReal(valorReal);
        setContaOrigem(contaOrigem);
        setContaDestino(contaDestino);
        setObservacao(observacao);
        ListaHistoricoOperacoes.adicionarHistoricoOperacao(this);
    }
}
