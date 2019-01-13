package br.com.sistemasupermercado.dao;

import java.sql.Date;
import java.util.List;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Caixa;

public interface IDaoCaixa {

	public void salvar(Caixa caixa, int funcionario_id) throws DaoException;

	public Caixa buscarPorId(int id) throws DaoException;

	public Caixa buscarPorData(Date data) throws DaoException;

	public Caixa buscarPorAnterior() throws DaoException;

	public List<Caixa> getAll() throws DaoException;

	public void editar(Caixa caixa) throws DaoException;

	public void ativarDesativar(int id) throws DaoException;
	
}
