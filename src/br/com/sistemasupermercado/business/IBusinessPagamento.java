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
 *
 */
public interface IBusinessPagamento {
	
	public void salvarEditar(Pagamento pagamento, int cliente_id) throws BusinessException;

	public Pagamento buscarPorId(int id) throws BusinessException;

	public List<Pagamento> getAll() throws BusinessException;

	public void ativarDesativar(int id) throws BusinessException;

	public void validar(Pagamento pagamento) throws ValidacaoException;
	
}
