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

	
	
	/**
	 * @param id
	 * @param data_venda
	 * @param desc_geral
	 * @param valor_troco
	 * @param valor_total
	 * @param valor_recebido
	 * @param cliente_id
	 * @param funcionario_id
	 * @param caixa_id
	 * @param item_vendas
	 */
	public Venda(Integer id, Date data_venda, double desc_geral, double valor_troco, double valor_total,
			double valor_recebido, Cliente cliente_id, Funcionario funcionario_id, Caixa caixa_id,
			List<Item_Venda> item_vendas) {
		super();
		this.id = id;
		this.data_venda = data_venda;
		this.desc_geral = desc_geral;
		this.valor_troco = valor_troco;
		this.valor_total = valor_total;
		this.valor_recebido = valor_recebido;
		this.cliente_id = cliente_id;
		this.funcionario_id = funcionario_id;
		this.caixa_id = caixa_id;
		this.item_vendas = item_vendas;
	}

	/**
	 * 
	 */
	public Venda() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param data_venda
	 * @param funcionario_id
	 * @param caixa_id
	 */
	public Venda(Date data_venda, Funcionario funcionario_id, Caixa caixa_id) {
		super();
		this.data_venda = data_venda;
		this.funcionario_id = funcionario_id;
		this.caixa_id = caixa_id;
	}



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
