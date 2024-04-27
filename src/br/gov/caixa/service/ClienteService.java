package br.gov.caixa.service;

import br.gov.caixa.model.Cliente;
import br.gov.caixa.repository.ClienteRepositorio;

import java.util.List;

public class ClienteService {

    private static ClienteService instance;

    private ClienteService() {
    }

    public static ClienteService getInstance() {
        if (instance == null) {
            instance = new ClienteService();
        }
        return instance;
    }

    public void adicionarCliente(Cliente cliente) {
        ClienteRepositorio.getInstance().adicionar(cliente);
    }

    public List<Cliente> listarClientes() {
        return ClienteRepositorio.getInstance().listar();
    }

    public Cliente buscarCliente(Long id) {
        return ClienteRepositorio.getInstance().buscarPorId(id);
    }
}
