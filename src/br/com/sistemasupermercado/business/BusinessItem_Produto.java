/**
 * 
 */
package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.dao.DaoItem_Produto;
import br.com.sistemasupermercado.dao.IDaoItem_Produto;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Item_Produto;

/**
 * @author ayrton
 *
 */
public class BusinessItem_Produto implements IBusinessItem_Produto {

	private IDaoItem_Produto daoItemProduto;

	public BusinessItem_Produto() {
		daoItemProduto = new DaoItem_Produto();
	}

	@Override
	public void salvarEditar(Item_Produto item_Produto) throws BusinessException {
		
		try {
			validar(item_Produto);
			if (item_Produto.getId() == null)
				daoItemProduto.salvar(item_Produto);
			else
				daoItemProduto.editar(item_Produto);
		} catch (DaoException | ValidacaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Item_Produto buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoItemProduto.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Item_Produto> getAll() throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoItemProduto.getAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void ativarDesativar(int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			daoItemProduto.ativarDesativar(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void validar(Item_Produto item_Produto) throws ValidacaoException {
		// TODO Auto-generated method stub
		if(item_Produto.getCod_barras() == 0)
			throw new ValidacaoException("Informe um nome!!!");
	}

}
