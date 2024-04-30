package br.gov.caixa;

import br.gov.caixa.view.CampanhaPromocional;
import br.gov.caixa.view.MenuInicio;


public class Main {
    public static void main(String[] args) {

        System.out.println("\n\n##############################\n" +
                            "#### Ada Sistema Bancário ####\n" +
                            "##############################\n");

        CampanhaPromocional.menuPromocao();

        while (MenuInicio.isRetornarInicio()) {
            MenuInicio.abrirMenu();
        }

    }
}