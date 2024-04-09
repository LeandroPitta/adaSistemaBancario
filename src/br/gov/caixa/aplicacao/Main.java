package br.gov.caixa.aplicacao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String retornarInicio;

        do {
            System.out.println("\n##############################");
            System.out.println("#### Ada Sistema Bancário ####");
            System.out.println("##############################\n");

            MenuInicio.abrirMenu();

            System.out.println("Deseja retornar a tela inicial? (sim/não)");
            retornarInicio = scanner.nextLine().toLowerCase();

        } while (retornarInicio.equals("sim"));

        scanner.close();
    }
}