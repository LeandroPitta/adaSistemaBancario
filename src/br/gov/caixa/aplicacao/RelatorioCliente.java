package br.gov.caixa.aplicacao;

import br.gov.caixa.clientes.*;
import br.gov.caixa.contas.*;

import java.util.ArrayList;
import java.util.List;

public class RelatorioCliente {

    public String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder();

        for (Cliente cliente : ListaClientes.getClientes()) {
            List<Conta> contasCliente = new ArrayList<>();
            for (Conta conta : ListaContas.getListaContas()) {
                if (conta.getIdCliente() == cliente.getId()) {
                    contasCliente.add(conta);
                }
            }
            if (!contasCliente.isEmpty()) {
                relatorio.append("\nCliente: ").append(cliente.getNome()).append("\n");
                relatorio.append("CPF: ").append(cliente.getId()).append("\n");

                String[] classificacaoSplit = cliente.getClass().toString().split("\\.");
                String classificacao = classificacaoSplit[classificacaoSplit.length - 1];
                relatorio.append("Classificação: ").append(classificacao).append("\n");

                relatorio.append("Status: ").append(cliente.getStatus()).append("\n");
                for (Conta conta : contasCliente) {
                    relatorio.append("  --------").append("\n");
                    relatorio.append("  Conta: ").append(conta.getId()).append("\n");

                    String[] tipoSplit = conta.getClass().toString().split("\\.");
                    String tipo = tipoSplit[tipoSplit.length - 1];
                    relatorio.append("  Classificação: ").append(tipo).append("\n");

                    relatorio.append("  Data de abertura: ").append(conta.getDataAtualizacao()).append("\n");
                    relatorio.append("  Saldo: ").append(conta.getSaldo()).append("\n");
                }
                relatorio.append("-------------------------------------------------------------------------------\n\n");
            }
        }

        return relatorio.toString();
    }
}
