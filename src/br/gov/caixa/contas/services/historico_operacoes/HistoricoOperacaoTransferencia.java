package br.gov.caixa.contas.services.historico_operacoes;

import br.gov.caixa.enums.TipoOperacaoConta;

import java.util.Date;

public class HistoricoOperacaoTransferencia extends HistoricoOperacao {

    public HistoricoOperacaoTransferencia(Date data, TipoOperacaoConta tipo, double valorPretendido, double valorReal, int usuarioOrigem, int usuarioDestino, String observacao) {
        setData(new Date());
        setTipo(tipo);
        setValorPretendido(valorPretendido);
        setValorReal(valorReal);
        setUsuarioOrigem(usuarioOrigem);
        setUsuarioDestino(usuarioDestino);
        setObservacao(observacao);
    }
}
