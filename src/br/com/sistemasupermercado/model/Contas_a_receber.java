package br.com.sistemasupermercado.model;

import java.util.Date;

public class Contas_a_receber {

    private Integer id;
    private double valor_total;
    private double valor_pago;
    private double saldo;
    private Date data_pag;
    private Date data_venc;
    private String desc;
    private boolean ativo;
    private Caixa id_caixa;
    private int qtd_pagmt;
    private int qtd_pag;
    private Venda id_venda;
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
	 * @return the valor_total
	 */
	public double getValor_total() {
		return valor_total;
	}
	/**
	 * @param valor_total the valor_total to set
	 */
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	/**
	 * @return the valor_pago
	 */
	public double getValor_pago() {
		return valor_pago;
	}
	/**
	 * @param valor_pago the valor_pago to set
	 */
	public void setValor_pago(double valor_pago) {
		this.valor_pago = valor_pago;
	}
	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	/**
	 * @return the data_pag
	 */
	public Date getData_pag() {
		return data_pag;
	}
	/**
	 * @param data_pag the data_pag to set
	 */
	public void setData_pag(Date data_pag) {
		this.data_pag = data_pag;
	}
	/**
	 * @return the data_venc
	 */
	public Date getData_venc() {
		return data_venc;
	}
	/**
	 * @param data_venc the data_venc to set
	 */
	public void setData_venc(Date data_venc) {
		this.data_venc = data_venc;
	}
	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * @param desc the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * @return the ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}
	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	/**
	 * @return the id_caixa
	 */
	public Caixa getId_caixa() {
		return id_caixa;
	}
	/**
	 * @param id_caixa the id_caixa to set
	 */
	public void setId_caixa(Caixa id_caixa) {
		this.id_caixa = id_caixa;
	}
	/**
	 * @return the qtd_pagmt
	 */
	public int getQtd_pagmt() {
		return qtd_pagmt;
	}
	/**
	 * @param qtd_pagmt the qtd_pagmt to set
	 */
	public void setQtd_pagmt(int qtd_pagmt) {
		this.qtd_pagmt = qtd_pagmt;
	}
	/**
	 * @return the qtd_pag
	 */
	public int getQtd_pag() {
		return qtd_pag;
	}
	/**
	 * @param qtd_pag the qtd_pag to set
	 */
	public void setQtd_pag(int qtd_pag) {
		this.qtd_pag = qtd_pag;
	}
	/**
	 * @return the id_venda
	 */
	public Venda getId_venda() {
		return id_venda;
	}
	/**
	 * @param id_venda the id_venda to set
	 */
	public void setId_venda(Venda id_venda) {
		this.id_venda = id_venda;
	}
    
    
	

}
