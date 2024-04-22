package br.gov.caixa.service.operacoes;

public class TransferenciaPadrao implements Transferencia {

    @Override
    public void transferir(Conta conta, double valorPretendido, Conta contaDestino) {
        if (ConfereSaldoSuficiente.conferir(conta, valorPretendido)) {
            conta.setSaldo(conta.getSaldo() - valorPretendido);
            contaDestino.setSaldo(contaDestino.getSaldo() + valorPretendido);
        }
    }
}
