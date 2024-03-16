package br.gov.caixa.usuarios;

import br.gov.caixa.enums.ClassificacaoUsuario;
import br.gov.caixa.enums.Status;

import java.util.Date;

public final class ClientePF extends Usuario {

    private int cpf;

    public ClientePF(int id, String nome, Date dataCadastro, Status status, int cpf) {
        super(id, nome, dataCadastro, status);
        this.cpf = cpf;
        setClassificacao(ClassificacaoUsuario.CLIENTE_PF);
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
