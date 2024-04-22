package br.gov.caixa.model;

import br.gov.caixa.util.Status;

import java.time.LocalDate;

public record ClientePF(long id, String nome, Status status, LocalDate dataCadastro) implements Cliente {
}
