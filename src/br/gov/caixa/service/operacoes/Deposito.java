package br.gov.caixa.service.operacoes;

import br.gov.caixa.model.Cliente;

import java.math.BigDecimal;

public interface Deposito<T extends Cliente> {

    void depositar(T cliente, long idConta, BigDecimal valor);

}
