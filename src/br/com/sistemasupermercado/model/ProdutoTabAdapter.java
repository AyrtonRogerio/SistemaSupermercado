package br.com.sistemasupermercado.model;

import java.util.Date;

public class ProdutoTabAdapter {

    private String descricao;
    private String marca;
    private int cod_barras;
    private double preco_varejo;
    private int estoque;
    private Date data_cadastro;
    private boolean status;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCod_barras() {
        return cod_barras;
    }

    public void setCod_barras(int cod_barras) {
        this.cod_barras = cod_barras;
    }

    public double getPreco_varejo() {
        return preco_varejo;
    }

    public void setPreco_varejo(double preco_varejo) {
        this.preco_varejo = preco_varejo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
