package br.com.bootcamp.pagamentos.servico;

import br.com.bootcamp.pagamentos.modelo.TipoPagamento;
import br.com.bootcamp.pagamentos.modelo.Transacao;
import br.com.bootcamp.pagamentos.notificacao.ObservadorTransacao;
import br.com.bootcamp.pagamentos.taxa.CalculadoraTaxa;
import br.com.bootcamp.pagamentos.taxa.CalculadoraTaxaFactory;

import java.util.ArrayList;
import java.util.List;

public class ProcessadorPagamento {

    private final List<ObservadorTransacao> observadores = new ArrayList<>();

    public void adicionarObservador(ObservadorTransacao observador) {
        observadores.add(observador);
    }

    public Transacao processar(String cliente, TipoPagamento tipoPagamento, double valor) {
        validarValor(valor);
        CalculadoraTaxa calculadoraTaxa = CalculadoraTaxaFactory.criar(tipoPagamento);
        double taxa = calculadoraTaxa.calcular(valor);
        Transacao transacao = new Transacao(cliente, tipoPagamento, valor, taxa);
        notificarObservadores(transacao);
        return transacao;
    }

    private void validarValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor do pagamento deve ser maior que zero.");
        }
    }

    private void notificarObservadores(Transacao transacao) {
        for (ObservadorTransacao observador : observadores) {
            observador.aoRealizarTransacao(transacao);
        }
    }
}
