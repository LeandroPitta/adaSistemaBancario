package br.gov.caixa.controller;

import br.gov.caixa.service.CampanhaPromocionalService;

import java.io.IOException;

public class CampanhaPromocionalController {

    public static boolean executarCampanhaPromocional() {

        try {
            CampanhaPromocionalService.executar();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
