package br.com.bootcamp.pagamentos.taxa;

public class TaxaCartaoCredito implements CalculadoraTaxa {

    private static final double PERCENTUAL = 0.03;

    @Override
    public double calcular(double valor) {
        return valor * PERCENTUAL;
    }
}
