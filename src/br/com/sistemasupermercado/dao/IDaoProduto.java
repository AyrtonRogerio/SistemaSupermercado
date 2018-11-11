package br.com.sistemasupermercado.dao;

import java.util.List;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Produto;



public interface IDaoProduto {

	public void salvar(Produto produto) throws DaoException;

	public Produto buscarPorId(int id) throws DaoException;

	public List<Produto> getAll() throws DaoException;

	public void editar(Produto produto) throws DaoException;

	public void ativarDesativar(int id) throws DaoException;
	
	
}
