package br.gov.caixa.contas.services.historico_operacoes;

import java.util.ArrayList;
import java.util.List;

public class ListaHistoricoOperacoes {

    private static List<HistoricoOperacao> historicoOperacoes = new ArrayList<>();

    public static void adicionarHistoricoOperacao(HistoricoOperacao historicoOperacao) {
        historicoOperacoes.add(historicoOperacao);
    }

    public static List<HistoricoOperacao> getHistoricoOperacoes() {
        return historicoOperacoes;
    }
}
