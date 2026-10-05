package br.com.bootcamp.pagamentos.taxa;

import br.com.bootcamp.pagamentos.modelo.TipoPagamento;

public class CalculadoraTaxaFactory {

    public static CalculadoraTaxa criar(TipoPagamento tipoPagamento) {
        switch (tipoPagamento) {
            case PIX:
                return new TaxaPix();
            case CARTAO_CREDITO:
                return new TaxaCartaoCredito();
            case BOLETO:
                return new TaxaBoleto();
            default:
                throw new IllegalArgumentException("Tipo de pagamento não suportado: " + tipoPagamento);
        }
    }
}
