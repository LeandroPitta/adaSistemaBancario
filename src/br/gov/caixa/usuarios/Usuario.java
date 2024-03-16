package br.gov.caixa.usuarios;

import br.gov.caixa.contas.ContaCorrente;
import br.gov.caixa.contas.ContaInvestimento;
import br.gov.caixa.contas.ContaPoupanca;
import br.gov.caixa.enums.ClassificacaoUsuario;
import br.gov.caixa.enums.Status;

import java.util.Date;

public abstract class Usuario {

    private int id;
    private String nome;
    private Date dataCadastro;
    private Status status;
    private ClassificacaoUsuario classificacao;
    private ContaCorrente contaCorrente;
    private ContaPoupanca contaPoupanca;
    private ContaInvestimento contaInvestimento;

    public Usuario(int id, String nome, Date dataCadastro, Status status) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.status = status;
        this.contaCorrente = new ContaCorrente(this.getId(), this.getClassificacao());
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }

    public void abrirContaPoupanca() {
        if (this.getClassificacao() == ClassificacaoUsuario.CLIENTE_PF) {
            this.contaPoupanca = new ContaPoupanca(this.getId(), this.getClassificacao());
        } else {
            System.out.println("Apenas clientes pessoa física podem ter conta poupança.");
        }
    }

    public void abrirContaInvestimento() {
        this.contaInvestimento = new ContaInvestimento(this.getId(), this.getClassificacao());
    }
}
