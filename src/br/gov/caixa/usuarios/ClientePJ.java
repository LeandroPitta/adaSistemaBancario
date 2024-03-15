package br.gov.caixa.usuarios;

import br.gov.caixa.enums.ClassificacaoUsuario;
import br.gov.caixa.enums.StatusUsuario;

import java.util.Date;

public final class ClientePJ extends Usuario{

    private int cnpj;
    private String razaoSocial;

    public ClientePJ(int id, ClassificacaoUsuario classificacao, String nome, Date dataCadastro, StatusUsuario status, int cnpj, String razaoSocial) {
        super(id, classificacao, nome, dataCadastro, status);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
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
