package br.com.sistemasupermercado.model;

public class EstoqueTabAdapter {

    private int id;
    private long cod_barras;
    private String descricao;
    private double preco_unidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco_unidade() {
        return preco_unidade;
    }

    public void setPreco_unidade(double preco_unidade) {
        this.preco_unidade = preco_unidade;
    }

	/**
	 * @return the cod_barras
	 */
	public long getCod_barras() {
		return cod_barras;
	}

	/**
	 * @param cod_barras the cod_barras to set
	 */
	public void setCod_barras(long cod_barras) {
		this.cod_barras = cod_barras;
	}
}
