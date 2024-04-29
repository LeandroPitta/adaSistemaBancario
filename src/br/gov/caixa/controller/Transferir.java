package br.gov.caixa.controller;

import br.gov.caixa.model.Conta;
import br.gov.caixa.repository.ContaRepositorio;
import br.gov.caixa.service.operacoes.*;
import br.gov.caixa.service.operacoes.factory.OpFactory;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class Transferir {

    public static void transferir() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nDigite o número da conta origem: ");
        Long idOrigem = scanner.nextLong();

        System.out.print("\n\nDigite o número da conta destino: ");
        Long idDestino = scanner.nextLong();

        Conta contaOrigem = ContaRepositorio.getInstance().buscarPorId(idOrigem);
        Conta contaDestino = ContaRepositorio.getInstance().buscarPorId(idDestino);

        if (contaOrigem.getId() == idOrigem && contaDestino.getId() == idDestino) {
            System.out.print("\nQual valor da transferência (0,00): ");
            BigDecimal valor = scanner.nextBigDecimal();

            OpFactory.getInstance().get(contaOrigem.getCliente())
                    .transferir(contaOrigem.getCliente(), contaOrigem.getId(), contaDestino, valor);

            System.out.println("\nTransferido com sucesso!");

            return;
        }

        System.out.println("\nConta origem ou destino não encontrada\n");

    }
}
