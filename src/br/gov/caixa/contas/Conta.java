package br.gov.caixa.contas;

import br.gov.caixa.enums.ClassificacaoUsuario;
import br.gov.caixa.enums.Status;
import br.gov.caixa.enums.TipoAcaoConta;
import br.gov.caixa.interfaces.ContaInterface;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Conta implements ContaInterface {
    protected int id;
    protected double saldo;
    protected List<HistoricoAcao> historicoAcoes;
    protected Date dataAtualizacao;
    protected Status status;
    protected int idUsuario;
    ClassificacaoUsuario classificacao;

    // Construtor
    public Conta(int idUsuario, ClassificacaoUsuario classificacao) {
        this.id = 1; // vai vir do banco de dados
        this.saldo = 0;
        this.historicoAcoes = new ArrayList<>();
        this.dataAtualizacao = new Date();
        this.status = Status.ATIVO;
        this.idUsuario = idUsuario;
        this.classificacao = classificacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<HistoricoAcao> getHistoricoAcoes() {
        return historicoAcoes;
    }

    public void setHistoricoAcoes(List<HistoricoAcao> historicoAcoes) {
        this.historicoAcoes = historicoAcoes;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void sacar(double valorPretendido) {
        if (valorPretendido > saldo) {
            System.out.println("Saldo insuficiente para realizar o saque.");
            return;
        }
        saldo -= valorPretendido;
        registrarHistoricoAcao(new HistoricoAcao(new Date(), TipoAcaoConta.SAQUE, valorPretendido, valorPretendido, idUsuario, "Saque realizado"));
    }

    public void depositar(double valorPretendido) {
        saldo += valorPretendido;
        registrarHistoricoAcao(new HistoricoAcao(new Date(), TipoAcaoConta.DEPOSITO, valorPretendido, valorPretendido, idUsuario,"Depósito realizado"));
    }

    public void transferir(double valorPretendido, int idDestino) {
        if (valorPretendido > saldo) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            return;
        }
        saldo -= valorPretendido;
        registrarHistoricoAcao(new HistoricoAcao(new Date(), TipoAcaoConta.TRANSFERENCIA, valorPretendido, valorPretendido, idUsuario, idDestino, "Transferência realizada"));
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: " + saldo);
        registrarHistoricoAcao(new HistoricoAcao(new Date(), TipoAcaoConta.CONSULTA_SALDO, saldo, idUsuario, "Consultou o saldo"));
    }

    public void registrarHistoricoAcao(HistoricoAcao acao) {
        historicoAcoes.add(acao);
    }
}
