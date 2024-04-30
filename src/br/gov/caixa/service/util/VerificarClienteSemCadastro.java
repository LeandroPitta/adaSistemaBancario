package br.gov.caixa.service.util;

import br.gov.caixa.repository.ClienteRepositorio;

public class VerificarClienteSemCadastro {

    public static boolean verificar(long cpf) {
        return ClienteRepositorio.getInstance().buscarPorId(cpf) == null;
    }
}
