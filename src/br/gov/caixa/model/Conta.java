package br.gov.caixa.model;

public interface Conta {

    long getId();
    double getSaldo();
    void setSaldo(double saldo);
    Cliente getCliente();
}
