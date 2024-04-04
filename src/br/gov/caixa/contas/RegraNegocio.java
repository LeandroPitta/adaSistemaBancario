package br.gov.caixa.contas;

import br.gov.caixa.enums.TipoAcaoConta;

import java.util.Date;

public class RegraNegocio {

    public static void sacar(ContaAbstract conta, double valorPretendido) {
        if (valorPretendido > conta.getSaldo()) {
            System.out.println("Saldo insuficiente para realizar o saque.");
            return;
        }
        conta.setSaldo(conta.getSaldo() - valorPretendido);
        conta.registrarHistoricoAcao(new HistoricoAcao(new Date(), TipoAcaoConta.SAQUE, valorPretendido, valorPretendido, conta.getIdUsuario(), "Saque realizado"));
    }

    public static void depositar(ContaAbstract conta, double valorPretendido) {
        conta.setSaldo(conta.getSaldo() + valorPretendido);
        conta.registrarHistoricoAcao(new HistoricoAcao(new Date(), TipoAcaoConta.DEPOSITO, valorPretendido, valorPretendido, conta.getIdUsuario(),"Depósito realizado"));
    }

    public static void transferir(ContaAbstract conta, double valorPretendido, int idDestino) {
        if (valorPretendido > conta.getSaldo()) {
            System.out.println("Saldo insuficiente para realizar a transferência.");
            return;
        }
        conta.setSaldo(conta.getSaldo() - valorPretendido);
        conta.registrarHistoricoAcao(new HistoricoAcao(new Date(), TipoAcaoConta.TRANSFERENCIA, valorPretendido, valorPretendido, conta.getIdUsuario(), idDestino, "Transferência realizada"));
    }

    public static void consultarSaldo(ContaAbstract conta) {
        System.out.println("Saldo atual: " + conta.getSaldo());
        conta.registrarHistoricoAcao(new HistoricoAcao(new Date(), TipoAcaoConta.CONSULTA_SALDO, conta.getSaldo(), conta.getIdUsuario(), "Consultou o saldo"));
    }
}
