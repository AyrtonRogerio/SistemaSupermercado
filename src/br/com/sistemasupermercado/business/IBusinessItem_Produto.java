/**
 * 
 */
package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.*;


/**
 * @author ayrton
 *
 */
public interface IBusinessItem_Produto {

	public void salvarEditar(Item_Produto item_Produto, int id_fornecedor) throws BusinessException;

	public Item_Produto buscarPorId(int id) throws BusinessException;

	public List<Item_Produto> getAll() throws BusinessException;

	public List<ProdutoTabAdapter> getAllAdapter() throws BusinessException;

	public List<EstoqueTabAdapter> getAllEstoqueAdapter() throws BusinessException;

	public void ativarDesativar(int id) throws BusinessException;

	public void validar(Item_Produto item_Produto) throws ValidacaoException;
	
}
