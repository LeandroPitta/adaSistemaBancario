package br.gov.caixa.aplicacao.menu_enums;

import br.gov.caixa.aplicacao.acao.ConsultarSaldo;
import br.gov.caixa.aplicacao.acao.Depositar;
import br.gov.caixa.aplicacao.acao.Sacar;
import br.gov.caixa.aplicacao.acao.Transferir;

import java.util.Scanner;

public enum MenuOperacaoConta {
    CONSULTA_SALDO("1 - Consultar Saldo") {

        @Override
        public void opcaoSelecionada() {
            ConsultarSaldo.consultarSaldo();
        }
    },
    SAQUE("2 - Sacar") {

        @Override
        public void opcaoSelecionada() {
            Sacar.sacar();
        }
    },
    DEPOSITO("3 - Depositar") {

        @Override
        public void opcaoSelecionada() {
            Depositar.depositar();
        }
    },
    TRANSFERENCIA("4 - Transferir") {

        @Override
        public void opcaoSelecionada() {
            Transferir.transferir();
        }
    },
    INVESTIMENTO("5 - Investir") {

        @Override
        public void opcaoSelecionada() {}
    };

    public final String opcaoMenu;

    MenuOperacaoConta(String opcaoMenu) {
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

    public static MenuOperacaoConta fromInteger(int menuOperaco) {
        for (MenuOperacaoConta menu : values()) {
            if (menu.ordinal() + 1 == menuOperaco) {
                return menu;
            }
        }
        return null;
    }
}
