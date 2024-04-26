package br.gov.caixa.service;

import br.gov.caixa.model.Conta;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AgendaRendimentoMensal {

    private static final double TAXARENDIMENTOPF = 0.01;
    private static final double TAXARENDIMENTOPJ = 0.02;
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
        List<Conta> contas = ContaService.listarContas();
        for (Conta conta : contas) {
            double taxaRendimento = conta.getCliente().getTipoClienteEnum().equals("CLIENTE_PF") ? TAXARENDIMENTOPF : TAXARENDIMENTOPJ;
            double novoSaldo = conta.getSaldo() + (conta.getSaldo() * taxaRendimento);
        }
    }
}