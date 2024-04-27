package br.gov.caixa.service;

import br.gov.caixa.model.Conta;
import br.gov.caixa.repository.ContaRepositorio;

import java.util.List;

public class ContaService {

    private static ContaService instance;

    private ContaService() {}

    public static ContaService getInstance() {
        if (instance == null) {
            instance = new ContaService();
        }
        return instance;
    }

    public void adicionarConta(Conta conta) {
        ContaRepositorio.getInstance().adicionar(conta);
    }

    public List<Conta> listarContas() {
        return ContaRepositorio.getInstance().listar();
    }

    public Conta buscarConta(Long id) {
        return ContaRepositorio.getInstance().buscarPorId(id);
    }
}
