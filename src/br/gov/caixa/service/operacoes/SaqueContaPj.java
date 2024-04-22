package br.gov.caixa.service.operacoes;

public class SaqueContaPj implements Saque {

    private final double TARIFADEBITOPJ = 0.005;
    private double valorReal;
    private double taxa;

    @Override
    public void sacar(Conta conta, double valorPretendido) {
        taxa = valorPretendido * TARIFADEBITOPJ;
        valorReal = valorPretendido + taxa;
        if (ConfereSaldoSuficiente.conferir(conta, valorReal)) {
            conta.setSaldo(conta.getSaldo() - valorReal);
        }
    }

    public double getTaxa() {
        return taxa;
    }

    public double getValorReal() {
        return valorReal;
    }
}
