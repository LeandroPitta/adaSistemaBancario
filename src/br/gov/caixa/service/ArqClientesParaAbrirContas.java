package br.gov.caixa.service;

import br.gov.caixa.model.Cliente;
import br.gov.caixa.model.ClientePF;
import br.gov.caixa.model.ClientePJ;
import br.gov.caixa.model.enums.TipoClienteEnum;
import br.gov.caixa.service.operacoes.factory.OpFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ArqClientesParaAbrirContas {

    private static final BigDecimal VALOR_INICIAL = new BigDecimal("50");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void tratarArqAbrirCtaExportar() throws IOException {

        Path pathOrigem = Path.of("C:/Dev/Java/AdaTech/ProjetoSistemaBancario/pessoas.csv");

        List<String> contasAbertas = Files.lines(pathOrigem)
                .skip(1) // Pula o cabeçalho
                .map(linha -> linha.split(","))
                .filter(dados -> dados.length == 4)
                .filter(dados -> {
                    String tipo = dados[3];
                    if ("2".equals(tipo)) { // Se for PF
                        LocalDate dataNascimento = LocalDate.parse(dados[1], FORMATTER);
                        return !LocalDate.now().minusYears(18).isBefore(dataNascimento);
                    }
                    return true;
                })
                .map(dados -> {
                    String nome = dados[0];
                    long documento = Long.parseLong(dados[2]);
                    String tipo = dados[3];

                    Cliente cliente = "1".equals(tipo) ? new ClientePJ(documento, nome, TipoClienteEnum.CLIENTE_PJ) : new ClientePF(documento, nome, TipoClienteEnum.CLIENTE_PF);

                    OpFactory.getInstance().get(cliente).depositar(cliente, cliente.getContas().get(0).getId(), VALOR_INICIAL);

                    return String.format("%s;%s;%s;%d;50", nome, documento, "2".equals(tipo) ? "PJ" : "PF", cliente.getContas().get(0).getId());
                })
                .toList();

        Path pathDestino = Path.of("C:/Dev/Java/AdaTech/ProjetoSistemaBancario/contas-abertas.csv");
        Files.write(pathDestino, contasAbertas);
    }
}
