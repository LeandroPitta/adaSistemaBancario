package br.gov.caixa.contas;

import br.gov.caixa.enums.Status;

import java.util.Date;

public abstract class Conta {

    private int id;
    private static int sequencialId = 0;
    private double saldo;
    private Date dataAtualizacao;
    private Status status;
    private int idCliente;

    public Conta(int idCliente) {
        this.id = ++sequencialId;
        this.saldo = 0;
        this.dataAtualizacao = new Date();
        this.status = Status.ATIVO;
        this.idCliente = idCliente;
        ListaContas.adicionarConta(this);
    }

    public int getId() {
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

    public int getIdCliente() {
        return idCliente;
    }

}
