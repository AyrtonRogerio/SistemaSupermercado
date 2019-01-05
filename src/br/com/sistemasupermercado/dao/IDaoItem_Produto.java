/**
 * 
 */
package br.com.sistemasupermercado.dao;

import java.util.List;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.*;

/**
 * @author ayrton
 *
 */
public interface IDaoItem_Produto {

	public void salvar(Item_Produto item_Produto, int id_fornecedor) throws DaoException;

	public Item_Produto buscarPorId(int id) throws DaoException;

	public List<Item_Produto> getAll() throws DaoException;

	public List<ProdutoTabAdapter> getAllAdapter() throws DaoException;

	public List<EstoqueTabAdapter> getAllEstoqueAdapter() throws DaoException;

	public void editar(Item_Produto item_Produto) throws DaoException;

	public void ativarDesativar(int id) throws DaoException;
	
}
