package br.gov.caixa.model;

import br.gov.caixa.model.util.SequenciaId;
import br.gov.caixa.service.Status;

import java.time.LocalDate;

public record ContaPoupanca(long id, double saldo, LocalDate dataAtualizacao, Status status, long idCliente) implements Conta {

    public ContaPoupanca(long idCliente) {
        this(SequenciaId.proximoId(), 0, LocalDate.now(), Status.ATIVO, idCliente);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public long getIdCliente() {
        return idCliente;
    }
}
