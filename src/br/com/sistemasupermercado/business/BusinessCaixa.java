package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.dao.DaoCaixa;
import br.com.sistemasupermercado.dao.IDaoCaixa;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Caixa;

public class BusinessCaixa implements IBusinessCaixa {

	private IDaoCaixa daoCaixa;
	
	public BusinessCaixa() {
	
		daoCaixa = new DaoCaixa();
	}

	@Override
	public void salvarEditar(Caixa caixa) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			validar(caixa);
			if (caixa.getId() == null)
				daoCaixa.salvar(caixa);
			else
				daoCaixa.editar(caixa);
		} catch (DaoException | ValidacaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Caixa buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoCaixa.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Caixa> getAll() throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoCaixa.getAll();
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
			daoCaixa.ativarDesativar(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void validar(Caixa caixa) throws ValidacaoException {
		// TODO Auto-generated method stub
		if(caixa.getSaida() == null)
			throw new ValidacaoException("Informe um nome!!!");
	}

}