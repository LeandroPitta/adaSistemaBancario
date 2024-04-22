package br.gov.caixa.service.operacoes;

public class TransferenciaContaPj implements Transferencia {

    private final double TARIFADEBITOPJ = 0.005;
    private double valorReal;
    private double taxa;

    @Override
    public void transferir(Conta conta, double valorPretendido, Conta contaDestino) {
        taxa = valorPretendido * TARIFADEBITOPJ;
        this.valorReal = valorPretendido + taxa;
        if (ConfereSaldoSuficiente.conferir(conta, valorReal)) {
            conta.setSaldo(conta.getSaldo() - valorReal);
            contaDestino.setSaldo(contaDestino.getSaldo() + valorPretendido);
        }
    }

    public double getValorReal() {
        return valorReal;
    }

    public double getTaxa(){
        return taxa;
    }
}
