package br.gov.caixa.service;

import br.gov.caixa.model.Cliente;
import br.gov.caixa.repository.ClienteRepositorio;

import java.util.List;

public class ClienteService {

    private static ClienteRepositorio clienteRepositorio;

    public static void adicionarCliente(Cliente cliente) {
        clienteRepositorio.adicionar(cliente);
    }

    public static List<Cliente> listarClientes() {
        return clienteRepositorio.listar();
    }
}
