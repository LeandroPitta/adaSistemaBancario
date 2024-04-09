package br.gov.caixa.aplicacao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String retornarInicio;

        do {
            MenuInicio.abrirMenu();

            System.out.println("\nDeseja retornar a tela inicial? (sim/não)");
            retornarInicio = scanner.nextLine().toLowerCase();

        } while (retornarInicio.equals("sim"));

        scanner.close();
    }
}