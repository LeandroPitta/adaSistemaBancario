package br.gov.caixa.contas;

import br.gov.caixa.enums.ClassificacaoUsuario;

public final class ContaPoupanca extends ContaAbstract {
    public ContaPoupanca(int idUsuario, ClassificacaoUsuario classificacao) {
        super(idUsuario, classificacao);
    }

}
