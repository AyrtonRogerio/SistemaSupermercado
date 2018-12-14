/**
 * 
 */
package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Venda;

/**
 * @author ayrton
 *
 */
public interface IBusinessVenda {

	public void salvarEditar(Venda venda) throws BusinessException;

	public Venda buscarPorId(int id) throws BusinessException;

	public List<Venda> getAll() throws BusinessException;

	public void ativarDesativar(int id) throws BusinessException;

	public void validar(Venda venda) throws ValidacaoException;
	
}