/**
 * 
 */
package br.com.sistemasupermercado.model;

import java.util.Date;

/**
 * @author ayrton
 *
 */
public class Contas_a_Pagar_Adapter {

	private Integer id;
    private double valor;
    private double valor_quitado;
    private Date data_vencimento;
    private int qtd_pgmt;
    private int qtd_paga;
    private String descricao;
    
    
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
    
	
}
