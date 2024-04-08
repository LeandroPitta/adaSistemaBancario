package br.gov.caixa.contas;

import br.gov.caixa.contas.services.historico_operacoes.HistoricoOperacao;
import br.gov.caixa.enums.Status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta {
    private int id;
    private static int sequencialId = 0;
    private double saldo;
    private List<HistoricoOperacao> historicoAcoes;
    private Date dataAtualizacao;
    private Status status;
    private int idCliente;

    public Conta(int idCliente) {
        this.id = ++sequencialId;
        this.saldo = 0;
        this.historicoAcoes = new ArrayList<>();
        this.dataAtualizacao = new Date();
        this.status = Status.ATIVO;
        this.idCliente = idCliente;
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

    public List<HistoricoOperacao> getHistoricoAcoes() {
        return historicoAcoes;
    }

    public void setHistoricoAcoes(List<HistoricoOperacao> historicoAcoes) {
        this.historicoAcoes = historicoAcoes;
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

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
