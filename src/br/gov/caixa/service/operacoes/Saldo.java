package br.gov.caixa.service.operacoes;

import br.gov.caixa.model.Cliente;

import java.math.BigDecimal;

public interface Saldo<T extends Cliente> {

    BigDecimal consultarSaldo(T cliente, long idConta);

}
