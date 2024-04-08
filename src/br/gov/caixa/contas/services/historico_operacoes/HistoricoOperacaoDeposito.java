package br.gov.caixa.contas.services.historico_operacoes;

import br.gov.caixa.enums.TipoOperacaoConta;

import java.util.Date;

public class HistoricoOperacaoDeposito extends HistoricoOperacao {

    public HistoricoOperacaoDeposito(Date data, TipoOperacaoConta tipo, double valorPretendido, double valorReal, int usuarioDestino, String observacao) {
        setData(new Date());
        setTipo(tipo);
        setValorPretendido(valorPretendido);
        setValorReal(valorReal);
        setUsuarioDestino(usuarioDestino);
        setObservacao(observacao);
    }
}
