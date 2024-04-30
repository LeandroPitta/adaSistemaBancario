package br.gov.caixa.repository;

import br.gov.caixa.service.HistoricoService;

import java.util.ArrayList;
import java.util.List;

public class HistoricoRepositorio {

    private List<HistoricoService> lista = new ArrayList<>();

    private static HistoricoRepositorio instance;

    private HistoricoRepositorio() {
    }

    public static HistoricoRepositorio getInstance() {
        if (instance == null) {
            instance = new HistoricoRepositorio();
        }
        return instance;
    }

    public List<HistoricoService> listar() {
        return lista;
    }

    public void adicionar(HistoricoService item) {
        lista.add(item);
    }
}
