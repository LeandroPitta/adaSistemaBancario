package br.gov.caixa.service.operacoes;

import br.gov.caixa.exceptions.ContaNaoEncontradaException;
import br.gov.caixa.model.Cliente;
import br.gov.caixa.model.Conta;
import br.gov.caixa.model.ContaInvestimento;
import br.gov.caixa.repository.ContaRepositorio;
import br.gov.caixa.service.HistoricoService;
import br.gov.caixa.service.operacoes.factory.OpFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface OpConta<T extends Cliente> extends
        Deposito<T>, Saldo<T>, Saque<T>, Transferencia<T>, Investimento<T> {

    default Conta getContaCliente(T cliente, long idConta) {
        for (Conta conta : cliente.getContas()) {
            if (conta.getId() == idConta) {
                return conta;
            }
        }
        throw new ContaNaoEncontradaException();
    }

    default Conta getContaInvestimentoCliente(T cliente) {
        for (Conta conta : cliente.getContas()) {
            if (conta instanceof ContaInvestimento) {
                return conta;
            }
        }
        return null;
    }

    @Override
    default BigDecimal consultarSaldo(T cliente, long idConta) {
        Conta conta = getContaCliente(cliente, idConta);
        return conta.getSaldo().setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    default void transferir(T cliente, long idContaOrigem, Conta destino, BigDecimal valor) {
        this.sacar(cliente, idContaOrigem, valor);
        OpFactory.getInstance().get(destino.getCliente())
                .depositar(destino.getCliente(), destino.getId(), valor);

        HistoricoService.historicoTransferencia(valor, ContaRepositorio.getInstance().buscarPorId(idContaOrigem), destino);
    }

    default void depositar(T cliente, long idConta, BigDecimal valor) {
        Conta conta = this.getContaCliente(cliente, idConta);
        conta.setSaldo(conta.getSaldo().add(valor));

        HistoricoService.historicoDeposito(valor, conta);

    }

}
