package br.com.sistemasupermercado.model;

public class EstoqueTabAdapter {

    private int cod_barras;
    private String descricao;
    private int quantidade;
    private double preco_inidade;


    public int getCod_barras() {
        return cod_barras;
    }

    public void setCod_barras(int cod_barras) {
        this.cod_barras = cod_barras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco_inidade() {
        return preco_inidade;
    }

    public void setPreco_inidade(double preco_inidade) {
        this.preco_inidade = preco_inidade;
    }
}
