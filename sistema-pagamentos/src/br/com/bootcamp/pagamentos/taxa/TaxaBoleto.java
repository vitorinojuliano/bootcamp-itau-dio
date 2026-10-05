package br.com.bootcamp.pagamentos.taxa;

public class TaxaBoleto implements CalculadoraTaxa {

    private static final double VALOR_FIXO = 3.50;

    @Override
    public double calcular(double valor) {
        return VALOR_FIXO;
    }
}
