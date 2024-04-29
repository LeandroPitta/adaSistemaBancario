package br.gov.caixa.controller;

import br.gov.caixa.model.Conta;
import br.gov.caixa.model.ContaPoupanca;
import br.gov.caixa.service.historico.HistoricoAberturaConta;

import java.util.Date;
import java.util.Scanner;

public class AberturaPoupanca {

    public void abrirPoupanca() {

        Scanner scanner = new Scanner(System.in);

        ConsultaManutencaoCliente consultaCliente = new ConsultaManutencaoCliente();
        consultaCliente.consultarCliente();

        if (consultaCliente.consultarCliente()) {
            System.out.print("\nDeseja abrir conta poupança para o cliente acima (sim ou nao): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("sim")) {

                Conta contaPoupanca = new ContaPoupanca(consultaCliente.getClienteEncontrado());

                HistoricoAberturaConta.salvar(contaPoupanca);

                System.out.println("Conta poupança aberta com sucesso!");
                return;
            }
            System.out.println("A conta poupança não foi aberta");
        }
    }
}
