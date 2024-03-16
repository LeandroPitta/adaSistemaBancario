package br.gov.caixa.usuarios;

import br.gov.caixa.enums.ClassificacaoUsuario;
import br.gov.caixa.enums.Status;

import java.util.Date;

public final class ClientePJ extends Usuario{

    private int cnpj;
    private String razaoSocial;
    private ClassificacaoUsuario classificacao;

    public ClientePJ(int id, String nome, Date dataCadastro, Status status, int cnpj, String razaoSocial) {
        super(id, nome, dataCadastro, status);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        setClassificacao(ClassificacaoUsuario.CLIENTE_PJ);
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
