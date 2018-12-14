/**
 * 
 */
package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.dao.DaoVenda;
import br.com.sistemasupermercado.dao.IDaoVenda;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Venda;

/**
 * @author ayrton
 *
 */
public class BusinessVenda implements IBusinessVenda {

	private IDaoVenda daoVenda;
	
	public BusinessVenda() {	
		daoVenda = new DaoVenda();		
	}
	
	
	@Override
	public void salvarEditar(Venda venda) throws BusinessException {
		// TODO Auto-generated method stub
		
		try {
			validar(venda);
			if (venda.getId() == null)
				daoVenda.salvar(venda);
			else
				daoVenda.editar(venda);
		} catch (DaoException | ValidacaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		
	}

	
	@Override
	public Venda buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoVenda.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	
	@Override
	public List<Venda> getAll() throws BusinessException {
		try {
			return daoVenda.getAll();
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
			daoVenda.ativarDesativar(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	
	@Override
	public void validar(Venda venda) throws ValidacaoException {
		// TODO Auto-generated method stub
		if(venda.getDesc_geral() <= 0)
			throw new ValidacaoException("BUsines venda!!!");
	}

}