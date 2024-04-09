package br.gov.caixa.clientes;

import br.gov.caixa.enums.Status;

public final class ClientePJ extends Cliente {

    private String nomeFantasia;

    public ClientePJ(long id, String nome, Status status) {
        super(id, nome, status);
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}
