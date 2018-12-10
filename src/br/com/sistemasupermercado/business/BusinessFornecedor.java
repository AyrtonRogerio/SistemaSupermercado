package br.com.sistemasupermercado.business;

import br.com.sistemasupermercado.dao.DaoFornecedor;
import br.com.sistemasupermercado.dao.IDaoFornecedor;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Fornecedor;

import java.util.List;

public class BusinessFornecedor implements IBusinessFornecedor {

    private IDaoFornecedor daoFornecedor;
    
    public BusinessFornecedor() {
        daoFornecedor = new DaoFornecedor();
    }

    @Override
    public int salvarEditar(Fornecedor fornecedor) throws BusinessException {

        try {
            validar(fornecedor);
            if (fornecedor.getId() == null)
              return daoFornecedor.salvar(fornecedor);
            else
                daoFornecedor.editar(fornecedor);
        } catch (DaoException | ValidacaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
        return 0;
    }

    @Override
    public Fornecedor buscarPorId(int id) throws BusinessException {
        try {
            return daoFornecedor.buscarPorId(id);
        } catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Fornecedor> getAll() throws BusinessException {
        try {
            return daoFornecedor.getAll();
        } catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void ativarDesativar(int id) throws BusinessException {

        try {
            daoFornecedor.ativarDesativar(id);
        } catch (DaoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void validar(Fornecedor fornecedor) throws ValidacaoException {

        if(fornecedor.getCnpj() == null)
            throw new ValidacaoException("Informe um CNPJ!!!");
    }

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.business.IBusinessFornecedor#buscarPorNome(java.lang.String)
	 */
	@Override
	public Fornecedor buscarPorNome(String nome) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoFornecedor.buscarPorNome(nome);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}
}
