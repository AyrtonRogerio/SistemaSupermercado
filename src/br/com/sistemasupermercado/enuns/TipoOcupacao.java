/**
 * 
 */
package br.com.sistemasupermercado.enuns;

/**
 * @author ayrton
 *
 */
public enum TipoOcupacao {

	EMPREGADO ("Empregado"), DESEMPREGADO ("Desempregado"), 
	ESTUDANTE ("Estudante"), APOSENTADO ("Aposentado");
	
	private String descricao;
	
	/**
	 * 
	 */
	private TipoOcupacao(String descricao) {
	
		this.descricao = descricao;
	}
	
	public String getValor() {
		return this.descricao;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getValor();
	}
	
}
