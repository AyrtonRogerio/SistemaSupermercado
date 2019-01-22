/**
 * 
 */
package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.dao.DaoItem_Venda;
import br.com.sistemasupermercado.dao.IDaoItem_Venda;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Item_Venda;

public class BusinessItem_Venda implements IBusinessItem_Venda{

	private IDaoItem_Venda daoItemVenda;
	

	public BusinessItem_Venda() {
	
		daoItemVenda = new DaoItem_Venda();
	}
	
	@Override
	public void salvar(Item_Venda item_Venda, int venda_id, int item_produto_id) throws BusinessException {
		try {
			validar(item_Venda);
			if (item_Venda.getId() == null)
				daoItemVenda.salvar(item_Venda,venda_id,item_produto_id);


		} catch (DaoException | ValidacaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void editar(Item_Venda item_venda) throws BusinessException {
		try {
			daoItemVenda.editar(item_venda);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Item_Venda buscarPorId(int id) throws BusinessException {
		try {
			return daoItemVenda.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	public List<Item_Venda> getAll() throws BusinessException {
		try {
			return daoItemVenda.getAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void ativarDesativar(int id) throws BusinessException {
		try {
			daoItemVenda.ativarDesativar(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void validar(Item_Venda item_Venda) throws ValidacaoException {
		
		if(item_Venda.getTipo() == null) {
			throw new ValidacaoException("Não pode ser nulo!");
		}
		
		if(item_Venda.getItem_produto_id() == null) {
			throw new ValidacaoException("Informe um produto!!!");
		}
		
		if(item_Venda.getVenda_id() == null) {
			throw new ValidacaoException("!!!");
		}
		
		if(item_Venda.getTipo() == null) {
			throw new ValidacaoException("Informe um nome!!!");
		}
		
	}

}
