/**
 * 
 */
package br.com.sistemasupermercado.model;

import java.util.Date;

/**
 * @author ayrton
 *
 */
public class Item_Produto {

//	id serial PRIMARY KEY NOT NULL,
//	perecivel BOOLEAN,
//	porc_varej FLOAT,
//	promocao BOOLEAN,
//	quantidade INTEGER,
//	porc_atacad FLOAT,
//	cod_barras VARCHAR(255),
//	unidade_medida FLOAT,
//	data_validade DATE,
//	data_compra DATE, 
//	fornecedor_id INTEGER REFERENCES fornecedor(id) NOT NULL,
//	produto _id INTEGER REFERENCES produto(id) NOT NULL
//	);

	private Integer id;
	private boolean perecivel;
	private int quantidade;
	private int cod_barras;
	private double unid_medida;
	private Date data_validade;
	private Date data_fabricacao;
	private Date data_compra;
	private double preco_unidade;
	private Integer fornecedor_id;
	private Integer produto_id;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public int getCod_barras() {
		return cod_barras;
	}
	public void setCod_barras(int cod_barras) {
		this.cod_barras = cod_barras;
	}
	public double getUnid_medida() {
		return unid_medida;
	}
	public void setUnid_medida(double unid_medida) {
		this.unid_medida = unid_medida;
	}
	public Date getData_validade() {
		return data_validade;
	}
	public void setData_validade(Date data_validade) {
		this.data_validade = data_validade;
	}
	public Date getData_fabricacao() {
		return data_fabricacao;
	}
	public void setData_fabricacao(Date data_fabricacao) {
		this.data_fabricacao = data_fabricacao;
	}
	public Date getData_compra() {
		return data_compra;
	}
	public void setData_compra(Date data_compra) {
		this.data_compra = data_compra;
	}
	public Integer getFornecedor_id() {
		return fornecedor_id;
	}
	public void setFornecedor_id(Integer fornecedor_id) {
		this.fornecedor_id = fornecedor_id;
	}
	public Integer getProduto_id() {
		return produto_id;
	}
	public void setProduto_id(Integer produto_id) {
		this.produto_id = produto_id;
	}
	public boolean isPerecivel() {
		return perecivel;
	}
	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}
	public double getPreco_unidade() {
		return preco_unidade;
	}
	public void setPreco_unidade(double preco_unidade) {
		this.preco_unidade = preco_unidade;
	}
	
}
