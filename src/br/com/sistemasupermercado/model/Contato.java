package br.com.sistemasupermercado.model;

import java.util.ArrayList;
import java.util.List;

import br.com.sistemasupermercado.enuns.TipoContato;

public class Contato {

	/**@author ayrton
	 * 
	 * 
	 */
	private Integer id;
	private TipoContato tipo;
	private Cliente cliente;
	private String descricao;



	public Integer getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoContato getTipo() {
		return tipo;
	}

	public void setTipo(TipoContato tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
