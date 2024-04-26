package br.gov.caixa.model;

import br.gov.caixa.model.enums.StatusEnum;

import java.time.LocalDate;

public abstract class Conta {

    private long id;
    private static long sequencialId = 0;
    private double saldo;
    private LocalDate dataAtualizacao;
    private StatusEnum statusEnum;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.id = ++sequencialId;
        this.saldo = 0;
        this.dataAtualizacao = LocalDate.now();
        this.statusEnum = StatusEnum.ATIVO;
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }

    public StatusEnum getStatus() {
        return statusEnum;
    }

    public void setStatus(StatusEnum status) {
        this.statusEnum = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

}