package br.com.sistemasupermercado.business;

import br.com.sistemasupermercado.dao.DaoCliente;
import br.com.sistemasupermercado.dao.IDaoCliente;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Cliente;
import br.com.sistemasupermercado.model.ClienteTabAdapter;
import br.com.sistemasupermercado.model.Funcionario;

import java.util.List;

/**
 * @author ayrton
 */
public class BusinessCliente implements IBusinessCliente {

	private IDaoCliente daoCliente;

	public BusinessCliente() {

		daoCliente = new DaoCliente();
	}

	@Override
	public void salvar(Cliente cliente) throws BusinessException {
		try {
			validar(cliente);
			if (cliente.getId() == null)
				daoCliente.salvar(cliente);

		} catch (DaoException | ValidacaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}

	}

	@Override
	public void editar(Cliente cliente) throws BusinessException {
		try {
			daoCliente.editar(cliente);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Cliente buscarPorId(int id) throws BusinessException {
		try {
			return daoCliente.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public ClienteTabAdapter buscarPorCPF(String cpf) throws BusinessException {
		try {
			return daoCliente.buscarPorCPF(cpf);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<ClienteTabAdapter> getAllAdapter() throws BusinessException {
		try {
			return daoCliente.getAllAdapter();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Cliente> getAll() throws BusinessException {
		try {
			return daoCliente.getAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void ativarDesativar(int id) throws BusinessException {
		try {
			daoCliente.ativarDesativar(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void validar(Cliente cliente) throws ValidacaoException {

		if(cliente == null) {
			throw new ValidacaoException("Preencha os campos do cliente");
		}
		
		if (cliente.getContatos() == null) {
			throw new ValidacaoException("Os contatos do cliente não pode ser vazio");
		}

		if (cliente.getCpf() == null) {
			throw new ValidacaoException("O CPF do cliente não pode ser vazio");
		}

		if (cliente.getData_nascimento() == null) {
			throw new ValidacaoException("A data de nascimento do cliente não pode ser vazio");
		}

		if (cliente.getEndereco() == null) {
			throw new ValidacaoException("O endereço do cliente não pode ser vazio");
		}

		if (cliente.getEstado_civil() == null) {
			throw new ValidacaoException("O estado civil do cliente não pode ser vazio");
		}

		if (cliente.getNome() == null) {
			throw new ValidacaoException("O nome do cliente não pode ser vazio");
		}

		if (cliente.getOcupacao() == null) {
			throw new ValidacaoException("A ocupação do cliente não pode ser vazio");
		}

		if (cliente.getSexo() == null) {
			throw new ValidacaoException("O sexo do cliente não pode ser vazio");
		}

	}

}
