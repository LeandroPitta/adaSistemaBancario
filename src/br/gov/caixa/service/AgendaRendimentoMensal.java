package br.gov.caixa.service;

import br.gov.caixa.model.Conta;
import br.gov.caixa.service.operacoes.factory.OpFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AgendaRendimentoMensal {

    private static final BigDecimal TAXARENDIMENTOPF = BigDecimal.valueOf(1.0001);
    private static final BigDecimal TAXARENDIMENTOPJ = BigDecimal.valueOf(1.0002);
    private static ScheduledExecutorService agenda;

    public static void agendarRendimentoInvestimento() {
        agenda = Executors.newSingleThreadScheduledExecutor();

        long initialDelay = ChronoUnit.MILLIS.between(LocalDateTime.now(), getDia1DoMes());
        long period = ChronoUnit.HOURS.between(LocalDateTime.now(), LocalDateTime.now().plusMonths(1).withDayOfMonth(1));

        agenda.scheduleAtFixedRate(AgendaRendimentoMensal::render, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    private static LocalDateTime getDia1DoMes() {
        return LocalDateTime.now().plusMonths(1).withDayOfMonth(1).truncatedTo(ChronoUnit.DAYS);
    }

    private static void render() {
        List<Conta> contas = ContaService.getInstance().listarContas();
        for (Conta conta : contas) {
            BigDecimal taxaRendimento = conta.getCliente().getTipoClienteEnum().equals("CLIENTE_PF") ? TAXARENDIMENTOPF : TAXARENDIMENTOPJ;
            BigDecimal novoSaldo = conta.getSaldo().multiply(taxaRendimento);
        }
    }
}