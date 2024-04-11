package br.gov.caixa.aplicacao.acao;

import br.gov.caixa.contas.Conta;
import br.gov.caixa.contas.ListaContas;
import br.gov.caixa.contas.services.historico_operacoes.HistoricoOperacaoDeposito;
import br.gov.caixa.contas.services.operacoes.Deposito;
import br.gov.caixa.contas.services.operacoes.DepositoPadrao;
import br.gov.caixa.enums.TipoOperacaoConta;

import java.util.Date;
import java.util.Scanner;

public class Depositar {

    public static void depositar() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nDigite o número da conta: ");
        Long id = scanner.nextLong();

        boolean contaEncontrada = false;
        for (Conta conta : ListaContas.getListaContas()) {
            if (conta.getId() == id) {
                System.out.print("\nQual valor do deposito (0,00): ");
                double valor = scanner.nextDouble();
                Deposito deposito = new DepositoPadrao();
                deposito.depositar(conta, valor);
                new HistoricoOperacaoDeposito(new Date(), TipoOperacaoConta.DEPOSITO, valor, valor, conta, "Deposito efetuado com sucesso");
                System.out.println("\nDepositado com sucesso!");
                System.out.println("O novo saldo da conta é: " + conta.getSaldo());
                contaEncontrada = true;
                break;
            }
        }
        if (!contaEncontrada) {
            System.out.println("\nConta não encontrada\n");
        }
    }
}
