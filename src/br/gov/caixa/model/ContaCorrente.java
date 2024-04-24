package br.gov.caixa.model;

import br.gov.caixa.model.util.SequenciaId;
import br.gov.caixa.model.enums.StatusEnum;

import java.time.LocalDate;

public record ContaCorrente(long id, double saldo, LocalDate dataAtualizacao, StatusEnum statusEnum, Cliente cliente) implements Conta {

    public ContaCorrente(Cliente cliente) {
        this(SequenciaId.proximoId(), 0, LocalDate.now(), StatusEnum.ATIVO, cliente);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public void setSaldo(double novoSaldo) {
        new ContaCorrente(this.id, novoSaldo, this.dataAtualizacao, this.statusEnum, this.cliente);
    }
}
