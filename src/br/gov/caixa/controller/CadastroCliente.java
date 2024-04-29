package br.gov.caixa.controller;

import br.gov.caixa.model.Cliente;
import br.gov.caixa.repository.ClienteRepositorio;
import br.gov.caixa.view.enums.ClassificacaoCliente;

import java.util.Scanner;

public abstract class CadastroCliente {
    public static void cadastrarNovoCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nVamos iniciar o cadastro do cliente!\nDigite o CPF ou CNPJ (somente números): ");
        long id = scanner.nextLong();
        scanner.nextLine();

        Cliente cliente = ClienteRepositorio.getInstance().buscarPorId(id);

        if (cliente == null) {
            System.out.print("Digite o nome ou razão social do cliente: ");
            String nome = scanner.nextLine();
            System.out.println();

            System.out.println("Escolha uma opção de classificação do cliente:");
            System.out.print(ClassificacaoCliente.imprimirOpcoes());
            System.out.print("Digite seu número: ");
            ClassificacaoCliente classificacao = ClassificacaoCliente.fromInteger(scanner.nextInt());

            try {
                System.out.println(classificacao.instanciarCliente(id, nome));
            } catch (NullPointerException ex) {
                System.out.println("\nNão foi selecionado uma classificação valida.\n");
                CadastroCliente.cadastrarNovoCliente();
            }
        }else {
            System.out.println("\nCliente já está cadastrado com o CPF/CNPJ digitado.\n");
        }
    }
}
