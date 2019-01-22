package br.com.sistemasupermercado.model;

public class VendaTabAdapter {

    private int item;
    private long venda_cod_barras;
    private String venda_descricao;
    private int venda_quantidade;
    private double venda_preco_varejo;

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
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

    public double getVenda_preco_varejo() {
        return venda_preco_varejo;
    }

    public void setVenda_preco_varejo(double venda_preco_varejo) {
        this.venda_preco_varejo = venda_preco_varejo;
    }

	/**
	 * @return the venda_cod_barras
	 */
	public long getVenda_cod_barras() {
		return venda_cod_barras;
	}

	/**
	 * @param venda_cod_barras the venda_cod_barras to set
	 */
	public void setVenda_cod_barras(long venda_cod_barras) {
		this.venda_cod_barras = venda_cod_barras;
	}
}
