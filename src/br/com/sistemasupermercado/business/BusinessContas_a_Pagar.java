package br.com.sistemasupermercado.business;

import br.com.sistemasupermercado.dao.DaoContas_a_Pagar;
import br.com.sistemasupermercado.dao.IDaoContas_a_Pagar;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Contas_a_pagar;

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
    public List<Contas_a_pagar> getAll() throws BusinessException {
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
}
