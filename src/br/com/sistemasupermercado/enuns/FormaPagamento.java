package br.com.sistemasupermercado.enuns;


public enum FormaPagamento {

	DINHEIRO("dinheiro"), CARTAO_CREDITO("cartaocredito"), CARTAO_DEBITO("cartaodebito"), CHEQUE("cheque");

	private String descricao;

	private FormaPagamento(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return this.descricao;
	}

	public static FormaPagamento getFormaPagamento(String pagamento) {

		for (FormaPagamento f : values()) {
			if (f.getValor().equalsIgnoreCase(pagamento)) {
				return f;
			}
		}
		return null;
	}
}
