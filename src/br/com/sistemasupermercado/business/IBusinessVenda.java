/**
 * 
 */
package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Venda;

/**
 * @author ayrton
 *
 */
public interface IBusinessVenda {

	public int salvar(Venda venda, int id_cliente, int id_funcionario, int id_caixa) throws BusinessException;

	public int salvar(Venda venda, int id_funcionario, int id_caixa) throws BusinessException;
	
	public void editar(Venda venda) throws BusinessException;

	public Venda buscarPorId(int id) throws BusinessException;

	public List<Venda> getAll() throws BusinessException;

	public void ativarDesativar(int id) throws BusinessException;

	public void validar(Venda venda) throws ValidacaoException;
	
}
