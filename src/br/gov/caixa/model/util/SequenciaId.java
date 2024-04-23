package br.gov.caixa.model.util;

public class SequenciaId {

    private static long sequencialId = 0;

    public static synchronized long proximoId() {
        return ++sequencialId;
    }
}
