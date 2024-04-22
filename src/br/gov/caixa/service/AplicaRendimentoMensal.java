package br.gov.caixa.service;

import br.gov.caixa.service.operacoes.RendimentoInvestimentoPF;
import br.gov.caixa.service.operacoes.RendimentoInvestimentoPJ;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AplicaRendimentoMensal {

    private static ScheduledExecutorService agenda;

    public static void agendaRendimentoInvestimento() {
        agenda = Executors.newSingleThreadScheduledExecutor();

        long initialDelay = ChronoUnit.MILLIS.between(LocalDateTime.now(), getDia1DoMes());
        long period = ChronoUnit.HOURS.between(LocalDateTime.now(), LocalDateTime.now().plusMonths(1).withDayOfMonth(1));

        agenda.scheduleAtFixedRate(AplicaRendimentoMensal::aplicarRendimento, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    private static LocalDateTime getDia1DoMes() {
        return LocalDateTime.now().plusMonths(1).withDayOfMonth(1).truncatedTo(ChronoUnit.DAYS);
    }

    private static void aplicarRendimento() {

        for (Conta conta: ListaContas.getListaContas()) {
            if (conta instanceof ContaInvestimento) {
                for (Cliente cliente: ListaClientes.getClientes()) {
                    if (conta.getIdCliente() == cliente.getId() && cliente instanceof ClientePF) {
                        new RendimentoInvestimentoPF().render(conta);
                    } else if (conta.getIdCliente() == cliente.getId() && cliente instanceof ClientePJ) {
                        new RendimentoInvestimentoPJ().render(conta);
                    }
                }
            }
        }
    }
}
