package br.gov.caixa.aplicacao;

import br.gov.caixa.enums.MenuSistema;

import java.util.Scanner;

public abstract class MenuInicio {

    public static void abrirMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n##############################");
        System.out.println("#### Ada Sistema Bancário ####");
        System.out.println("##############################\n");

        System.out.println(MenuSistema.imprimirOpcoes());
        System.out.print("Selecione uma opção, digite seu número: ");
        MenuSistema menu = MenuSistema.fromInteger(scanner.nextInt());

        try {
            menu.opcaoSelecionada();
        } catch (NullPointerException ex) {
            System.out.println("\nNão foi selecionado uma classificação valida.");
            MenuInicio.abrirMenu();
        }
    }
}
