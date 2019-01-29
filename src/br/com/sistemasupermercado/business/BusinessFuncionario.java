package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.dao.DaoFuncionario;
import br.com.sistemasupermercado.dao.IDaoFuncionario;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Endereco;
import br.com.sistemasupermercado.model.Funcionario;
import br.com.sistemasupermercado.model.FuncionarioAdapter;
import br.com.sistemasupermercado.view.Mensagem;
import javafx.scene.control.Alert.AlertType;

public class BusinessFuncionario implements IBusinessFuncionario {

	private IDaoFuncionario daoFuncionario;

	public BusinessFuncionario() {

		daoFuncionario = new DaoFuncionario();
	}

	@Override
	public void salvar(Funcionario funcionario, int end) throws BusinessException, ValidacaoException {
		// TODO Auto-generated method stub
		try {
			validar(funcionario);
			if (funcionario.getId() == null)
				daoFuncionario.salvar(funcionario, end);


		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		} catch (ValidacaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ValidacaoException(e.getMessage());
		}
	}

	@Override
	public void editar(Funcionario funcionario) throws BusinessException {
		try {
			daoFuncionario.editar(funcionario);
		} catch (DaoException e) {
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
	public List<FuncionarioAdapter> burcarPorBuscaFuncionario(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoFuncionario.buscarPorBusca(busca);
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
	public List<FuncionarioAdapter> getAllAdapter() throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoFuncionario.getAllAdapter();
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
	public Funcionario buscarPorLogin(String login, String senha) throws BusinessException {
		// TODO Auto-generated method stub
		
		try {

			//validar(login,senha);
			return daoFuncionario.buscarLogin(login,senha);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
		
	}

	@Override
	public void validar(Funcionario funcionario) throws ValidacaoException {
		// TODO Auto-generated method stub

		if (funcionario.getCargo() == null) {
			throw new ValidacaoException("O cargo do funcionário não pode ser nulo!");
		}

		if (funcionario.getCpf() == null) {
			throw new ValidacaoException("O cpf do funcionário não pode ser nulo!");
		}

		if (funcionario.getLogin() == null) {
			throw new ValidacaoException("O Login do funcionário não pode ser nulo!");
		}

		if (funcionario.getNome() == null) {
			throw new ValidacaoException("O nome do funcionário não pode ser nulo!");
		}

		if (funcionario.getSenha() == null) {
			throw new ValidacaoException("A senha do funcionário não pode ser nulo!");
		}
		
		try {

			for (Funcionario f : daoFuncionario.getAll()) {

				if (funcionario.getCpf().equals(f.getCpf())) {
					throw new ValidacaoException("O CPF já está cadastrado!!!");
				}
				
//				if(funcionario.getLogin().equals(f.getLogin())) {
//					throw new ValidacaoException("Login existente!");
//				}
				
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro", "Não existe funcionário", e.getMessage());
		}
	}
	
	
	/**
	 * @deprecated
	 */
	@Override
	public void validar(String login, String Senha) throws ValidacaoException {
		// TODO Auto-generated method stub
		try {

			for (Funcionario f : daoFuncionario.getAll()) {

				if (!login.equals(f.getLogin()))
					throw new ValidacaoException("Usuário não existe!!!");
				if (!Senha.equals(f.getSenha()))
					throw new ValidacaoException("Usuário não existe!!!");
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}


}
