package br.gov.caixa.controller;

import br.gov.caixa.service.RelatorioClienteService;
import br.gov.caixa.service.RelatorioHistoricoService;

public class RelatoriosController {

    public static String executarRelatorioCliente() {

        return RelatorioClienteService.gerarRelatorio();

    }

    public static String executarRelatorioHistoricoOperacoes() {

        return RelatorioHistoricoService.gerarRelatorio();

    }
}
