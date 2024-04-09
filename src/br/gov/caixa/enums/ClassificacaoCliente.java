package br.gov.caixa.enums;

import br.gov.caixa.clientes.*;
import br.gov.caixa.contas.*;
import br.gov.caixa.contas.services.historico_operacoes.HistoricoAberturaConta;

import java.util.Date;

public enum ClassificacaoCliente {
    CLIENTE_PF {

        @Override
        public String opcaoMenu() {return "1 - Cliente PF";}

        @Override
        public String instanciarCliente(long id, String nome) {
            String idString = Long.toString(id);
            if (idString.length() != 11) {
                return "\nCPF digitado não é válido!\n";
            }
            new ClientePF(id, nome, Status.ATIVO);
            Conta conta = new ContaCorrente(id);
            new HistoricoAberturaConta(new Date(), TipoOperacaoConta.ABERTURA_CONTA, conta, "Cliente " + nome + " cadastrado e abertura de conta efetuada com sucesso!");
            return "\nCliente e Conta cadastrados com sucesso!\n";
        }
    },
    CLIENTE_PJ {

        @Override
        public String opcaoMenu() {return "2 - Cliente PJ";}

        @Override
        public String instanciarCliente(long id, String nome) {
            String idString = Long.toString(id);
            if (idString.length() != 14) {
                return "\nCNPJ digitado não é válido!\n";
            }
            new ClientePJ(id, nome, Status.ATIVO);
            Conta conta = new ContaCorrente(id);
            new HistoricoAberturaConta(new Date(), TipoOperacaoConta.ABERTURA_CONTA, conta, "Cliente " + nome + " cadastrado e abertura de conta efetuada com sucesso!");
            return "\nCliente e Conta cadastrados com sucesso!\n";
        }
    };

    public abstract String opcaoMenu();

    public abstract String instanciarCliente(long id, String nome);

    public static String imprimirOpcoes() {
        StringBuilder opcoesClassificacao = new StringBuilder();

        for (int i = 0; i <= ClassificacaoCliente.values().length - 1; i++) {
            opcoesClassificacao = opcoesClassificacao.append(ClassificacaoCliente.values()[i].opcaoMenu());
            opcoesClassificacao = opcoesClassificacao.append("\n");
        }

        return opcoesClassificacao.toString();
    }

    public static ClassificacaoCliente fromInteger(int classificacao) {
        for (ClassificacaoCliente classificacaoCliente : values()) {
            if (classificacaoCliente.ordinal() + 1 == classificacao) {
                return classificacaoCliente;
            }
        }
        return null;
    }
}
