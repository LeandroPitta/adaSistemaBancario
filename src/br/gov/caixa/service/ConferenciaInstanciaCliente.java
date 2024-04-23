package br.gov.caixa.service;

import br.gov.caixa.model.Cliente;

import java.util.List;

public class ConferenciaInstanciaCliente {

    public static String conferir(List<Cliente> clientes, long id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente.getClass().getSimpleName();
            }
        }
        return null;
    }
}
