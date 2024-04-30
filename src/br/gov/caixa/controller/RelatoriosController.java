package br.gov.caixa.controller;

import br.gov.caixa.service.RelatorioCliente;
import br.gov.caixa.service.historico.RelatorioHistoricoOperacoes;

public class RelatoriosController {

    public static String executarRelatorioCliente() {

        return RelatorioCliente.gerarRelatorio();

    }

    public static String executarRelatorioHistoricoOperacoes() {

        return RelatorioHistoricoOperacoes.gerarRelatorio();

    }
}
