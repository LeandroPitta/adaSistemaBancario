package br.gov.caixa.service.historico_operacoes;

import br.gov.caixa.model.Conta;
import br.gov.caixa.service.TipoOperacaoConta;

import java.util.Date;

public abstract class HistoricoOperacao {
    private Date data;
    private TipoOperacaoConta tipo;
    private double valorPretendido;
    private double valorReal;
    private Conta contaOrigem;
    private Conta contaDestino;
    private String observacao;

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

    public Conta getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Conta contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Conta getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Conta contaDestino) {
        this.contaDestino = contaDestino;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
