package br.gov.caixa.contas;

import br.gov.caixa.enums.TipoAcaoConta;

import java.util.Date;

public class HistoricoAcoes {
    private Date data;
    private TipoAcaoConta tipo;
    private double valorPretendido;
    private double valorReal;
    private int usuarioOrigem;
    private int usuarioDestino;
    private String observacao;

    // Construtor para ação de saque e investimento
    public HistoricoAcoes(Date data, TipoAcaoConta tipo, double valorPretendido, double valorReal, int usuarioOrigem, String observacao) {
        this.data = new Date();
        this.tipo = tipo;
        this.valorPretendido = valorPretendido;
        this.valorReal = valorReal;
        this.usuarioOrigem = usuarioOrigem;
        this.observacao = observacao;
    }

    // Construtor para ação de deposito e transferência
    public HistoricoAcoes(Date data, TipoAcaoConta tipo, double valorPretendido, double valorReal, int usuarioOrigem, int usuarioDestino, String observacao) {
        this.data = new Date();
        this.tipo = tipo;
        this.valorPretendido = valorPretendido;
        this.valorReal = valorReal;
        this.usuarioOrigem = usuarioOrigem;
        this.usuarioDestino = usuarioDestino;
        this.observacao = observacao;
    }

    // Construtor para ação de consulta saldo e rendimento
    public HistoricoAcoes(Date data, TipoAcaoConta tipo, double valorReal, int usuarioOrigem, String observacao) {
        this.data = new Date();
        this.tipo = tipo;
        this.valorReal = valorReal;
        this.usuarioOrigem = usuarioOrigem;
        this.observacao = observacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public TipoAcaoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoAcaoConta tipo) {
        this.tipo = tipo;
    }

    public double getValorPretendido() {
        return valorPretendido;
    }

    public void setValorPretendido(double valorPretendido) {
        this.valorPretendido = valorPretendido;
    }

    public double getValorReal() {
        return valorReal;
    }

    public void setValorReal(double valorReal) {
        this.valorReal = valorReal;
    }

    public int getUsuarioOrigem() {
        return usuarioOrigem;
    }

    public void setUsuarioOrigem(int usuarioOrigem) {
        this.usuarioOrigem = usuarioOrigem;
    }

    public int getUsuarioDestino() {
        return usuarioDestino;
    }

    public void setUsuarioDestino(int usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
