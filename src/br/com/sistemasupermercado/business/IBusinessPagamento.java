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
	
	public void salvar(Pagamento pagamento, int id_cliente, int id_venda) throws BusinessException;

	public void editar(Pagamento pagamento) throws BusinessException;

	public Pagamento buscarPorId(int id) throws BusinessException;

	public List<Pagamento> getAll() throws BusinessException;

	public void ativarDesativar(int id) throws BusinessException;

	public void validar(Pagamento pagamento) throws ValidacaoException;
	
}
