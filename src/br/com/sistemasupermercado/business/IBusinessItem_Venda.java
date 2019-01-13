/**
 * 
 */
package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Item_Venda;

/**
 * @author ayrton
 *
 */
public interface IBusinessItem_Venda {

	public void salvar(Item_Venda item_Venda, int venda_id, int item_produto_id) throws BusinessException;

	public void editar(Item_Venda item_venda) throws BusinessException;

	public Item_Venda buscarPorId(int id) throws BusinessException;

	public List<Item_Venda> getAll() throws BusinessException;

	public void ativarDesativar(int id) throws BusinessException;

	public void validar(Item_Venda item_Venda) throws ValidacaoException;
	
}
