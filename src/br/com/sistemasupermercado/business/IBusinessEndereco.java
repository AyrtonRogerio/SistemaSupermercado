package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Endereco;
import br.com.sistemasupermercado.model.Produto;

public interface IBusinessEndereco {

	public void salvarEditar(Endereco endereco) throws BusinessException;

	public Endereco buscarPorId(int id) throws BusinessException;

	public List<Endereco> getAll() throws BusinessException;

	public void ativarDesativar(int id) throws BusinessException;
	
	public void validar(Endereco endereco) throws ValidacaoException;
}
