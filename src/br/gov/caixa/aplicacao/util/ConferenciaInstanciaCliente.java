package br.gov.caixa.aplicacao.util;

import br.gov.caixa.clientes.Cliente;
import br.gov.caixa.clientes.ListaClientes;

public class ConferenciaInstanciaCliente {

    public static String conferir(long id) {

        for (Cliente cliente : ListaClientes.getClientes()) {
            if (cliente.getId() == id) {
                return cliente.getClass().getSimpleName();
            }
        }
        return null;
    }
}
