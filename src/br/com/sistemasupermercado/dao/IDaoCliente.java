package br.com.sistemasupermercado.dao;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Cliente;

import java.util.List;

public interface IDaoCliente {

    public void salvar(Cliente cliente) throws DaoException;

    public Cliente buscarPorId(int id) throws DaoException;

    public List<Cliente> getAll() throws DaoException;

    public void editar(Cliente cliente) throws DaoException;

    public void ativarDesativar(int id) throws DaoException;


}
