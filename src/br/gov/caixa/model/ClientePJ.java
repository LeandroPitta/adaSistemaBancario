package br.gov.caixa.model;

import br.gov.caixa.util.Status;

import java.time.LocalDate;

public record ClientePJ(long id, String razaoSocial, Status status, LocalDate dataCadastro) implements Cliente {
}
