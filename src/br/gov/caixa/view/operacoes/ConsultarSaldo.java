package br.gov.caixa.view.operacoes;

import br.gov.caixa.model.Conta;
import br.gov.caixa.repository.ContaRepositorio;
import br.gov.caixa.service.operacoes.factory.OpFactory;

import java.util.Scanner;

public class ConsultarSaldo {

    public static void consultarSaldo () {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nDigite o número da conta: ");
        Long id = scanner.nextLong();

        Conta conta = ContaRepositorio.getInstance().buscarPorId(id);

        if (conta.getId() == id) {
            System.out.println("O saldo da conta é: " + OpFactory.getInstance().get(conta.getCliente())
                    .consultarSaldo(conta.getCliente(), conta.getId()) + "\n\n");
            return;
        }

        System.out.println("\nConta não encontrada\n");

    }
}
