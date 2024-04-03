package br.gov.caixa.contas;

import br.gov.caixa.enums.ClassificacaoUsuario;
import br.gov.caixa.enums.TipoAcaoConta;
import br.gov.caixa.interfaces.InvestimentoContaInterface;

import java.util.Date;

public final class ContaCorrente extends Conta implements InvestimentoContaInterface {

    public ContaCorrente(int idUsuario, ClassificacaoUsuario classificacao) {
        super(idUsuario, classificacao);
    }

    @Override
    public void sacar(double valorPretendido) {
        double valorReal = (classificacao == ClassificacaoUsuario.CLIENTE_PJ) ? (valorPretendido + (valorPretendido * 0.005)) : valorPretendido;
        if (valorReal > saldo) {
            System.out.println("Saldo insuficiente para realizar o saque.");
            return;
        }
        saldo -= valorReal;
        registrarHistoricoAcao(new HistoricoAcao(new Date(), TipoAcaoConta.SAQUE, valorPretendido, valorReal, idUsuario, "Saque realizado"));
    }

    @Override
    public void transferir(double valorPretendido, int idDestino) {
        double valorReal = (classificacao == ClassificacaoUsuario.CLIENTE_PJ) ? (valorPretendido + (valorPretendido * 0.005)) : valorPretendido;
        if (valorReal > saldo) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            return;
        }
        saldo -= valorReal;
        registrarHistoricoAcao(new HistoricoAcao(new Date(), TipoAcaoConta.TRANSFERENCIA, valorPretendido, valorReal, idUsuario, idDestino, "Transferência realizada"));
    }

    public void investir(double valorPretendido, int idContaDestino) {
        if (valorPretendido > saldo) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            return;
        }
        saldo -= valorPretendido;
        registrarHistoricoAcao(new HistoricoAcao(new Date(), TipoAcaoConta.INVESTIMENTO, valorPretendido, valorPretendido, idUsuario, "Transferência realizada"));
    }
}
