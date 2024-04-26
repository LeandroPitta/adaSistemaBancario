package br.gov.caixa;

import br.gov.caixa.service.AgendaRendimentoMensal;
import br.gov.caixa.view.MenuInicio;

import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int retornarInicio;
        AgendaRendimentoMensal.agendarRendimentoInvestimento();

        do {
            MenuInicio.abrirMenu();

            System.out.println("\n1 - Retornar ao menu inicial");
            System.out.println("2 - Encerrar o programa");
            System.out.print("Digite o número da opção desejada: ");
            retornarInicio = scanner.nextInt();

        } while (retornarInicio == 1);

        scanner.close();
    }
}