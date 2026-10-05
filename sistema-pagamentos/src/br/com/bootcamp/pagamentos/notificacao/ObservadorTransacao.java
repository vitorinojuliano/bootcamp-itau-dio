package br.com.bootcamp.pagamentos.notificacao;

import br.com.bootcamp.pagamentos.modelo.Transacao;

public interface ObservadorTransacao {

    void aoRealizarTransacao(Transacao transacao);
}
