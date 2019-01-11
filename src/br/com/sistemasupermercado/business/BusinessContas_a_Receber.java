package br.com.sistemasupermercado.business;

import br.com.sistemasupermercado.dao.DaoContas_a_Receber;
import br.com.sistemasupermercado.dao.IDaoContas_a_Receber;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Contas_a_receber;

import java.util.List;

public class BusinessContas_a_Receber implements  IBusinessContas_a_Receber {

    private IDaoContas_a_Receber daoContas_a_receber;

    public BusinessContas_a_Receber(){
        daoContas_a_receber = new DaoContas_a_Receber();
    }

    @Override
    public void salvar(Contas_a_receber contas_a_receber, int caixa_id, int venda_id) throws BusinessException {
        try {
                daoContas_a_receber.salvar(contas_a_receber, caixa_id, venda_id);

        } catch (DaoException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void editar(Contas_a_receber contas_a_receber) throws BusinessException {

        try {
            daoContas_a_receber.editar(contas_a_receber);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public Contas_a_receber buscarPorId(int id) throws BusinessException {
        try {
            return daoContas_a_receber.buscarPorId(id);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public List<Contas_a_receber> getAll() throws BusinessException {
        try {
            return daoContas_a_receber.getAll();
        } catch (DaoException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void ativarDesativar(int id) throws BusinessException {
        try {
            daoContas_a_receber.ativarDesativar(id);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new BusinessException(e.getMessage());
        }
    }

    @Override
    public void validar(Contas_a_receber contas_a_receber) throws ValidacaoException {

    }
}
