package br.gov.caixa.model;

import br.gov.caixa.service.Status;

import java.time.LocalDate;

public record ClientePJ(long id, String razaoSocial, Status status, LocalDate dataCadastro) implements Cliente {

    @Override
    public long getId() {
        return id;
    }
}
