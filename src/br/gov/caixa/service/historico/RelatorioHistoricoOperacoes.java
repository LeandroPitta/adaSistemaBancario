package br.gov.caixa.service.historico;

import br.gov.caixa.repository.HistoricoRepositorio;

public class RelatorioHistoricoOperacoes {

    public static String gerarRelatorio() {

        StringBuilder relatorio = new StringBuilder();

        HistoricoRepositorio.getInstance().listar().forEach(operacao -> {
            relatorio.append(operacao.toString()).append("\n");
        });

        return relatorio.toString();

    }

}
