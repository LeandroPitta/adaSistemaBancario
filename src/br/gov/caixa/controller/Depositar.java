package br.gov.caixa.controller;

import br.gov.caixa.model.Conta;
import br.gov.caixa.repository.ContaRepositorio;
import br.gov.caixa.service.operacoes.factory.OpFactory;

import java.math.BigDecimal;
import java.util.Scanner;

public class Depositar {

    public static void depositar() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nDigite o número da conta: ");
        Long id = scanner.nextLong();

        Conta conta = ContaRepositorio.getInstance().buscarPorId(id);

        if (conta.getId() == id) {
            System.out.print("\nQual valor do deposito (0,00): ");
            BigDecimal valor = scanner.nextBigDecimal();

            OpFactory.getInstance().get(conta.getCliente()).depositar(conta.getCliente(), conta.getId(), valor);

            System.out.println("\nDepositado com sucesso!");
            System.out.println("O novo saldo da conta é: " + conta.getSaldo());

            return;
        }

        System.out.println("\nConta não encontrada\n");
    }
}
