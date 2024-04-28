package br.gov.caixa.service.historico;

import br.gov.caixa.model.Conta;
import br.gov.caixa.repository.HistoricoRepositorio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record HistoricoSaque(LocalDateTime data, BigDecimal valorPretendido, BigDecimal valorReal, Conta contaOrigem, String observacao) implements Historico {

    private HistoricoSaque(BigDecimal valorPretendido, BigDecimal valorReal, Conta contaOrigem) {

        this(LocalDateTime.now(), valorPretendido, valorReal, contaOrigem, "Saque realizado com sucesso");

    }

    public static void salvar(BigDecimal valorPretendido, BigDecimal valorReal, Conta contaOrigem) {

        Historico historicoSaque = new HistoricoSaque(valorPretendido, valorReal, contaOrigem);

        HistoricoRepositorio.getInstance().adicionar(historicoSaque);
    }
}
