package br.gov.caixa.service;

import br.gov.caixa.model.Conta;
import br.gov.caixa.repository.HistoricoRepositorio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record HistoricoService(LocalDateTime data, BigDecimal valorPretendido,
                               BigDecimal valorReal, Conta contaOrigem, Conta contaDestino, String observacao) {

    public static void historicoAberturaConta(Conta conta) {
        HistoricoService novoHistorico = new HistoricoService(LocalDateTime.now(),
                null, null, conta, null, "Conta aberta com sucesso!");
        HistoricoRepositorio.getInstance().adicionar(novoHistorico);
    }

    public static void historicoDeposito(BigDecimal valor, Conta conta) {
        HistoricoService novoHistorico = new HistoricoService(LocalDateTime.now(), valor,
                null, conta, null, "Deposito efetuado com sucesso!");
        HistoricoRepositorio.getInstance().adicionar(novoHistorico);
    }

    public static void historicoSaque(BigDecimal valorPretendido, BigDecimal valorReal, Conta contaOrigem) {
        HistoricoService novoHistorico = new HistoricoService(LocalDateTime.now(), valorPretendido,
                valorReal, contaOrigem, null, "Saque efetuado com sucesso!");
        HistoricoRepositorio.getInstance().adicionar(novoHistorico);
    }

    public static void historicoInvestimento(BigDecimal valor, Conta conta) {
        HistoricoService novoHistorico = new HistoricoService(LocalDateTime.now(), valor, null,
                conta, null, "Investimento efetuado com sucesso!");
        HistoricoRepositorio.getInstance().adicionar(novoHistorico);
    }

    public static void historicoTransferencia(BigDecimal valor, Conta contaOrigem, Conta contaDestino) {
        HistoricoService novoHistorico = new HistoricoService(LocalDateTime.now(), valor, null,
                contaOrigem, contaDestino, "Trasferência efetuada com sucesso!");
        HistoricoRepositorio.getInstance().adicionar(novoHistorico);
    }

}
