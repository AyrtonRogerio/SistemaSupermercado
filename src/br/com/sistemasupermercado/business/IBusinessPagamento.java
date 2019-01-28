/**
 * 
 */
package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Pagamento;

/**
 * @author ayrton
 * @deprecated Classe não utilizada no projeto.
 */
public interface IBusinessPagamento {

	/**
	 * @author ayrton
	 * @deprecated Método não utilizado no projeto.
	 */
	public void salvar(Pagamento pagamento, int id_cliente, int id_venda) throws BusinessException;

	/**
	 * @author ayrton
	 * @deprecated Método não utilizado no projeto.
	 */
	public void editar(Pagamento pagamento) throws BusinessException;

	/**
	 * @author ayrton 
	 * @deprecated Método não utilizado no projeto.
	 */
	public Pagamento buscarPorId(int id) throws BusinessException;

	/**
	 * @author ayrton 
	 * @deprecated Método não utilizado no projeto.
	 */
	public List<Pagamento> getAll() throws BusinessException;

	/**
	 * @author ayrton 
	 * @deprecated Método não utilizado no projeto.
	 */
	public void ativarDesativar(int id) throws BusinessException;

	/**
	 * @author ayrton
	 * @deprecated Método não utilizado no projeto.
	 * @param pagamento
	 * @throws ValidacaoException
	 */
	public void validar(Pagamento pagamento) throws ValidacaoException;

}
