package br.gov.caixa.enums;

import br.gov.caixa.aplicacao.CadastroCliente;

public enum MenuSistema {
    CADASTRAR_CLIENTE {
        @Override
        public String opcaoMenu() {
            return "1 - Cadastrar Cliente";
        }

        @Override
        public void opcaoSelecionada() {
            CadastroCliente.cadastrarNovoCliente();
        }
    },
    CONSULTAR_CLIENTE {
        @Override
        public String opcaoMenu() {
            return "2 - Consulta/Manutenção do Cliente";
        }

        @Override
        public void opcaoSelecionada() {}
    },
    CONSULTAR_CONTA {
        @Override
        public String opcaoMenu() {
            return "3 - Consulta/Manutenção da Conta";
        }

        @Override
        public void opcaoSelecionada() {}
    },
    ABRIR_POUPANCA {
        @Override
        public String opcaoMenu() {
            return "4 - Abrir Conta Poupança";
        }

        @Override
        public void opcaoSelecionada() {}
    },
    INVESTIR {
        @Override
        public String opcaoMenu() {
            return "5 - Investir";
        }

        @Override
        public void opcaoSelecionada() {}
    },
    RELATORIOS {
        @Override
        public String opcaoMenu() {
            return "6 - Relatórios";
        }

        @Override
        public void opcaoSelecionada() {}
    };

    public abstract String opcaoMenu();

    public abstract void opcaoSelecionada();

    public static String imprimirOpcoes() {
        StringBuilder opcoesClassificacao = new StringBuilder();

        for (int i = 0; i <= MenuSistema.values().length - 1; i++) {
            opcoesClassificacao = opcoesClassificacao.append(MenuSistema.values()[i].opcaoMenu());
            opcoesClassificacao = opcoesClassificacao.append("\n");
        }

        return opcoesClassificacao.toString();
    }

    public static MenuSistema fromInteger(int menuSistema) {
        for (MenuSistema menu : values()) {
            if (menu.ordinal() + 1 == menuSistema) {
                return menu;
            }
        }
        return null;
    }
}
