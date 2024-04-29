package br.gov.caixa.model;

import br.gov.caixa.model.enums.StatusEnum;
import br.gov.caixa.model.enums.TipoClienteEnum;
import br.gov.caixa.repository.ClienteRepositorio;

import java.time.LocalDate;
import java.util.List;

public abstract class Cliente {

    private long id;
    private String nome;
    private LocalDate dataCadastro;
    private TipoClienteEnum tipoClienteEnum;
    private StatusEnum statusEnum;
    private List<Conta> contas;

    public Cliente(long id, String nome, TipoClienteEnum tipoClienteEnum) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = LocalDate.now();
        this.statusEnum = StatusEnum.ATIVO;
        this.tipoClienteEnum = tipoClienteEnum;
        new ContaCorrente(this);
        //contas.add(new ContaCorrente(this));
        //ClienteRepositorio.getInstance().adicionar(this);
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public TipoClienteEnum getTipoClienteEnum() {
        return tipoClienteEnum;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void addEmContas(Conta conta) {
        this.contas.add(conta);
    }
}

