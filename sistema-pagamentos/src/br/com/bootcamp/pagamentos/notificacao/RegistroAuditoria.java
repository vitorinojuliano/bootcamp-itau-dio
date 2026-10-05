package br.com.bootcamp.pagamentos.notificacao;

import br.com.bootcamp.pagamentos.modelo.Transacao;

public class RegistroAuditoria implements ObservadorTransacao {

    @Override
    public void aoRealizarTransacao(Transacao transacao) {
        System.out.printf("[AUDITORIA] cliente=%s tipo=%s valor=%.2f taxa=%.2f%n",
                transacao.getCliente(), transacao.getTipoPagamento(),
                transacao.getValor(), transacao.getTaxa());
    }
}
