package br.gov.caixa.aplicacao.acao;

import br.gov.caixa.aplicacao.util.ConferenciaInstanciaCliente;
import br.gov.caixa.contas.Conta;
import br.gov.caixa.contas.ListaContas;
import br.gov.caixa.contas.services.historico_operacoes.HistoricoOperacaoSaque;
import br.gov.caixa.contas.services.operacoes.*;
import br.gov.caixa.enums.TipoOperacaoConta;

import java.util.Date;
import java.util.Scanner;

public class Sacar {

    public static void sacar() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nDigite o número da conta: ");
        Long id = scanner.nextLong();

        boolean contaEncontrada = false;
        for (Conta conta : ListaContas.getListaContas()) {
            if (conta.getId() == id) {
                System.out.print("\nQual valor do saque (0,00): ");
                double valor = scanner.nextDouble();
                String conferencia = ConferenciaInstanciaCliente.conferir(conta.getIdCliente());
                if ( conferencia.equals("ClientePJ")) {
                    SaqueContaPj saque = new SaqueContaPj();
                    saque.sacar(conta, valor);
                    new HistoricoOperacaoSaque(new Date(), TipoOperacaoConta.SAQUE, valor, saque.getValorReal(), conta, "Saque efetuado com sucesso");
                    System.out.println("\nSaque realizado com sucesso! Foi cobrado taxa de: " + saque.getTaxa());
                    System.out.println("O novo saldo da conta é: " + conta.getSaldo());
                    contaEncontrada = true;
                    break;
                }
                Saque saque = new SaquePadrao();
                saque.sacar(conta, valor);
                new HistoricoOperacaoSaque(new Date(), TipoOperacaoConta.SAQUE, valor, valor, conta, "Saque efetuado com sucesso");
                System.out.println("\nSaque realizado com sucesso!");
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
