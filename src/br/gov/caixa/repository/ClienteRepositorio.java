package br.gov.caixa.repository;

import br.gov.caixa.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio implements Repositorio<Cliente> {

    private List<Cliente> lista = new ArrayList<>();

    private static ClienteRepositorio instance;

    private ClienteRepositorio() {}

    public static ClienteRepositorio getInstance() {
        if (instance == null) {
            instance = new ClienteRepositorio();
        }
        return instance;
    }

    @Override
    public void adicionar(Cliente item) {
        lista.add(item);
    }

    @Override
    public List<Cliente> listar() {
        return lista;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return lista.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
