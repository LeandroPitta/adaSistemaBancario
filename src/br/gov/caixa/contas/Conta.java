package br.gov.caixa.contas;

import br.gov.caixa.enums.Status;

import java.util.Date;

public abstract class Conta {

    private long id;
    private static long sequencialId = 0;
    private double saldo;
    private Date dataAtualizacao;
    private Status status;
    private long idCliente;

    public Conta(long idCliente) {
        this.id = ++sequencialId;
        this.saldo = 0;
        this.dataAtualizacao = new Date();
        this.status = Status.ATIVO;
        this.idCliente = idCliente;
        ListaContas.adicionarConta(this);
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

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public long getIdCliente() {
        return idCliente;
    }

}
