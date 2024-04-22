package br.gov.caixa.model;

import br.gov.caixa.util.SequenciaId;
import br.gov.caixa.util.Status;

import java.time.LocalDate;

public record ContaCorrente(long id, double saldo, LocalDate dataAtualizacao, Status status, long idCliente) implements Conta {

    public ContaCorrente(long idCliente) {
        this(SequenciaId.proximoId(), 0, LocalDate.now(), Status.ATIVO, idCliente);
    }
}
