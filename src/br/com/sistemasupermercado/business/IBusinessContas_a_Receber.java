package br.com.sistemasupermercado.business;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Contas_a_Receber_Adapter;
import br.com.sistemasupermercado.model.Contas_a_receber;
import java.util.List;

public interface IBusinessContas_a_Receber {

    public void salvar(Contas_a_receber contas_a_receber, int caixa_id, int venda_id) throws BusinessException;

    public void editar(Contas_a_receber contas_a_receber) throws BusinessException;

    public Contas_a_receber buscarPorId(int id) throws BusinessException;

public List<Contas_a_Receber_Adapter> getAll() throws BusinessException;
    
    public List<Contas_a_Receber_Adapter> getAll_Recebida() throws BusinessException;
    
    public List<Contas_a_Receber_Adapter> getAll_A_Receber() throws BusinessException;

    public void ativarDesativar(int id) throws BusinessException;

    public void validar(Contas_a_receber contas_a_receber) throws ValidacaoException;
}
