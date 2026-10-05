package br.com.bootcamp.pagamentos.notificacao;

import br.com.bootcamp.pagamentos.modelo.Transacao;

public class NotificadorEmail implements ObservadorTransacao {

    @Override
    public void aoRealizarTransacao(Transacao transacao) {
        System.out.printf("[E-MAIL] %s, seu pagamento via %s de R$ %.2f foi aprovado.%n",
                transacao.getCliente(), transacao.getTipoPagamento(), transacao.getValorTotal());
    }
}
