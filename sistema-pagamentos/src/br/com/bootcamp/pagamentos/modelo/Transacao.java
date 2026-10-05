package br.com.bootcamp.pagamentos.modelo;

public class Transacao {

    private final String cliente;
    private final TipoPagamento tipoPagamento;
    private final double valor;
    private final double taxa;

    public Transacao(String cliente, TipoPagamento tipoPagamento, double valor, double taxa) {
        this.cliente = cliente;
        this.tipoPagamento = tipoPagamento;
        this.valor = valor;
        this.taxa = taxa;
    }

    public String getCliente() {
        return cliente;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public double getValor() {
        return valor;
    }

    public double getTaxa() {
        return taxa;
    }

    public double getValorTotal() {
        return valor + taxa;
    }
}
