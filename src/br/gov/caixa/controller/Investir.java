package br.gov.caixa.controller;

import br.gov.caixa.service.historico_operacoes.HistoricoOperacaoInvestimento;
import br.gov.caixa.service.operacoes.*;
import br.gov.caixa.service.TipoOperacaoConta;

import java.util.Date;
import java.util.Scanner;

public class Investir {

    public static void investir() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nDigite o número da conta corrente: ");
        Long idCc = scanner.nextLong();

        boolean contaEncontrada = false;
        for (Conta contaCorrente : ListaContas.getListaContas()) {
            if (contaCorrente.getId() == idCc) {
                System.out.print("\nQual valor do investimento (0,00): ");
                double valor = scanner.nextDouble();
                Conta contaInvestimento = RetornaContaInvestimento.retornarConta(contaCorrente.getIdCliente());
                Investimento investimento = new InvestimentoPadrao();
                investimento.investir(contaCorrente, valor, contaInvestimento);
                new HistoricoOperacaoInvestimento(new Date(), TipoOperacaoConta.INVESTIMENTO, valor, valor, contaCorrente, "Investimento realizado com sucesso");
                System.out.println("\nInvestido com sucesso!");
                System.out.println("O novo saldo da conta corrente é: " + contaCorrente.getSaldo() + " e o novo saldo da conta investimento é: " + contaInvestimento.getSaldo());
                contaEncontrada = true;
                break;
            }
        }
        if (!contaEncontrada) {
            System.out.println("\nConta origem ou destino não encontrada\n");
        }
    }
}
