package br.gov.caixa.contas;

import br.gov.caixa.enums.ClassificacaoUsuario;
import br.gov.caixa.enums.Status;
import br.gov.caixa.enums.TipoAcaoConta;
import br.gov.caixa.interfaces.Conta;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class ContaAbstract implements Conta {
    protected int id;
    protected double saldo;
    protected List<HistoricoAcao> historicoAcoes;
    protected Date dataAtualizacao;
    protected Status status;
    protected int idUsuario;
    ClassificacaoUsuario classificacao;

    // Construtor
    public ContaAbstract(int idUsuario, ClassificacaoUsuario classificacao) {
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
        RegraNegocio.sacar(this, valorPretendido);
    }

    public void depositar(double valorPretendido) {
        RegraNegocio.depositar(this, valorPretendido);
    }

    public void transferir(double valorPretendido, int idDestino) {
        RegraNegocio.transferir(this, valorPretendido, idDestino);
    }

    public void consultarSaldo() {
        RegraNegocio.consultarSaldo(this);
    }

    public void registrarHistoricoAcao(HistoricoAcao acao) {
        historicoAcoes.add(acao);
    }
}
