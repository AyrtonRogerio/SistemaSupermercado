package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Produto;

public interface IBusinessProduto {

	public void salvarEditar(Produto produto) throws BusinessException;

	public Produto buscarPorId(int id) throws BusinessException;

	public List<Produto> getAll() throws BusinessException;

	public void ativarDesativar(int id) throws BusinessException;

	public void validar(Produto produto) throws ValidacaoException;
	
}