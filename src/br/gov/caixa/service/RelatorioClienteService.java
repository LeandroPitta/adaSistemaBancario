package br.gov.caixa.service;

import br.gov.caixa.model.Cliente;
import br.gov.caixa.model.Conta;
import br.gov.caixa.repository.ClienteRepositorio;

public class RelatorioClienteService {

    public static String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder();

        for (Cliente cliente : ClienteRepositorio.getInstance().listar()) {
            relatorio.append("\nCliente: ").append(cliente.getNome()).append("\n");
            relatorio.append("CPF: ").append(cliente.getId()).append("\n");

            relatorio.append("Classificação: ").append(cliente.getTipoClienteEnum()).append("\n");

            relatorio.append("Status: ").append(cliente.getStatusEnum()).append("\n");

            for (Conta conta : cliente.getContas()) {
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

        return relatorio.toString();
    }
}
