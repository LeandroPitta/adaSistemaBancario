package br.gov.caixa.service.historico;

import br.gov.caixa.model.Conta;
import br.gov.caixa.repository.HistoricoRepositorio;

import java.time.LocalDateTime;

public record HistoricoAberturaConta(LocalDateTime data, Conta conta, String observacao) implements Historico {

    private HistoricoAberturaConta(Conta conta) {

        this(LocalDateTime.now(), conta, "Conta aberta com sucesso");

    }

    public static void salvar(Conta conta) {

        Historico historicoAberturaConta = new HistoricoAberturaConta(conta);

        HistoricoRepositorio.getInstance().adicionar(historicoAberturaConta);
    }
}
