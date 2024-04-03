package br.gov.caixa.contas;

import br.gov.caixa.enums.ClassificacaoUsuario;
import br.gov.caixa.enums.TipoAcaoConta;
import br.gov.caixa.interfaces.ContaInvestimentoInterface;

import java.util.Date;

public final class ContaInvestimento extends Conta implements ContaInvestimentoInterface {

    public ContaInvestimento(int idUsuario, ClassificacaoUsuario classificacao) {
        super(idUsuario, classificacao);
    }

    public void calcularRendimento() {
        double taxaRendimento = (classificacao == ClassificacaoUsuario.CLIENTE_PJ) ? 0.02 : 0.01;
        double rendimento = saldo * taxaRendimento;
        saldo += rendimento;
        registrarHistoricoAcao(new HistoricoAcao(new Date(), TipoAcaoConta.RENDIMENTO, 0, rendimento, idUsuario, "Rendimento mensal aplicado"));
    }
}
