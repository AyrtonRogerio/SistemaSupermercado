package br.com.sistemasupermercado.business;

import br.com.sistemasupermercado.dao.DaoContas_a_Pagar;
import br.com.sistemasupermercado.dao.IDaoContas_a_Pagar;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Contas_a_Pagar_Adapter;
import br.com.sistemasupermercado.model.Contas_a_pagar;
import br.com.sistemasupermercado.model.RelatorioFinanceiro;

import java.sql.Date;
import java.util.List;

public class BusinessContas_a_Pagar implements IBusinessContas_a_Pagar {

    private IDaoContas_a_Pagar daoContas_a_pagar;

    public BusinessContas_a_Pagar() {
        daoContas_a_pagar = new DaoContas_a_Pagar();
    }

    @Override
    public void salvar(Contas_a_pagar contas_a_pagar, int caixa_id, int fornecedor_id) throws BusinessException {

        try {

                daoContas_a_pagar.salvar(contas_a_pagar, caixa_id, fornecedor_id);

        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editar(Contas_a_pagar contas_a_pagar) throws BusinessException {
        try {
            daoContas_a_pagar.editar(contas_a_pagar);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Contas_a_pagar buscarPorId(int id) throws BusinessException {
        try {
            return daoContas_a_pagar.buscarPorId(id);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Contas_a_Pagar_Adapter> getAll() throws BusinessException {
        try {
            return daoContas_a_pagar.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void ativarDesativar(int id) throws BusinessException {
        try {
            daoContas_a_pagar.ativarDesativar(id);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void validar(Contas_a_pagar contas_a_pagar) throws ValidacaoException {

    }

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.business.IBusinessContas_a_Pagar#getAll_Paga()
	 */
	@Override
	public List<Contas_a_Pagar_Adapter> getAll_Paga() throws BusinessException {
		try {
            return daoContas_a_pagar.getAll_Paga();
        } catch (DaoException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.business.IBusinessContas_a_Pagar#getAll_A_Pagar()
	 */
	@Override
	public List<Contas_a_Pagar_Adapter> getAll_A_Pagar() throws BusinessException {
		try {
            return daoContas_a_pagar.getAll_A_Pagar();
        } catch (DaoException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.business.IBusinessContas_a_Pagar#getAllHistorico(java.lang.String)
	 */
	@Override
	public List<Contas_a_Pagar_Adapter> getAllHistorico(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoContas_a_pagar.getAllHistorico(busca);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.business.IBusinessContas_a_Pagar#getRelatorio(java.sql.Date, java.sql.Date)
	 */
	@Override
	public List<RelatorioFinanceiro> getRelatorio(java.util.Date inicio, java.util.Date fim) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoContas_a_pagar.getRelatorio(inicio, fim);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}
}
