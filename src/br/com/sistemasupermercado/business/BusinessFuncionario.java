package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.dao.DaoFuncionario;
import br.com.sistemasupermercado.dao.IDaoFuncionario;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Funcionario;

public class BusinessFuncionario implements IBusinessFuncionario {

	private IDaoFuncionario daoFuncionario;

	public BusinessFuncionario() {

		daoFuncionario = new DaoFuncionario();
	}

	@Override
	public void salvarEditar(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			validar(funcionario);
			if (funcionario.getId() == null)
				daoFuncionario.salvar(funcionario);
			else
				daoFuncionario.editar(funcionario);
		} catch (DaoException | ValidacaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Funcionario buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoFuncionario.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Funcionario> getAll() throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoFuncionario.getAll();
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
			daoFuncionario.ativarDesativar(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void validar(Funcionario funcionario) throws ValidacaoException {
		// TODO Auto-generated method stub
		try {

			for (Funcionario f : daoFuncionario.getAll()) {

				if (funcionario.getNome() == null)
					throw new ValidacaoException("Informe um nome!!!");
				if (funcionario.getCpf().equals(f.getCpf()))
					throw new ValidacaoException("O CPF já está cadastrado!!!");
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
