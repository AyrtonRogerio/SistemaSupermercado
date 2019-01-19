package br.com.sistemasupermercado.model;

import java.util.Date;

public class Contas_a_receber {

    private Integer id;
    private double valor;
    private double valor_quitado;
    private double saldo;
    private Date data_pagamento;
    private Date data_vencimento;
    private String descricao;
    private boolean status;
    private Caixa caixa_id;
    private int qtd_pgmt;
    private int qtd_paga;
    private Venda venda_id;
    
    
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
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	/**
	 * @return the valor_quitado
	 */
	public double getValor_quitado() {
		return valor_quitado;
	}
	/**
	 * @param valor_quitado the valor_quitado to set
	 */
	public void setValor_quitado(double valor_quitado) {
		this.valor_quitado = valor_quitado;
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
	 * @return the data_pagamento
	 */
	public Date getData_pagamento() {
		return data_pagamento;
	}
	/**
	 * @param data_pagamento the data_pagamento to set
	 */
	public void setData_pagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
	}
	/**
	 * @return the data_vencimento
	 */
	public Date getData_vencimento() {
		return data_vencimento;
	}
	/**
	 * @param data_vencimento the data_vencimento to set
	 */
	public void setData_vencimento(Date data_vencimento) {
		this.data_vencimento = data_vencimento;
	}
	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}
	/**
	 * @return the caixa_id
	 */
	public Caixa getCaixa_id() {
		return caixa_id;
	}
	/**
	 * @param caixa_id the caixa_id to set
	 */
	public void setCaixa_id(Caixa caixa_id) {
		this.caixa_id = caixa_id;
	}
	/**
	 * @return the qtd_pgmt
	 */
	public int getQtd_pgmt() {
		return qtd_pgmt;
	}
	/**
	 * @param qtd_pgmt the qtd_pgmt to set
	 */
	public void setQtd_pgmt(int qtd_pgmt) {
		this.qtd_pgmt = qtd_pgmt;
	}
	/**
	 * @return the qtd_paga
	 */
	public int getQtd_paga() {
		return qtd_paga;
	}
	/**
	 * @param qtd_paga the qtd_paga to set
	 */
	public void setQtd_paga(int qtd_paga) {
		this.qtd_paga = qtd_paga;
	}
	/**
	 * @return the venda_id
	 */
	public Venda getVenda_id() {
		return venda_id;
	}
	/**
	 * @param venda_id the venda_id to set
	 */
	public void setVenda_id(Venda venda_id) {
		this.venda_id = venda_id;
	}

}
