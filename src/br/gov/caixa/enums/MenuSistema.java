package br.gov.caixa.enums;

import br.gov.caixa.aplicacao.CadastroCliente;
import br.gov.caixa.aplicacao.MenuInicio;

import java.util.Scanner;

public enum MenuSistema {
    CADASTRAR_CLIENTE {
        @Override
        public String opcaoMenu() {
            return "1 - Cadastrar cliente";
        }

        @Override
        public void opcaoSelecionada() {
            CadastroCliente.cadastrarNovoCliente();
        }
    },
    CONSULTAR_CLIENTE {
        @Override
        public String opcaoMenu() {
            return "2 - Consulta e manutenção do cliente";
        }

        @Override
        public void opcaoSelecionada() {}
    },
    CONSULTAR_CONTA {
        @Override
        public String opcaoMenu() {
            return "3 - Consulta, manutenção e operações da conta";
        }

        @Override
        public void opcaoSelecionada() {}
    },
    ABRIR_POUPANCA {
        @Override
        public String opcaoMenu() {
            return "4 - Abrir conta poupança";
        }

        @Override
        public void opcaoSelecionada() {}
    },
    RELATORIOS {
        @Override
        public String opcaoMenu() {
            return "5 - Relatórios";
        }

        @Override
        public void opcaoSelecionada() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("\n");
            System.out.print(MenuRelatorios.imprimirOpcoes());
            System.out.print("Para selecionar uma opção, digite seu número: ");
            MenuRelatorios relatorios = MenuRelatorios.fromInteger(scanner.nextInt());
            try {
                relatorios.opcaoSelecionada();
            } catch (NullPointerException ex) {
                System.out.println("\nNão foi selecionado uma classificação valida.");
                MenuInicio.abrirMenu();
            }

        }
    };

    public abstract String opcaoMenu();

    public abstract void opcaoSelecionada();

    public static String imprimirOpcoes() {
        StringBuilder opcao = new StringBuilder();

        for (int i = 0; i <= MenuSistema.values().length - 1; i++) {
            opcao.append(MenuSistema.values()[i].opcaoMenu()).append("\n");
        }

        return opcao.toString();
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
