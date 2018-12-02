package br.com.sistemasupermercado.model;

import sun.util.calendar.LocalGregorianCalendar.Date;

public class Venda {

	private Integer id;
	private Date data_venda;
	private double desc_geral;
	private int quant_parc;
	private double valor_total;
	private Integer pagamento_id;
	private Integer cliente_id;
	private Integer funcionario_id;
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
	public int getQuant_parc() {
		return quant_parc;
	}
	public void setQuant_parc(int quant_parc) {
		this.quant_parc = quant_parc;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	public Integer getPagamento_id() {
		return pagamento_id;
	}
	public void setPagamento_id(Integer pagamento_id) {
		this.pagamento_id = pagamento_id;
	}
	public Integer getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(Integer cliente_id) {
		this.cliente_id = cliente_id;
	}
	public Integer getFuncionario_id() {
		return funcionario_id;
	}
	public void setFuncionario_id(Integer funcionario_id) {
		this.funcionario_id = funcionario_id;
	}
	
}
