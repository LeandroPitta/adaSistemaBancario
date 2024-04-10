package br.gov.caixa.aplicacao;

import br.gov.caixa.aplicacao.menu_enums.MenuInicial;

import java.util.Scanner;

public abstract class MenuInicio {

    public static void abrirMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n##############################");
        System.out.println("#### Ada Sistema Bancário ####");
        System.out.println("##############################\n");

        System.out.print(MenuInicial.imprimirOpcoes());
        System.out.print("Para selecionar uma opção, digite seu número: ");
        MenuInicial menu = MenuInicial.fromInteger(scanner.nextInt());
        try {
            menu.opcaoSelecionada();
        } catch (NullPointerException ex) {
            System.out.println("\nNão foi selecionado uma classificação valida.");
            MenuInicio.abrirMenu();
        }
    }
}
