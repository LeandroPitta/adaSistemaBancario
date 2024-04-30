package br.gov.caixa.controller;

import br.gov.caixa.model.enums.TipoClienteEnum;
import br.gov.caixa.service.ClienteService;

public class ClienteController {

    public static String cadastrarCliente(long cpfCnpj, String nome, TipoClienteEnum tipoCliente) {

        ClienteService.getInstance().cadastrarCliente(cpfCnpj, nome, tipoCliente);

        return "Cliente e conta corrente cadastrados com sucesso!";
    }
}
