package br.gov.caixa.model;

import br.gov.caixa.service.Status;

import java.time.LocalDate;

public record ClientePF(long id, String nome, Status status, LocalDate dataCadastro) implements Cliente {

    @Override
    public long getId() {
        return id;
    }
}
