package br.gov.caixa.contas;

import br.gov.caixa.enums.ClassificacaoUsuario;

public final class ContaInvestimento extends Conta{

    public ContaInvestimento(int idUsuario, ClassificacaoUsuario classificacao) {
        super(idUsuario, classificacao);
    }

    public void calcularRendimento() {
        double taxaRendimento = (classificacao == ClassificacaoUsuario.CLIENTE_PJ) ? 0.02 : 0.01;
        double rendimento = saldo * taxaRendimento;
        saldo += rendimento;
    }
}
