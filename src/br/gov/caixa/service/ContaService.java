package br.gov.caixa.service;

import br.gov.caixa.model.Conta;
import br.gov.caixa.repository.ContaRepositorio;

import java.util.List;

public class ContaService {

    private static ContaRepositorio contaRepositorio = new ContaRepositorio();

    public static void adicionarConta(Conta conta) {
        contaRepositorio.adicionar(conta);
    }

    public static List<Conta> listarContas() {
        return contaRepositorio.listar();
    }
}
