package br.com.sistemasupermercado.business;

import br.com.sistemasupermercado.dao.DaoCliente;
import br.com.sistemasupermercado.dao.IDaoCliente;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Cliente;
import br.com.sistemasupermercado.model.Funcionario;

import java.util.List;

public class BusinessCliente implements  IBusinessCliente {
    
	private IDaoCliente daoCliente;
	
	/**
	 * 
	 */
	public BusinessCliente() {
	
		daoCliente = new DaoCliente();
	}
	
	@Override
    public void salvarEditar(Cliente cliente) throws BusinessException {
		try {
//			validar(cliente);
			if (cliente.getId() == null)
				 daoCliente.salvar(cliente);
			else
				daoCliente.editar(cliente);
		} catch (DaoException  e) {
			// TODO Auto-generated catch block
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
    	if (cliente.getNome() == null)
			throw new ValidacaoException("Informe um nome!!!");
//				if (cliente.getCpf().equals(f.getCpf()))
//					throw new ValidacaoException("O CPF já está cadastrado!!!");
//			}
    }
}
