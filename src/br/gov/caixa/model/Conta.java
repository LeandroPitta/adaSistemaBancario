package br.gov.caixa.model;

import br.gov.caixa.model.enums.StatusEnum;
import br.gov.caixa.repository.ContaRepositorio;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Conta {

    private long id;
    private static long sequencialId = 0;
    private BigDecimal saldo;
    private LocalDate dataAtualizacao;
    private StatusEnum statusEnum;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.id = ++sequencialId;
        this.saldo = BigDecimal.valueOf(0);
        this.dataAtualizacao = LocalDate.now();
        this.statusEnum = StatusEnum.ATIVO;
        this.cliente = cliente;
        //cliente.addEmContas(this);
        //ContaRepositorio.getInstance().adicionar(this);
    }

    public long getId() {
        return id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
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