package br.gov.caixa.repository;

import br.gov.caixa.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio implements Repositorio<Cliente> {

    private List<Cliente> lista = new ArrayList<>();

    @Override
    public void adicionar(Cliente item) {
        lista.add(item);
    }

    @Override
    public List<Cliente> listar() {
        return lista;
    }
}
