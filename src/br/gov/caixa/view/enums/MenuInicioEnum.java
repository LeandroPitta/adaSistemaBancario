package br.gov.caixa.view.enums;

import br.gov.caixa.view.AberturaPoupanca;
import br.gov.caixa.view.CadastroCliente;
import br.gov.caixa.view.ConsultaManutencaoCliente;
import br.gov.caixa.view.MenuInicio;
import br.gov.caixa.view.MenuRelatorios;

import java.util.Scanner;

public enum MenuInicioEnum {
    CADASTRAR_CLIENTE("1 - Cadastrar cliente")  {

        @Override
        public void opcaoSelecionada() {
            CadastroCliente.cadastrarNovoCliente();
        }
    },
    CONSULTAR_CLIENTE("2 - Consultar cliente") {

        @Override
        public void opcaoSelecionada() {
            new ConsultaManutencaoCliente().consultarCliente();
        }
    },
    CONSULTAR_CONTA("3 - Consulta e operações de conta") {
        @Override
        public void opcaoSelecionada() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n");
            System.out.print(MenuOperacaoConta.imprimirOpcoes());
            System.out.print("Para selecionar uma opção, digite seu número: ");
            MenuOperacaoConta operacoes = MenuOperacaoConta.fromInteger(scanner.nextInt());
            try {
                operacoes.opcaoSelecionada();
            } catch (NullPointerException ex) {
                System.out.println("\nNão foi selecionado uma opção valida.");
                MenuInicio.abrirMenu();
            }
        }
    },
    ABRIR_POUPANCA("4 - Abrir conta poupança") {
        @Override
        public void opcaoSelecionada() {
            new AberturaPoupanca().abrirPoupanca();
        }
    },
    RELATORIOS("5 - Relatórios") {
        @Override
        public void opcaoSelecionada() {
            MenuRelatorios.imprimirMenuRelatorios();
        }
    },
    ENCERRAR_APLICACAO("6 - Encerrar aplicação") {
        @Override
        public void opcaoSelecionada() {
            System.exit(0);
        }
    };

    public final String opcaoMenu;

    MenuInicioEnum(String opcaoMenu) {
        this.opcaoMenu = opcaoMenu;
    }

    public abstract void opcaoSelecionada();

    public static String imprimirOpcoes() {
        StringBuilder opcao = new StringBuilder();

        for (int i = 0; i <= values().length - 1; i++) {
            opcao.append(values()[i].opcaoMenu).append("\n");
        }

        return opcao.toString();
    }

    public static MenuInicioEnum fromInteger(int menuSistema) {
        for (MenuInicioEnum menu : values()) {
            if (menu.ordinal() + 1 == menuSistema) {
                return menu;
            }
        }
        return null;
    }
}
