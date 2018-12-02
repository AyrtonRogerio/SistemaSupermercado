/**
 * 
 */
package br.com.sistemasupermercado.model;

import sun.util.calendar.LocalGregorianCalendar.Date;

/**
 * @author ayrton
 *
 */
public class Parcela {

//	id serial PRIMARY KEY NOT NULL,
//	valor FLOAT,
//	tipo VARCHAR(255),
//	numero INTEGER,
//	data_vencimento DATE,
//	cliente_id INTEGER REFERENCES cliente(id) NOT NULL,
//	funcionario_id INTEGER REFERENCES funcionario(id) NOT NULL,
//	venda_id INTEGER REFERENCES venda

	
	private Integer id;
	private double valor;
	private String tipo;
	private int numero_parcela;
	private Date data_vencimento;
	private Integer cliente_id;
	private Integer funcionario_id;
	private Integer venda_id;
	
	
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getNumero_parcela() {
		return numero_parcela;
	}
	public void setNumero_parcela(int numero_parcela) {
		this.numero_parcela = numero_parcela;
	}
	public Date getData_vencimento() {
		return data_vencimento;
	}
	public void setData_vencimento(Date data_vencimento) {
		this.data_vencimento = data_vencimento;
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
	public Integer getVenda_id() {
		return venda_id;
	}
	public void setVenda_id(Integer venda_id) {
		this.venda_id = venda_id;
	}
	
	
}
