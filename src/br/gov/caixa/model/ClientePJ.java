package br.gov.caixa.model;

import br.gov.caixa.model.enums.StatusEnum;
import br.gov.caixa.model.enums.TipoClienteEnum;

import java.time.LocalDate;

public class ClientePJ extends Cliente {

    private String nomeFantasia;

    public ClientePJ(long id, String razaoSocial, StatusEnum statusEnum, TipoClienteEnum tipoClienteEnum, LocalDate dataCadastro) {
        super(id, razaoSocial, statusEnum, tipoClienteEnum, dataCadastro);
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}
