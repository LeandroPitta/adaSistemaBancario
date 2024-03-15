package br.gov.caixa.usuarios;

import br.gov.caixa.enums.ClassificacaoUsuario;
import br.gov.caixa.enums.StatusUsuario;

import java.util.Date;

public final class ClientePF extends Usuario {

    private int cpf;

    public ClientePF(int id, ClassificacaoUsuario classificacao, String nome, Date dataCadastro, StatusUsuario status, int cpf) {
        super(id, classificacao, nome, dataCadastro, status);
        this.cpf = cpf;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
