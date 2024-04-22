package br.gov.caixa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultaManutencaoCliente {

    private long idEncontrado;
    private String nomeEncontrado;

    public void consultarCliente () {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDeseja consultar o cliente.\nDigite o CPF ou CNPJ (somente números): ");
        long id = scanner.nextLong();
        scanner.nextLine();

        for (Cliente cliente : ListaClientes.getClientes()) {
            if (cliente.getId() == id) {

                idEncontrado = cliente.getId();
                nomeEncontrado = cliente.getNome();
                StringBuilder cadastroCliente = new StringBuilder();

                List<Conta> contasCliente = new ArrayList<>();
                for (Conta conta : ListaContas.getListaContas()) {
                    if (conta.getIdCliente() == cliente.getId()) {
                        contasCliente.add(conta);
                    }
                }
                if (!contasCliente.isEmpty()) {
                    cadastroCliente.append("\nCliente: ").append(cliente.getNome()).append("\n");
                    cadastroCliente.append("CPF: ").append(cliente.getId()).append("\n");

                    String[] classificacaoSplit = cliente.getClass().toString().split("\\.");
                    String classificacao = classificacaoSplit[classificacaoSplit.length - 1];
                    cadastroCliente.append("Classificação: ").append(classificacao).append("\n");

                    cadastroCliente.append("Status: ").append(cliente.getStatus()).append("\n");
                    for (Conta conta : contasCliente) {
                        cadastroCliente.append("  --------").append("\n");
                        cadastroCliente.append("  Conta: ").append(conta.getId()).append("\n");

                        String[] tipoSplit = conta.getClass().toString().split("\\.");
                        String tipo = tipoSplit[tipoSplit.length - 1];
                        cadastroCliente.append("  Classificação: ").append(tipo).append("\n");

                        cadastroCliente.append("  Data de abertura: ").append(conta.getDataAtualizacao()).append("\n");
                        cadastroCliente.append("  Saldo: ").append(conta.getSaldo()).append("\n");
                    }
                    cadastroCliente.append("-------------------------------------------------------------------------------\n");
                }
                System.out.println(cadastroCliente);
                return;
            }
        }
        if (idEncontrado != 0) {}
        System.out.println("Cliente não encontrado.");
    }

    public long getIdEncontrado() {
        return idEncontrado;
    }

    public String getNomeEncontrado() {
        return nomeEncontrado;
    }
}
