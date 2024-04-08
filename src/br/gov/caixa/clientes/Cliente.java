package br.gov.caixa.clientes;

import br.gov.caixa.enums.Status;

import java.util.Date;

public abstract class Cliente {

    private int id;
    private String nome;
    private Date dataCadastro;
    private Status status;

    public Cliente(int id, String nome, Status status) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = new Date();
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
