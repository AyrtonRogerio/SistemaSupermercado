package br.com.sistemasupermercado.model;

import br.com.sistemasupermercado.enuns.FormaPagamento;

public class Pagamento {

	private Integer id;
	private Float valor;
	private Float troco;
	private Float desconto;
	private FormaPagamento formaPagamento;
	
	
	public Float getTroco() {
		return troco;
	}
	public void setTroco(Float troco) {
		this.troco = troco;
	}
	public Float getDesconto() {
		return desconto;
	}
	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
}
