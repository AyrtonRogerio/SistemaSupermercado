package br.com.sistemasupermercado.model;

public class VendaTabAdapter {

    private int item;
    private int venda_cod_barras;
    private String venda_descricao;
    private int venda_quantidade;
    private double venda_preco_unidade;

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getVenda_cod_barras() {
        return venda_cod_barras;
    }

    public void setVenda_cod_barras(int venda_cod_barras) {
        this.venda_cod_barras = venda_cod_barras;
    }

    public String getVenda_descricao() {
        return venda_descricao;
    }

    public void setVenda_descricao(String venda_descricao) {
        this.venda_descricao = venda_descricao;
    }

    public int getVenda_quantidade() {
        return venda_quantidade;
    }

    public void setVenda_quantidade(int venda_quantidade) {
        this.venda_quantidade = venda_quantidade;
    }

    public double getVenda_preco_unidade() {
        return venda_preco_unidade;
    }

    public void setVenda_preco_unidade(double venda_preco_unidade) {
        this.venda_preco_unidade = venda_preco_unidade;
    }
}
