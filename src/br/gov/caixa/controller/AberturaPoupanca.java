package br.gov.caixa.controller;

import br.gov.caixa.service.historico_operacoes.HistoricoAberturaConta;
import br.gov.caixa.service.TipoOperacaoConta;

import java.util.Date;
import java.util.Scanner;

public class AberturaPoupanca {

    public void abrirPoupanca() {

        Scanner scanner = new Scanner(System.in);

        ConsultaManutencaoCliente consultaCliente = new ConsultaManutencaoCliente();
        consultaCliente.consultarCliente();

        if (consultaCliente.getIdEncontrado() != 0) {
            System.out.print("\nDeseja abrir conta poupança para o cliente acima (sim ou nao): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("sim")) {
                Conta contaPoupanca = new ContaPoupanca(consultaCliente.getIdEncontrado());
                new HistoricoAberturaConta(new Date(), TipoOperacaoConta.ABERTURA_CONTA, contaPoupanca, "Efetuada abertura de conta poupança com sucesso para o cliente " + consultaCliente.getNomeEncontrado());
                System.out.println("Conta poupança aberta com sucesso!");
                return;
            }
            System.out.println("A conta poupança não foi aberta");
        }
    }
}
