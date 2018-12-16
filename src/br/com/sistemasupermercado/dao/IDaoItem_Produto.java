/**
 * 
 */
package br.com.sistemasupermercado.dao;

import java.util.List;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Fornecedor;
import br.com.sistemasupermercado.model.Item_Produto;
import br.com.sistemasupermercado.model.Produto;

/**
 * @author ayrton
 *
 */
public interface IDaoItem_Produto {

	public void salvar(Item_Produto item_Produto, int id_fornecedor) throws DaoException;

	public Item_Produto buscarPorId(int id) throws DaoException;

	public List<Item_Produto> getAll() throws DaoException;

	public void editar(Item_Produto item_Produto) throws DaoException;

	public void ativarDesativar(int id) throws DaoException;
	
}
