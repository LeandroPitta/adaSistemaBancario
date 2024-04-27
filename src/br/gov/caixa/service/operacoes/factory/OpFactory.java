package br.gov.caixa.service.operacoes.factory;

import br.gov.caixa.exceptions.TipoClienteInvalidoException;
import br.gov.caixa.model.Cliente;
import br.gov.caixa.model.ClientePF;
import br.gov.caixa.model.ClientePJ;
import br.gov.caixa.service.operacoes.OpConta;
import br.gov.caixa.service.operacoes.impl.OpContaPF;
import br.gov.caixa.service.operacoes.impl.OpContaPJ;

public final class OpFactory {

    private final OpConta<ClientePF> opeBancPF;
    private final OpConta<ClientePJ> opeBancPJ;

    private static OpFactory instance;

    private OpFactory() {
        this.opeBancPF = new OpContaPF();
        this.opeBancPJ = new OpContaPJ();
    }

    public static OpFactory getInstance() {
        if (instance == null) {
            instance = new OpFactory();
        }
        return instance;
    }

    public OpConta get(Cliente cliente) {
        if (cliente instanceof ClientePF) {
            return this.opeBancPF;
        } else if (cliente instanceof ClientePJ) {
            return this.opeBancPJ;
        } else {
            throw new TipoClienteInvalidoException();
        }
    }
}
