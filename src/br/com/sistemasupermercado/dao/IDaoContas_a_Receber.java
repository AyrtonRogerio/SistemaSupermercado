package br.com.sistemasupermercado.dao;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Contas_a_receber;

import java.util.List;

public interface IDaoContas_a_Receber {
    public void salvar(Contas_a_receber contas_a_receber, int caixa_id, int venda_id) throws DaoException;

    public Contas_a_receber buscarPorId(int id) throws DaoException;

    public List<Contas_a_receber> getAll() throws DaoException;

    public void editar(Contas_a_receber contas_a_receber) throws DaoException;

    public void ativarDesativar(int id) throws DaoException;
}
