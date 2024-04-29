package br.gov.caixa.model;

import br.gov.caixa.model.enums.StatusEnum;
import br.gov.caixa.model.enums.TipoClienteEnum;

import java.time.LocalDate;

public class ClientePF extends Cliente {

    public ClientePF(long id, String nome, TipoClienteEnum tipoClienteEnum) {
        super(id, nome, tipoClienteEnum);
    }
}
