package br.gov.caixa.util;


public class RetornarContaInvestimento {

    public static Conta retornarConta(Long idCliente) {

        Conta contaInvestimento = null;
        for (Conta conta : ListaContas.getListaContas()) {
            if (conta.getIdCliente() == idCliente && conta instanceof ContaInvestimento) {
                contaInvestimento = conta;
                break;
            }
        }

        if (contaInvestimento == null) {
            contaInvestimento = new ContaInvestimento(idCliente);
        }

        return contaInvestimento;
    }
}
