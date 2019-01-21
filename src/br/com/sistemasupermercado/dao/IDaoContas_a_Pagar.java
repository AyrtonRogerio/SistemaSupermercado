package br.com.sistemasupermercado.dao;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Contas_a_Pagar_Adapter;
import br.com.sistemasupermercado.model.Contas_a_pagar;
import br.com.sistemasupermercado.model.RelatorioFinanceiro;

import java.sql.Date;
import java.util.List;

public interface IDaoContas_a_Pagar {


    public void salvar(Contas_a_pagar contas_a_pagar, int caixa_id, int fornecedor_id) throws DaoException;

    public Contas_a_pagar buscarPorId(int id) throws DaoException;

    public List<Contas_a_Pagar_Adapter> getAll() throws DaoException;
    
    /**
	 * @param busca
	 * @return
	 * @throws DaoException
	 */
    public List<Contas_a_Pagar_Adapter> getAllHistorico(String busca) throws DaoException;
    
    public List<Contas_a_Pagar_Adapter> getAll_Paga() throws DaoException;
    
    public List<Contas_a_Pagar_Adapter> getAll_A_Pagar() throws DaoException;
    
    public List<RelatorioFinanceiro> getRelatorio(java.util.Date inicio, java.util.Date fim) throws DaoException;

    public void editar(Contas_a_pagar contas_a_pagar) throws DaoException;

    public void ativarDesativar(int id) throws DaoException;

	
	

}
