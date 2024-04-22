package br.gov.caixa.util;

public class SequenciaId {

    private static long sequencialId = 0;

    public static synchronized long proximoId() {
        return ++sequencialId;
    }
}
