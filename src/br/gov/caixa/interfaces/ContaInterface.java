package br.gov.caixa.interfaces;

import br.gov.caixa.contas.HistoricoAcao;

public interface ContaInterface {

    void sacar(double valorPretendido);
    void depositar(double valorPretendido);
    void transferir(double valorPretendido, int idDestino);
    void consultarSaldo();
    void registrarHistoricoAcao(HistoricoAcao acao);
}
