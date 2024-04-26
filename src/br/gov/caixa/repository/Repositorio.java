package br.gov.caixa.repository;

import java.util.List;

public interface Repositorio<T> {

    void adicionar(T item);

    List<T> listar();

    T buscarPorId(Long id);
}
