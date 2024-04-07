package br.gov.caixa.contas.services.historico_operacoes;

import br.gov.caixa.enums.TipoOperacaoConta;

import java.util.Date;

public class HistoricoOperacaoSaque extends HistoricoOperacao {
    public HistoricoOperacaoSaque(Date data, TipoOperacaoConta tipo, double valorPretendido, double valorReal, int usuarioOrigem, String observacao) {
        setData(new Date());
        setTipo(tipo);
        setValorPretendido(valorPretendido);
        setValorReal(valorReal);
        setUsuarioOrigem(usuarioOrigem);
        setObservacao(observacao);
    }
}
