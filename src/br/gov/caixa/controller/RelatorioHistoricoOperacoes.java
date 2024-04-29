package br.gov.caixa.controller;

import br.gov.caixa.model.Conta;
import br.gov.caixa.repository.HistoricoRepositorio;

public class RelatorioHistoricoOperacoes {

    public String gerarRelatorio() {
        String relatorio = HistoricoRepositorio.getInstance().listar().toString();
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
