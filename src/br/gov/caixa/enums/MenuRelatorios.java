package br.gov.caixa.enums;

import br.gov.caixa.aplicacao.RelatorioCliente;
import br.gov.caixa.aplicacao.RelatorioHistoricoOperacoes;

public enum MenuRelatorios {
    RELATORIO_CLIENTES{
        @Override
        public String opcaoMenu() {
            return "1 - Relatório de Clientes";
        }

        @Override
        public void opcaoSelecionada() {
            System.out.println(new RelatorioCliente().gerarRelatorio());
        }
    },
    HISTORICO_OPERACOES{
        @Override
        public String opcaoMenu() {
            return "2 - Histórico de Operações";
        }

        @Override
        public void opcaoSelecionada() {
            System.out.println(new RelatorioHistoricoOperacoes().gerarRelatorio());
        }
    };

    public abstract String opcaoMenu();

    public abstract void opcaoSelecionada();

    public static String imprimirOpcoes() {
        StringBuilder opcao = new StringBuilder();

        for (int i = 0; i <= values().length - 1; i++) {
            opcao.append(values()[i].opcaoMenu()).append("\n");
        }

        return opcao.toString();
    }

    public static MenuRelatorios fromInteger(int menuRelatorios) {
        for (MenuRelatorios menu : values()) {
            if (menu.ordinal() + 1 == menuRelatorios) {
                return menu;
            }
        }
        return null;
    }
}