package br.gov.caixa.enums;

import br.gov.caixa.clientes.*;
import br.gov.caixa.contas.ContaCorrente;

public enum ClassificacaoCliente {
    CLIENTE_PF {
        @Override
        public String instanciarCliente(long id, String nome) {
            String idString = Long.toString(id);
            if (idString.length() != 11) {
                return "CPF digitado não é válido!\n";
            }
            new ClientePF(id, nome, Status.ATIVO);
            new ContaCorrente(id);
            return "Cliente e Conta cadastrados com sucesso!\n";
        }
    },
    CLIENTE_PJ {
        @Override
        public String instanciarCliente(long id, String nome) {
            String idString = Long.toString(id);
            if (idString.length() != 14) {
                return "CNPJ digitado não é válido!\n";
            }
            new ClientePF(id, nome, Status.ATIVO);
            new ContaCorrente(id);
            return "Cliente e Conta cadastrados com sucesso!\n";
        }
    };

    public abstract String instanciarCliente(long id, String nome);

    public static ClassificacaoCliente fromInteger(int classificacao) {
        switch (classificacao) {
            case 1:
                return CLIENTE_PF;
            case 2:
                return CLIENTE_PJ;
            default:
                return null;
        }
    }
}
