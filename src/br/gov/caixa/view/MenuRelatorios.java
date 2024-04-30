package br.gov.caixa.view;

import br.gov.caixa.controller.CampanhaPromocionalController;
import br.gov.caixa.controller.RelatoriosController;

import java.util.Scanner;

public class MenuRelatorios {

    public static void imprimirMenuRelatorios() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(
                        "\n1 - Relatório de Clientes\n" +
                        "2 - Histórico das operações\n"
        );

        System.out.print("Para selecionar uma opção, digite seu número: ");
        int opcao = scanner.nextInt();
        System.out.println();

        switch (opcao) {
            case 1:
                System.out.println(RelatoriosController.executarRelatorioCliente());
                return;
            case 2:
                System.out.println(RelatoriosController.executarRelatorioHistoricoOperacoes());
                return;
            default:
                System.out.println("\nNão foi selecionado uma opção valida.\n");
                MenuInicio.abrirMenu();
        }

        scanner.close();
    }
}
