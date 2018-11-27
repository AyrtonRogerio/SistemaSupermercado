package br.com.sistemasupermercado.dao;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Fornecedor;

import java.util.List;

public interface IDaoFornecedor {

    public void salvar(Fornecedor fornecedor) throws DaoException;

    public Fornecedor buscarPorId(int id) throws DaoException;

    public List<Fornecedor> getAll() throws DaoException;

    public void editar(Fornecedor fornecedor) throws DaoException;

    public void ativarDesativar(int id) throws DaoException;

}
