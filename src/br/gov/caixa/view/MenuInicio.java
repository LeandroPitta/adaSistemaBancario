package br.gov.caixa.view;

import br.gov.caixa.view.enums.MenuInicioEnum;

import java.util.Scanner;

public class MenuInicio {

    private static boolean retornarInicio = true;

    public static void abrirMenu() {

        Scanner scanner = new Scanner(System.in);

        System.out.print(MenuInicioEnum.imprimirOpcoes());
        System.out.print("Para selecionar uma opção, digite seu número: ");
        MenuInicioEnum menu = MenuInicioEnum.fromInteger(scanner.nextInt());
        try {
            menu.opcaoSelecionada();
        } catch (NullPointerException ex) {
            System.out.println("\nNão foi selecionado uma classificação valida.");
            MenuInicio.abrirMenu();
        }

        System.out.println("\n1 - Retornar ao menu inicial");
        System.out.println("2 - Encerrar o programa");
        System.out.print("Digite o número da opção desejada: ");
        retornarInicio = 1 == scanner.nextInt();
        System.out.println();

    }

    public static boolean isRetornarInicio() {
        return retornarInicio;
    }
}
