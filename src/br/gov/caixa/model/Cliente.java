package br.gov.caixa.model;

import br.gov.caixa.model.enums.TipoClienteEnum;

public interface Cliente {

    long getId();
    TipoClienteEnum getTipoCliente();
}
