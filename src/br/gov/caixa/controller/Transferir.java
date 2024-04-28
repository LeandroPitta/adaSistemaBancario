package br.gov.caixa.controller;

import br.gov.caixa.service.operacoes.*;

import java.util.Date;
import java.util.Scanner;

public class Transferir {

    public static void transferir() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nDigite o número da conta origem: ");
        Long idOrigem = scanner.nextLong();

        System.out.print("\n\nDigite o número da conta destino: ");
        Long idDestino = scanner.nextLong();

        boolean contaEncontrada = false;

        for (Conta contaOrigem : ListaContas.getListaContas()) {
            if (contaOrigem.getId() == idOrigem) {
                for (Conta contaDestino : ListaContas.getListaContas()) {
                    if (contaDestino.getId() == idDestino) {
                        System.out.print("\nQual valor da transferência (0,00): ");
                        double valor = scanner.nextDouble();
                        String conferencia = ConferenciaInstanciaCliente.conferir(contaOrigem.getIdCliente());
                        if ( conferencia.equals("ClientePJ")) {
                            TransferenciaContaPj transferencia = new TransferenciaContaPj();
                            transferencia.transferir(contaOrigem, valor, contaDestino);
                            new HistoricoOperacaoTransferencia(new Date(), TipoOperacaoConta.TRANSFERENCIA, valor, transferencia.getValorReal(), contaOrigem, contaDestino, "Transferencia realizada com sucesso");
                            System.out.println("\nTransferido com sucesso! Foi cobrado taxa de: " + transferencia.getTaxa());
                            System.out.println("O novo saldo da conta origem é: " + contaOrigem.getSaldo() + " e o novo saldo da conta destino é: " + contaDestino.getSaldo());
                            contaEncontrada = true;
                            break;
                        }
                        Transferencia transferencia = new TransferenciaPadrao();
                        transferencia.transferir(contaOrigem, valor, contaDestino);
                        new HistoricoOperacaoTransferencia(new Date(), TipoOperacaoConta.TRANSFERENCIA, valor, valor, contaOrigem, contaDestino, "Transferencia realizada com sucesso");
                        System.out.println("\nTransferido com sucesso!");
                        System.out.println("O novo saldo da conta origem é: " + contaOrigem.getSaldo() + " e o novo saldo da conta destino é: " + contaDestino.getSaldo());
                        contaEncontrada = true;
                        break;
                    }
                }
            }
        }
        if (!contaEncontrada) {
            System.out.println("\nConta origem ou destino não encontrada\n");
        }
    }
}
