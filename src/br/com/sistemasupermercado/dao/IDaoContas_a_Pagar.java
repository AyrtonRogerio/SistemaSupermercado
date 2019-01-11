package br.com.sistemasupermercado.dao;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Contas_a_pagar;
import java.util.List;

public interface IDaoContas_a_Pagar {


    public void salvar(Contas_a_pagar contas_a_pagar, int caixa_id, int fornecedor_id) throws DaoException;

    public Contas_a_pagar buscarPorId(int id) throws DaoException;

    public List<Contas_a_pagar> getAll() throws DaoException;

    public void editar(Contas_a_pagar contas_a_pagar) throws DaoException;

    public void ativarDesativar(int id) throws DaoException;

}
