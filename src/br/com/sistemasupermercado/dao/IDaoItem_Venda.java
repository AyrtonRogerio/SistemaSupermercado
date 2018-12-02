/**
 * 
 */
package br.com.sistemasupermercado.dao;

import java.util.List;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Item_Venda;

/**
 * @author ayrton
 *
 */
public interface IDaoItem_Venda {

	public void salvar(Item_Venda item_Venda) throws DaoException;

	public Item_Venda buscarPorId(int id) throws DaoException;

	public List<Item_Venda> getAll() throws DaoException;

	public void editar(Item_Venda item_Venda) throws DaoException;

	public void ativarDesativar(int id) throws DaoException;
	
}
