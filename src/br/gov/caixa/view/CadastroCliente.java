package br.gov.caixa.view;

import br.gov.caixa.controller.ClienteController;
import br.gov.caixa.model.enums.TipoClienteEnum;
import br.gov.caixa.service.util.VerificarClienteSemCadastro;

import java.util.Scanner;

public abstract class CadastroCliente {
    public static void cadastrarNovoCliente() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nVamos iniciar o cadastro do cliente!\nDigite o CPF ou CNPJ (somente números): ");
        long id = scanner.nextLong();
        scanner.nextLine();

        if (VerificarClienteSemCadastro.verificar(id)) {

            System.out.print("Digite o nome ou razão social do cliente: ");
            String nome = scanner.nextLine();
            System.out.println();

            System.out.println("Escolha uma opção de classificação do cliente:");
            System.out.println(
                            "\n1 - Cliente PF" +
                            "\n2 - Cliente PJ\n"
            );

            System.out.print("Para selecionar uma opção, digite seu número: ");
            int opcao = scanner.nextInt();
            System.out.println();

            switch (opcao) {
                case 1:
                    System.out.println(ClienteController.cadastrarCliente(id, nome, TipoClienteEnum.CLIENTE_PF));
                    return;
                case 2:
                    System.out.println(ClienteController.cadastrarCliente(id, nome, TipoClienteEnum.CLIENTE_PJ));
                    return;
                default:
                    System.out.println("\nNão foi selecionado uma opção valida.\n");
                    MenuInicio.abrirMenu();
            }
        }else {
            System.out.println("\nCliente já está cadastrado com o CPF/CNPJ digitado.\n");
        }
    }
}
