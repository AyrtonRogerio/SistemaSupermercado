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

	public int salvar(Venda venda, int id_cliente, int id_funcionario, int id_caixa) throws DaoException;
	
	public int salvar(Venda venda, int id_funcionario, int id_caixa) throws DaoException;

	public Venda buscarPorId(int id) throws DaoException;

	public List<Venda> getAll() throws DaoException;

	public void editar(Venda venda) throws DaoException;

	public void ativarDesativar(int id) throws DaoException;
	
}
