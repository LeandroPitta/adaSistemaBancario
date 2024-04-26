package br.gov.caixa.repository;

import br.gov.caixa.model.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContaRepositorio implements Repositorio<Conta> {

    private List<Conta> lista = new ArrayList<>();

    @Override
    public void adicionar(Conta conta) {
        lista.add(conta);
    }

    @Override
    public List<Conta> listar() {
        return lista;
    }
}
