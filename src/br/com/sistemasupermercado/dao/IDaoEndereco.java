package br.com.sistemasupermercado.dao;

import java.util.List;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Endereco;


public interface IDaoEndereco {

	public void salvar(Endereco endereco) throws DaoException;

	public Endereco buscarPorId(int id) throws DaoException;

	public List<Endereco> getAll() throws DaoException;

	public void editar(Endereco endereco) throws DaoException;

	public void ativarDesativar(int id) throws DaoException;
	
}
