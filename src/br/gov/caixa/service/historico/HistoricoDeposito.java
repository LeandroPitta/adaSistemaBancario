package br.gov.caixa.service.historico;

import br.gov.caixa.model.Conta;
import br.gov.caixa.repository.HistoricoRepositorio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record HistoricoDeposito(LocalDateTime data, BigDecimal valor, Conta conta, String observacao) implements Historico {

    private HistoricoDeposito(BigDecimal valor, Conta conta) {

        this(LocalDateTime.now(), valor, conta, "Deposito realizado com sucesso");

    }

    public static void salvar(BigDecimal valor, Conta conta) {

        Historico historicoDeposito = new HistoricoDeposito(valor, conta);

        HistoricoRepositorio.getInstance().adicionar(historicoDeposito);

    }
}
