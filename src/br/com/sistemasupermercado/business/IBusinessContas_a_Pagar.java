package br.com.sistemasupermercado.business;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Contas_a_Pagar_Adapter;
import br.com.sistemasupermercado.model.Contas_a_pagar;
import java.util.List;

public interface IBusinessContas_a_Pagar {

    public void salvar(Contas_a_pagar contas_a_pagar, int caixa_id, int fornecedor_id) throws BusinessException;

    public void editar(Contas_a_pagar contas_a_pagar) throws BusinessException;

    public Contas_a_pagar buscarPorId(int id) throws BusinessException;

 public List<Contas_a_Pagar_Adapter> getAll() throws BusinessException;
    
    public List<Contas_a_Pagar_Adapter> getAll_Paga() throws BusinessException;
    
    public List<Contas_a_Pagar_Adapter> getAll_A_Pagar() throws BusinessException;

    public void ativarDesativar(int id) throws BusinessException;

    public void validar(Contas_a_pagar contas_a_pagar) throws ValidacaoException;
}
