package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Funcionario;

public interface IBusinessFuncionario {

	public void salvar(Funcionario funcionario) throws BusinessException, ValidacaoException;

	public void editar(Funcionario funcionario) throws BusinessException;

	public Funcionario buscarPorId(int id) throws BusinessException;

	public List<Funcionario> getAll() throws BusinessException;
	
	public Funcionario buscarPorLogin(String login, String senha) throws BusinessException;

	public void ativarDesativar(int id) throws BusinessException;

	public void validar(Funcionario funcionario) throws ValidacaoException;
	
	public void validar(String Login, String Senha) throws ValidacaoException;
	
}
