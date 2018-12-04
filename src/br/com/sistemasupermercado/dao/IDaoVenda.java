/**
 * 
 */
package br.com.sistemasupermercado.dao;

import java.util.List;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Venda;


/**
 * @author ayrton
 *
 */
public interface IDaoVenda {

	public void salvar(Venda venda) throws DaoException;

	public Venda buscarPorId(int id) throws DaoException;

	public List<Venda> getAll() throws DaoException;

	public void editar(Venda venda) throws DaoException;

	public void ativarDesativar(int id) throws DaoException;
	
}
