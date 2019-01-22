package br.com.sistemasupermercado.model;

import br.com.sistemasupermercado.enuns.FormaPagamento;

import java.util.Date;
/**
 * 
 * @author ayrton
 *@deprecated
 */
public class Pagamento {

	private Integer id;
	private double valor;
	private Date data_vencimento;
	private int numero;
	private FormaPagamento formaPagamento;
	private Cliente cliente_id;
	private Venda venda_id;
	private boolean status;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData_vencimento() {
		return data_vencimento;
	}

	public void setData_vencimento(Date data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Cliente getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Cliente cliente_id) {
		this.cliente_id = cliente_id;
	}

	public Venda getVenda_id() {
		return venda_id;
	}

	public void setVenda_id(Venda venda_id) {
		this.venda_id = venda_id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
