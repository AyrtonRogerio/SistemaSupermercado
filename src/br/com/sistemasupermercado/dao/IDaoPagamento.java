/**
 * 
 */
package br.com.sistemasupermercado.dao;

import java.util.List;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Pagamento;

/**
 * @author ayrton
 * @version 1.0
 * 
 */
public interface IDaoPagamento {

	public void salvar(Pagamento pagamento, int cliente_id) throws DaoException;

	public Pagamento buscarPorId(int id) throws DaoException;

	public List<Pagamento> getAll() throws DaoException;

	public void editar(Pagamento pagamento) throws DaoException;

	public void ativarDesativar(int id) throws DaoException;
}
