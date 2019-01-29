package br.com.sistemasupermercado.dao;

import java.util.List;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Endereco;
import br.com.sistemasupermercado.model.Funcionario;
import br.com.sistemasupermercado.model.FuncionarioAdapter;

public interface IDaoFuncionario {

	public void salvar(Funcionario funcionario, int end) throws DaoException;

	public Funcionario buscarPorId(int id) throws DaoException;
	
	public List<FuncionarioAdapter> buscarPorBusca(String busca) throws DaoException;

	public List<Funcionario> getAll() throws DaoException;
	
	public List<FuncionarioAdapter> getAllAdapter() throws DaoException;
	
	public Funcionario buscarLogin(String login, String senha) throws DaoException;

	public void editar(Funcionario funcionario) throws DaoException;

	public void ativarDesativar(int id) throws DaoException;
	
}
