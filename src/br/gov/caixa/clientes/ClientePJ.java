package br.gov.caixa.clientes;

import br.gov.caixa.enums.Status;

public final class ClientePJ extends Clientes {

    private String nomeFantasia;

    public ClientePJ(int id, String nome, Status status) {
        super(id, nome, status);
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}
