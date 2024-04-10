package br.gov.caixa.aplicacao.acao;

import br.gov.caixa.clientes.Cliente;
import br.gov.caixa.clientes.ListaClientes;
import br.gov.caixa.contas.Conta;
import br.gov.caixa.contas.ListaContas;
import br.gov.caixa.contas.services.historico_operacoes.HistoricoAberturaConta;
import br.gov.caixa.contas.services.historico_operacoes.HistoricoOperacaoSaldo;
import br.gov.caixa.enums.TipoOperacaoConta;

import java.util.Date;
import java.util.Scanner;

public class ConsultarSaldo {

    public static void consultarSaldo () {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nDigite o número da conta: ");
        Long id = scanner.nextLong();

        boolean contaEncontrada = false;
        for (Conta conta : ListaContas.getListaContas()) {
            if (conta.getId() == id) {
                System.out.println("O saldo da conta é: " + conta.getSaldo() + "\n\n");
                new HistoricoOperacaoSaldo(new Date(), TipoOperacaoConta.CONSULTA_SALDO, conta.getSaldo(), conta, "Efetuado a consulta de saldo ");
                contaEncontrada = true;
                break;
            }
        }
        if (!contaEncontrada) {
            System.out.println("\nConta não encontrada\n");
        }
    }
}
