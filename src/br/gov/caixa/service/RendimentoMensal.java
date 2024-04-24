package br.gov.caixa.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RendimentoMensal {

    private static ScheduledExecutorService agenda;

    public static void agendaRendimentoInvestimento() {
        agenda = Executors.newSingleThreadScheduledExecutor();

        long initialDelay = ChronoUnit.MILLIS.between(LocalDateTime.now(), getDia1DoMes());
        long period = ChronoUnit.HOURS.between(LocalDateTime.now(), LocalDateTime.now().plusMonths(1).withDayOfMonth(1));

        agenda.scheduleAtFixedRate(RendimentoMensal::rendimentoCtaAplicacao, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    private static LocalDateTime getDia1DoMes() {
        return LocalDateTime.now().plusMonths(1).withDayOfMonth(1).truncatedTo(ChronoUnit.DAYS);
    }

    private static void rendimentoCtaAplicacao() {
        ListaContas.getListaContas().stream()
                .filter(conta -> conta instanceof ContaInvestimento)
                .forEach(conta -> new RendimentoInvestimento().render(conta));
    }

}
