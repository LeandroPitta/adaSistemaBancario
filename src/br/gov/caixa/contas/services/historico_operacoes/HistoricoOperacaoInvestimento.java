package br.gov.caixa.contas.services.historico_operacoes;

import br.gov.caixa.contas.Conta;
import br.gov.caixa.enums.TipoOperacaoConta;

import java.util.Date;

public class HistoricoOperacaoInvestimento extends HistoricoOperacao {

    public HistoricoOperacaoInvestimento(Date data, TipoOperacaoConta tipo, double valorPretendido, double valorReal, Conta contaOrigem, String observacao) {
        setData(new Date());
        setTipo(tipo);
        setValorPretendido(valorPretendido);
        setValorReal(valorReal);
        setContaOrigem(contaOrigem);
        setObservacao(observacao);
    }
}
