package br.gov.caixa.view;

import br.gov.caixa.controller.CampanhaPromocionalController;

import java.util.Scanner;

public class CampanhaPromocional {

    public static void menuPromocao() {

        Scanner scanner = new Scanner(System.in);

        System.out.println(
                "Foi disponibilizado uma lista de potênciais clientes para abertura de conta no arquivo pessoas.csv.\n" +
                "Escolha uma das opções abaixo para realizar a abertura das contas ou ir para o menu inicial.\n\n" +
                "1 - Participar da campanha e abrir contas\n" +
                "2 - Ir para o menu inicial\n"
        );

        System.out.print("Para selecionar uma opção, digite seu número: ");
        int opcao = scanner.nextInt();
        System.out.println();

        switch (opcao) {
            case 1:
                if (CampanhaPromocionalController.executarCampanhaPromocional()) {
                    System.out.println("\nContas abertas com sucesso! " +
                            "Foi gerado o arquivo contas-abertas.csv com o relatório de contas abertas.\n");
                }else {
                    System.out.println("Houve algum erro no tratamento do arquivo.");
                }
                return;
            case 2:
                MenuInicio.abrirMenu();
                return;
            default:
                System.out.println("\nNão foi selecionado uma opção valida.\n");
        }

        scanner.close();
    }
}
