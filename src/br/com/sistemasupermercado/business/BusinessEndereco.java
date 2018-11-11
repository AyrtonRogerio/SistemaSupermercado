package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.dao.DaoEndereco;
import br.com.sistemasupermercado.dao.IDaoEndereco;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Endereco;

public class BusinessEndereco implements IBusinessEndereco {

	private IDaoEndereco daoEndereco;
	
	public BusinessEndereco() {
	
		daoEndereco = new DaoEndereco();
	}
	
	@Override
	public void salvarEditar(Endereco endereco) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			validar(endereco);
			if (endereco.getId() == null)
				daoEndereco.salvar(endereco);
			else
				daoEndereco.editar(endereco);
		} catch (DaoException | ValidacaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Endereco buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoEndereco.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Endereco> getAll() throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoEndereco.getAll();
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
			daoEndereco.ativarDesativar(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void validar(Endereco endereco) throws ValidacaoException {
		// TODO Auto-generated method stub
		if(endereco.getCep() == null)
			throw new ValidacaoException("Informe um nome!!!");
	}

}
