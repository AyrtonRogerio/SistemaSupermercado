package br.com.sistemasupermercado.model;

public class Caixa {

	private Integer id;
	private Double entrada;
	private Double saida;
	private Double saldo;
	private Funcionario funcionario_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getEntrada() {
		return entrada;
	}

	public void setEntrada(Double entrada) {
		this.entrada = entrada;
	}

	public Double getSaida() {
		return saida;
	}

	public void setSaida(Double saida) {
		this.saida = saida;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Funcionario getFuncionario_id() {
		return funcionario_id;
	}

	public void setFuncionario_id(Funcionario funcionario_id) {
		this.funcionario_id = funcionario_id;
	}
}
