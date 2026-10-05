package br.com.bootcamp.pagamentos;

import br.com.bootcamp.pagamentos.modelo.TipoPagamento;
import br.com.bootcamp.pagamentos.notificacao.NotificadorEmail;
import br.com.bootcamp.pagamentos.notificacao.NotificadorSms;
import br.com.bootcamp.pagamentos.notificacao.RegistroAuditoria;
import br.com.bootcamp.pagamentos.servico.ProcessadorPagamento;

public class Main {

    public static void main(String[] args) {
        ProcessadorPagamento processador = new ProcessadorPagamento();
        processador.adicionarObservador(new NotificadorEmail());
        processador.adicionarObservador(new NotificadorSms());
        processador.adicionarObservador(new RegistroAuditoria());

        processador.processar("Ana", TipoPagamento.PIX, 200.00);
        System.out.println();
        processador.processar("Bruno", TipoPagamento.CARTAO_CREDITO, 500.00);
        System.out.println();
        processador.processar("Carla", TipoPagamento.BOLETO, 120.00);
    }
}
