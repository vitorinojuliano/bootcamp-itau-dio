package br.com.bootcamp.pagamentos.notificacao;

import br.com.bootcamp.pagamentos.modelo.Transacao;

public class NotificadorSms implements ObservadorTransacao {

    @Override
    public void aoRealizarTransacao(Transacao transacao) {
        System.out.printf("[SMS] Compra de R$ %.2f realizada.%n", transacao.getValorTotal());
    }
}
