package br.com.sistemasupermercado.model;

public class EstoqueTabAdapter {

    private int cod_barras;
    private String descricao;
    private int quantidade;
    private double preco_unidade;


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

    public double getPreco_unidade() {
        return preco_unidade;
    }

    public void setPreco_unidade(double preco_unidade) {
        this.preco_unidade = preco_unidade;
    }
}
