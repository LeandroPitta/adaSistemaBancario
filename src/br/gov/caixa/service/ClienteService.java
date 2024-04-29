package br.gov.caixa.service;

import br.gov.caixa.model.Cliente;
import br.gov.caixa.model.ClientePF;
import br.gov.caixa.model.ClientePJ;
import br.gov.caixa.model.enums.TipoClienteEnum;
import br.gov.caixa.repository.ClienteRepositorio;

public class ClienteService {

    private static ClienteService instance;

    private ClienteService() {}

    public static ClienteService getInstance() {
        if (instance == null) {
            instance = new ClienteService();
        }
        return instance;
    }

    public Cliente cadastrarCliente(long cpfCnpj, String nome, TipoClienteEnum tipoClienteEnum) {

        Cliente cliente;

        switch (tipoClienteEnum) {
            case CLIENTE_PF:
                cliente = new ClientePF(cpfCnpj, nome, tipoClienteEnum);
                break;
            case CLIENTE_PJ:
                cliente = new ClientePJ(cpfCnpj, nome, tipoClienteEnum);
                break;
            default:
                throw new IllegalArgumentException("Tipo de cliente inválido.");
        }

        ContaService.getInstance().aberturaContaCorrente(cliente);
        ClienteRepositorio.getInstance().adicionar(cliente);
        return cliente;

    }
}
