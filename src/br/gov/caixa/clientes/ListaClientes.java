package br.gov.caixa.clientes;

import java.util.ArrayList;
import java.util.List;

public class ListaClientes {


    private static List<Cliente> clientes = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }
}
