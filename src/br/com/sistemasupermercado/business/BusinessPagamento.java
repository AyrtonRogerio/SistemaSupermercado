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
 * @deprecated
 */
public class BusinessPagamento implements IBusinessPagamento {

	private IDaoPagamento daoPagamento;

	/**
	 * @author ayrton
	 * @deprecated
	 */
	public BusinessPagamento() {
		daoPagamento = new DaoPagamento();
	}

	/**
	 * @author ayrton
	 * @deprecated - Método não utilizado no projeto.
	 */
	@Override
	public void salvar(Pagamento pagamento, int id_cliente, int id_venda) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			validar(pagamento);
			if (pagamento.getId() == null)
				daoPagamento.salvar(pagamento, id_cliente, id_venda);

		} catch (DaoException | ValidacaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	/**
	 * @author ayrton
	 * @deprecated - Método não utilizado no projeto.
	 */
	@Override
	public void editar(Pagamento pagamento) throws BusinessException {
		try {
			daoPagamento.editar(pagamento);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	/**
	 * @author ayrton
	 * @deprecated - Método não utilizado no projeto.
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

	/**
	 * @author ayrton
	 * @deprecated - Método não utilizado no projeto.
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

	/**
	 * @author ayrton
	 * @deprecated - Método não utilizado no projeto.
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

	/**
	 * @author ayrton
	 * @deprecated - Método não utilizado no projeto.
	 */
	@Override
	public void validar(Pagamento pagamento) throws ValidacaoException {
		// TODO Auto-generated method stub
		if (pagamento.getValor() == 0)
			throw new ValidacaoException("Sem valor no pagamento!!!");
	}

}
