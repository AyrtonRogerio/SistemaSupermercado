/**
 * 
 */
package br.com.sistemasupermercado.enuns;

/**
 * @author ayrton
 *
 */
public enum TipoSexo {

	MASCULINO("Masculino"), FEMININO("Feminino");
	private String descricao;
	
	/**
	 * 
	 */
	private TipoSexo(String descricao) {
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
		return getValor();
	}
}
