package br.com.sistemasupermercado.model;

import java.util.Date;

public class ProdutoTabAdapter {

	private Integer id;
	private Integer produto_id;
	private Integer fornecedor_id;
    private String descricao;
    private String marca;
    private long cod_barras;
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

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the produto_id
	 */
	public Integer getProduto_id() {
		return produto_id;
	}

	/**
	 * @param produto_id the produto_id to set
	 */
	public void setProduto_id(Integer produto_id) {
		this.produto_id = produto_id;
	}

	/**
	 * @return the fornecedor_id
	 */
	public Integer getFornecedor_id() {
		return fornecedor_id;
	}

	/**
	 * @param fornecedor_id the fornecedor_id to set
	 */
	public void setFornecedor_id(Integer fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
	}


}
