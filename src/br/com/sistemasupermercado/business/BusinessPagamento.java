/**
 * 
 */
package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.dao.DaoPagamento;
import br.com.sistemasupermercado.dao.IDaoPagamento;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Pagamento;

/**
 * @author ayrton
 *
 */
public class BusinessPagamento implements IBusinessPagamento{

	private IDaoPagamento daoPagamento;
	
	/**
	 * 
	 */
	public BusinessPagamento() {
		daoPagamento = new DaoPagamento();
	}
	
	
	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.business.IBusinessPagamento#salvarEditar(br.com.sistemasupermercado.model.Pagamento)
	 */
	@Override
	public void salvarEditar(Pagamento pagamento, int id_cliente, int id_venda) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			validar(pagamento);
			if (pagamento.getId() == null)
				daoPagamento.salvar(pagamento, id_cliente,id_venda);
			else
				daoPagamento.editar(pagamento);
		} catch (DaoException | ValidacaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.business.IBusinessPagamento#buscarPorId(int)
	 */
	@Override
	public Pagamento buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoPagamento.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.business.IBusinessPagamento#getAll()
	 */
	@Override
	public List<Pagamento> getAll() throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoPagamento.getAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.business.IBusinessPagamento#ativarDesativar(int)
	 */
	@Override
	public void ativarDesativar(int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			daoPagamento.ativarDesativar(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.business.IBusinessPagamento#validar(br.com.sistemasupermercado.model.Pagamento)
	 */
	@Override
	public void validar(Pagamento pagamento) throws ValidacaoException {
		// TODO Auto-generated method stub
		if(pagamento.getValor() == 0)
			throw new ValidacaoException("Sem valor no pagamento!!!");
	}

}
