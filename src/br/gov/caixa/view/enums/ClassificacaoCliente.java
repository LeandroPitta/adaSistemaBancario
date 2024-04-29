package br.gov.caixa.view.enums;

import br.gov.caixa.model.*;
import br.gov.caixa.model.enums.TipoClienteEnum;
import br.gov.caixa.service.historico.HistoricoAberturaConta;

public enum ClassificacaoCliente {
    CLIENTE_PF("1 - Cliente PF") {

        @Override
        public String instanciarCliente(long id, String nome) {
            String idString = Long.toString(id);

            Cliente clientePF = new ClientePF(id, nome, TipoClienteEnum.CLIENTE_PF);

            HistoricoAberturaConta.salvar(clientePF.getContas().get(0));

            return "\nCliente e Conta cadastrados com sucesso!\n";
        }
    },
    CLIENTE_PJ("2 - Cliente PJ") {

        @Override
        public String instanciarCliente(long id, String nome) {
            String idString = Long.toString(id);

            Cliente clientePJ = new ClientePJ(id, nome, TipoClienteEnum.CLIENTE_PJ);

            HistoricoAberturaConta.salvar(clientePJ.getContas().get(0));

            return "\nCliente e Conta cadastrados com sucesso!\n";
        }
    };

    public final String opcaoMenu;

    ClassificacaoCliente(String opcaoMenu) {
        this.opcaoMenu = opcaoMenu;
    }

    public abstract String instanciarCliente(long id, String nome);

    public static String imprimirOpcoes() {
        StringBuilder opcoesClassificacao = new StringBuilder();

        for (int i = 0; i <= ClassificacaoCliente.values().length - 1; i++) {
            opcoesClassificacao = opcoesClassificacao.append(values()[i].opcaoMenu).append("\n");
        }
        return opcoesClassificacao.toString();
    }

    public static ClassificacaoCliente fromInteger(int classificacao) {
        for (ClassificacaoCliente classificacaoCliente : values()) {
            if (classificacaoCliente.ordinal() + 1 == classificacao) {
                return classificacaoCliente;
            }
        }
        return null;
    }
}
