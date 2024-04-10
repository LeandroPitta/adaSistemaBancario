package br.gov.caixa.aplicacao.acao;

import br.gov.caixa.contas.Conta;
import br.gov.caixa.contas.services.historico_operacoes.*;

public class RelatorioHistoricoOperacoes {

    public String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder();

        for (HistoricoOperacao historicoOperacao : ListaHistoricoOperacoes.getHistoricoOperacoes()) {
            concatenarNaoNulo(relatorio, "\nData: ", historicoOperacao.getData());
            concatenarNaoNulo(relatorio, "Tipo: ", historicoOperacao.getTipo());
            concatenarNaoNulo(relatorio, "Valor Pretendido: ", historicoOperacao.getValorPretendido());
            concatenarNaoNulo(relatorio, "Valor Real: ", historicoOperacao.getValorReal());
            concatenarNaoNulo(relatorio, "Conta Origem: ", historicoOperacao.getContaOrigem());
            concatenarNaoNulo(relatorio, "Conta Destino: ", historicoOperacao.getContaDestino());
            concatenarNaoNulo(relatorio, "Observação: ", historicoOperacao.getObservacao());
            relatorio.append("-------------------------------------------------------------------------------\n"); }

        return relatorio.toString();
    }

    private StringBuilder concatenarNaoNulo(StringBuilder concatenar, String campo, Object objeto) {
        if (objeto != null) {
            if (objeto instanceof Conta) {
                if (objeto != null) {
                    Conta conta = (Conta) objeto;
                    concatenar.append(campo).append(conta.getId()).append("\n");
                }
            } else {
                concatenar.append(campo).append(objeto).append("\n");
            }
        }
        return concatenar;
    }
}
