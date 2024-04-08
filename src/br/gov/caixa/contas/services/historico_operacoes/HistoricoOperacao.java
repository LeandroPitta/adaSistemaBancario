package br.gov.caixa.contas.services.historico_operacoes;

import br.gov.caixa.enums.TipoOperacaoConta;

import java.util.Date;

public abstract class HistoricoOperacao {
    private Date data;
    private TipoOperacaoConta tipo;
    private double valorPretendido;
    private double valorReal;
    private int usuarioOrigem;
    private int usuarioDestino;
    private String observacao;

    public HistoricoOperacao(){}

    // Construtor para ação de consulta saldo e rendimento
    public HistoricoOperacao(Date data, TipoOperacaoConta tipo, double valorReal, int usuarioOrigem, String observacao) {
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

    public TipoOperacaoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoOperacaoConta tipo) {
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
