package br.gov.caixa.model;

import br.gov.caixa.model.enums.TipoClienteEnum;
import br.gov.caixa.model.enums.StatusEnum;

import java.time.LocalDate;

public record ClientePJ(long id, String razaoSocial, StatusEnum statusEnum, TipoClienteEnum tipoClienteEnum, LocalDate dataCadastro) implements Cliente {

    @Override
    public long getId() {
        return id;
    }

    @Override
    public TipoClienteEnum getTipoCliente() {
        return tipoClienteEnum;
    }
}
