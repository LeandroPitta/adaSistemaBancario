package br.gov.caixa.aplicacao;

import br.gov.caixa.clientes.*;
import br.gov.caixa.enums.ClassificacaoCliente;

import java.util.Scanner;

public abstract class CadastroCliente {
    public static void cadastrarNovoCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Vamos iniciar o cadastro do cliente!\n\nDigite o CPF ou CNPJ (somente números): ");
        long id = scanner.nextLong();
        scanner.nextLine();

        for (Cliente cliente : ListaClientes.getClientes()) {
            if (cliente.getId() == id) {
                System.out.println("\nCliente já está cadastrado com o CPF/CNPJ digitado.\n");
                return;
            }
        }

        System.out.print("Digite o nome ou razão social do cliente: ");
        String nome = scanner.nextLine();

        System.out.println("Digite o numero da opção de classificação do cliente: \n 1 - Cliente PF\n 2 - Cliente PJ");
        ClassificacaoCliente classificacao = ClassificacaoCliente.fromInteger(scanner.nextInt());

        try {
            System.out.println(classificacao.instanciarCliente(id, nome));
        } catch (IllegalArgumentException ex) {
            System.out.println("\nNão foi digitado uma classificação valida.\n");
        }
    }
}
