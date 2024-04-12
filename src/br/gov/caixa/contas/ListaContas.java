package br.gov.caixa.contas;

import java.util.ArrayList;
import java.util.List;

public class ListaContas {

    private static List<Conta> contas = new ArrayList<>();

    public static void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public static List<Conta> getListaContas() {
        return contas;
    }
}
