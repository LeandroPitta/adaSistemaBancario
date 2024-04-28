package br.gov.caixa.repository;

import br.gov.caixa.service.historico.Historico;

import java.util.ArrayList;
import java.util.List;

public class HistoricoRepositorio {

    private List<Historico> lista = new ArrayList<>();

    private static HistoricoRepositorio instance;

    private HistoricoRepositorio() {
    }

    public static HistoricoRepositorio getInstance() {
        if (instance == null) {
            instance = new HistoricoRepositorio();
        }
        return instance;
    }

    public List<Historico> listar() {
        return lista;
    }

    public void adicionar(Historico item) {
        lista.add(item);
    }
}
