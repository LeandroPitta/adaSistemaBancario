package br.gov.caixa.service.historico;

import br.gov.caixa.model.Conta;
import br.gov.caixa.repository.HistoricoRepositorio;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record HistoricoTransferencia(LocalDateTime data, BigDecimal valor, Conta contaOrigem, Conta contaDestino, String observacao) implements Historico {

    private HistoricoTransferencia(BigDecimal valor, Conta contaOrigem, Conta contaDestino) {

        this(LocalDateTime.now(), valor, contaOrigem, contaDestino, "Transferência realizada com sucesso!");

    }

    public static void salvar(BigDecimal valor, Conta contaOrigem, Conta contaDestino) {

        Historico historico = new HistoricoTransferencia(valor, contaOrigem, contaDestino);

        HistoricoRepositorio.getInstance().adicionar(historico);

    }

}
