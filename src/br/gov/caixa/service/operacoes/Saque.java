package br.gov.caixa.service.operacoes;


import br.gov.caixa.exceptions.SaldoInsuficienteException;
import br.gov.caixa.model.Cliente;
import br.gov.caixa.model.Conta;

import java.math.BigDecimal;

public interface Saque<T extends Cliente> {

    void sacar(T cliente, long idConta, BigDecimal valor);

    default void verificarSaldo(Conta conta, BigDecimal valor) {
        if (valor.compareTo(conta.getSaldo()) > 0) {
            throw new SaldoInsuficienteException();
        }
    }

    default BigDecimal getTaxaSaque() {
        return BigDecimal.valueOf(1);
    }

}
