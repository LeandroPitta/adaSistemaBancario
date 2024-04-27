package br.gov.caixa.repository;

import br.gov.caixa.model.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContaRepositorio implements Repositorio<Conta> {

    private List<Conta> lista = new ArrayList<>();

    private static ContaRepositorio instance;

    private ContaRepositorio() {}

    public static ContaRepositorio getInstance() {
        if (instance == null) {
            instance = new ContaRepositorio();
        }
        return instance;
    }

    @Override
    public void adicionar(Conta conta) {
        lista.add(conta);
    }

    @Override
    public List<Conta> listar() {
        return lista;
    }

    @Override
    public Conta buscarPorId(Long id) {
        return lista.stream()
                .filter(conta -> conta.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
