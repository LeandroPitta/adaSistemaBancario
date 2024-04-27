package br.gov.caixa.service.operacoes;

import br.gov.caixa.model.Cliente;
import br.gov.caixa.model.Conta;

import java.math.BigDecimal;

public interface Transferencia<T extends Cliente> {

    void transferir(T cliente, long idContaOrigem, Conta destino, BigDecimal valor);

}
