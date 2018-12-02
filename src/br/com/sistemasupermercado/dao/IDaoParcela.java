/**
 * 
 */
package br.com.sistemasupermercado.dao;

import java.util.List;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Item_Produto;
import br.com.sistemasupermercado.model.Parcela;

/**
 * @author ayrton
 *
 */
public interface IDaoParcela {

	public void salvar(Parcela parcela) throws DaoException;

	public Parcela buscarPorId(int id) throws DaoException;

	public List<Parcela> getAll() throws DaoException;

	public void editar(Parcela parcela) throws DaoException;

	public void ativarDesativar(int id) throws DaoException;
	
}
