package br.gov.caixa.usuarios;

import br.gov.caixa.contas.ContaCorrente;
import br.gov.caixa.enums.ClassificacaoUsuario;
import br.gov.caixa.enums.StatusUsuario;

import java.util.Date;

public abstract class Usuario {

    private int id;
    private ClassificacaoUsuario classificacao;
    private String nome;
    private Date dataCadastro;
    private StatusUsuario status;

    private ContaCorrente contaCorrente;

    public Usuario(int id, ClassificacaoUsuario classificacao, String nome, Date dataCadastro, StatusUsuario status) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.status = status;
        this.contaCorrente = new ContaCorrente();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public ClassificacaoUsuario getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(ClassificacaoUsuario classificacao) {
        this.classificacao = classificacao;
    }

    public StatusUsuario getStatus() {
        return status;
    }

    public void setStatus(StatusUsuario status) {
        this.status = status;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }
}
