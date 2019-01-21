/**
 * 
 */
package br.com.sistemasupermercado.model;

import java.util.Date;

/**
 * @author ayrton
 *
 */
public class RelatorioFinanceiro {

	private Contas_a_receber contas_a_receber;
	private Contas_a_pagar contas_a_pagar;
	private static Date inicio, fim;
	/**
	 * @return the contas_a_receber
	 */
	public Contas_a_receber getContas_a_receber() {
		return contas_a_receber;
	}
	/**
	 * @param contas_a_receber the contas_a_receber to set
	 */
	public void setContas_a_receber(Contas_a_receber contas_a_receber) {
		this.contas_a_receber = contas_a_receber;
	}
	/**
	 * @return the contas_a_pagar
	 */
	public Contas_a_pagar getContas_a_pagar() {
		return contas_a_pagar;
	}
	/**
	 * @param contas_a_pagar the contas_a_pagar to set
	 */
	public void setContas_a_pagar(Contas_a_pagar contas_a_pagar) {
		this.contas_a_pagar = contas_a_pagar;
	}
	/**
	 * @return the inicio
	 */
	public static Date getInicio() {
		return inicio;
	}
	/**
	 * @param inicio the inicio to set
	 */
	public static void setInicio(Date inicio) {
		RelatorioFinanceiro.inicio = inicio;
	}
	/**
	 * @return the fim
	 */
	public static Date getFim() {
		return fim;
	}
	/**
	 * @param fim the fim to set
	 */
	public static void setFim(Date fim) {
		RelatorioFinanceiro.fim = fim;
	}
	
	
    
    
}
