package br.gov.caixa.view;

import br.gov.caixa.model.Cliente;
import br.gov.caixa.model.Conta;
import br.gov.caixa.repository.ClienteRepositorio;

import java.util.Scanner;

public class ConsultaManutencaoCliente {

    private long idEncontrado;
    private String nomeEncontrado;

    private Cliente cliente;

    public boolean consultarCliente () {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDeseja consultar o cliente.\nDigite o CPF ou CNPJ (somente números): ");
        long id = scanner.nextLong();
        scanner.nextLine();

        cliente = ClienteRepositorio.getInstance().buscarPorId(id);

        if (cliente.getId() == id) {

            StringBuilder cadastroCliente = new StringBuilder();

            cadastroCliente.append("\nCliente: ").append(cliente.getNome()).append("\n");
            cadastroCliente.append("CPF: ").append(cliente.getId()).append("\n");

            cadastroCliente.append("Classificação: ").append(cliente.getTipoClienteEnum()).append("\n");

            cadastroCliente.append("Status: ").append(cliente.getStatusEnum()).append("\n");
            for (Conta conta : cliente.getContas()) {
                cadastroCliente.append("  --------").append("\n");
                cadastroCliente.append("  Conta: ").append(conta.getId()).append("\n");

                String[] tipoSplit = conta.getClass().toString().split("\\.");
                String tipo = tipoSplit[tipoSplit.length - 1];
                cadastroCliente.append("  Classificação: ").append(tipo).append("\n");

                cadastroCliente.append("  Data de abertura: ").append(conta.getDataAtualizacao()).append("\n");
                cadastroCliente.append("  Saldo: ").append(conta.getSaldo()).append("\n");
            }
            cadastroCliente.append("-------------------------------------------------------------------------------\n");

            System.out.println(cadastroCliente);
            return true;
        }

        System.out.println("Cliente não encontrado.");

        return false;
    }

    public Cliente getClienteEncontrado() {
        return cliente;
    }
}
