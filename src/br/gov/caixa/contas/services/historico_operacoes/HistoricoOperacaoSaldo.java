package br.gov.caixa.contas.services.historico_operacoes;

import br.gov.caixa.enums.TipoOperacaoConta;

import java.util.Date;

public class HistoricoOperacaoSaldo extends HistoricoOperacao {

    public HistoricoOperacaoSaldo(Date data, TipoOperacaoConta tipo, double valorReal, int usuarioOrigem, String observacao) {
        setData(new Date());
        setTipo(tipo);
        setValorReal(valorReal);
        setUsuarioOrigem(usuarioOrigem);
        setObservacao(observacao);
    }
}
