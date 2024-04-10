package br.gov.caixa.enums;

public enum MenuOperacaoConta {
    CONSULTA_SALDO {
        @Override
        public String opcaoMenu() {
            return "1 - Consultar Saldo";
        }

        @Override
        public void opcaoSelecionada() {}
    },
    SAQUE {
        @Override
        public String opcaoMenu() {
            return "2 - Sacar";
        }

        @Override
        public void opcaoSelecionada() {}
    },
    DEPOSITO {
        @Override
        public String opcaoMenu() {
            return "3 - Depositar";
        }

        @Override
        public void opcaoSelecionada() {}
    },
    TRANSFERENCIA {
        @Override
        public String opcaoMenu() {
            return "4 - Transferir";
        }

        @Override
        public void opcaoSelecionada() {}
    },
    INVESTIMENTO {
        @Override
        public String opcaoMenu() {
            return "5 - Investir";
        }

        @Override
        public void opcaoSelecionada() {}
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

    public static MenuOperacaoConta fromInteger(int menuOperaco) {
        for (MenuOperacaoConta menu : values()) {
            if (menu.ordinal() + 1 == menuOperaco) {
                return menu;
            }
        }
        return null;
    }
}
