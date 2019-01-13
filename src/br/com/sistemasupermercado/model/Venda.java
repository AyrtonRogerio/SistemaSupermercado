package br.com.sistemasupermercado.model;

import java.util.Date;
import java.util.List;

public class Venda {

	private Integer id;
	private Date data_venda;
	private double desc_geral;
	private double valor_troco;
	private double valor_total;
	private double valor_recebido;

	private Cliente cliente_id;
	private Funcionario funcionario_id;
	private Caixa caixa_id;
	private List<Item_Venda> item_vendas;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_venda() {
		return data_venda;
	}

	public void setData_venda(Date data_venda) {
		this.data_venda = data_venda;
	}

	public double getDesc_geral() {
		return desc_geral;
	}

	public void setDesc_geral(double desc_geral) {
		this.desc_geral = desc_geral;
	}

	public double getValor_troco() {
		return valor_troco;
	}

	public void setValor_troco(double valor_troco) {
		this.valor_troco = valor_troco;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

	public double getValor_recebido() {
		return valor_recebido;
	}

	public void setValor_recebido(double valor_recebido) {
		this.valor_recebido = valor_recebido;
	}

	public Cliente getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(Cliente cliente_id) {
		this.cliente_id = cliente_id;
	}

	public Funcionario getFuncionario_id() {
		return funcionario_id;
	}

	public void setFuncionario_id(Funcionario funcionario_id) {
		this.funcionario_id = funcionario_id;
	}

	public Caixa getCaixa_id() {
		return caixa_id;
	}

	public void setCaixa_id(Caixa caixa_id) {
		this.caixa_id = caixa_id;
	}

	public List<Item_Venda> getItem_vendas() {
		return item_vendas;
	}

	public void setItem_vendas(List<Item_Venda> item_vendas) {
		this.item_vendas = item_vendas;
	}
}
