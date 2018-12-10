/**
 * 
 */
package br.com.sistemasupermercado.enuns;

/**
 * @author ayrton
 *
 */
public enum TipoEstadoCivil {

	SOLTEIRO("Solteiro"), CASADO("Casado"), DIVORCIADO("Divorciado"),
	VIUVO("Viúvo");
	
	private String descricao;
	
	/**
	 * 
	 */
	private TipoEstadoCivil(String descricao) {
	
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
