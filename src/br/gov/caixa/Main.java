package br.gov.caixa;

import br.gov.caixa.service.ArqClientesParaAbrirContas;
import br.gov.caixa.view.MenuInicio;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            ArqClientesParaAbrirContas.tratarArqAbrirCtaExportar();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Scanner scanner = new Scanner(System.in);
//        int retornarInicio;
//
//        do {
//            MenuInicio.abrirMenu();
//
//            System.out.println("\n1 - Retornar ao menu inicial");
//            System.out.println("2 - Encerrar o programa");
//            System.out.print("Digite o número da opção desejada: ");
//            retornarInicio = scanner.nextInt();
//
//        } while (retornarInicio == 1);
//
//        scanner.close();
    }
}