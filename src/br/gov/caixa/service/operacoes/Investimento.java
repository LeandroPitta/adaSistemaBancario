package br.gov.caixa.service.operacoes;

import br.gov.caixa.model.Cliente;

import java.math.BigDecimal;

public interface Investimento<T extends Cliente> {

    void investir(T cliente, BigDecimal valor);

}
