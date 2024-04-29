package br.gov.caixa.controller;

import br.gov.caixa.model.Conta;
import br.gov.caixa.repository.ContaRepositorio;
import br.gov.caixa.service.operacoes.*;
import br.gov.caixa.service.operacoes.factory.OpFactory;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

public class Investir {

    public static void investir() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nDigite o número da conta corrente: ");
        Long idCc = scanner.nextLong();

        Conta conta = ContaRepositorio.getInstance().buscarPorId(idCc);

        if (conta.getId() == idCc) {
            System.out.print("\nQual valor do investimento (0,00): ");
            BigDecimal valor = scanner.nextBigDecimal();

            OpFactory.getInstance().get(conta.getCliente()).investir(conta.getCliente(), valor);

            System.out.println("\nInvestido com sucesso!");

            return;
        }


        System.out.println("\nConta origem não encontrada\n");

    }
}
