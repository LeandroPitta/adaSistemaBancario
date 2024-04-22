package br.gov.caixa.util;

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
