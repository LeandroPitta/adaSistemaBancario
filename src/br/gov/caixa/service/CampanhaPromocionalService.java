package br.gov.caixa.service;

import br.gov.caixa.model.Cliente;
import br.gov.caixa.model.enums.TipoClienteEnum;
import br.gov.caixa.service.operacoes.factory.OpFactory;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CampanhaPromocionalService {

    private static final BigDecimal VALOR_INICIAL = new BigDecimal("50");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void executar() throws IOException {

        Path pathOrigem = Path.of("pessoas.csv");

        List<String> contasAbertas = Files.lines(pathOrigem)
                .skip(1)
                .map(linha -> linha.split(","))
                .filter(dados -> {
                    String tipo = dados[3];
                    if ("2".equals(tipo)) {
                        LocalDate dataNascimento = LocalDate.parse(dados[1], FORMATTER);
                        return !LocalDate.now().minusYears(18).isBefore(dataNascimento);
                    }
                    return true;
                })
                .map(dados -> {
                    String nome = dados[0];
                    long documento = Long.parseLong(dados[2]);
                    String tipo = dados[3];

                    Cliente cliente = "1".equals(tipo)
                            ? ClienteService.getInstance().cadastrarCliente(documento, nome, TipoClienteEnum.CLIENTE_PJ)
                            : ClienteService.getInstance().cadastrarCliente(documento, nome, TipoClienteEnum.CLIENTE_PF);

                    OpFactory.getInstance().get(cliente).depositar(cliente, cliente.getContas().get(0).getId(), VALOR_INICIAL);

                    return String.format("%s;%s;%s;%d;50", nome, documento, "1".equals(tipo) ? "PJ" : "PF", cliente.getContas().get(0).getId());
                })
                .toList();

        Path pathDestino = Path.of("contas-abertas.csv");
        Files.write(pathDestino, contasAbertas);
    }
}
