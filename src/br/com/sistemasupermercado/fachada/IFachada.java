package br.com.sistemasupermercado.fachada;

import java.util.List;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Caixa;
import br.com.sistemasupermercado.model.Endereco;
import br.com.sistemasupermercado.model.Funcionario;
import br.com.sistemasupermercado.model.Produto;

public interface IFachada {

	// Produto
	public void salvarEditarProduto(Produto produto) throws BusinessException;

	public Produto buscarPorIdProduto(int id) throws BusinessException;

	public List<Produto> getAllProduto() throws BusinessException;

	public void ativarDesativarProduto(int id) throws BusinessException;

	public void validarProduto(Produto produto) throws BusinessException;

	// Caixa
	public void salvarEditarCaixa(Caixa caixa) throws BusinessException;

	public Caixa buscarPorIdCaixa(int id) throws BusinessException;

	public List<Caixa> getAllCaixa() throws BusinessException;

	public void ativarDesativarCaixa(int id) throws BusinessException;

	public void validarCaixa(Caixa caixa) throws ValidacaoException;

	// Endereco
	public void salvarEditarEndereco(Endereco endereco) throws BusinessException;

	public Endereco buscarPorIdEndereco(int id) throws BusinessException;

	public List<Endereco> getAllEndereco() throws BusinessException;

	public void ativarDesativarEndereco(int id) throws BusinessException;

	public void validarEndereco(Endereco endereco) throws ValidacaoException;

	// Funcionario
	public void salvarEditarFuncionario(Funcionario funcionario) throws BusinessException;

	public Funcionario buscarPorIdFuncionario(int id) throws BusinessException;

	public List<Funcionario> getAllFuncionario() throws BusinessException;

	public void ativarDesativarFuncionario(int id) throws BusinessException;

	public void validarFuncionario(Funcionario funcionario) throws ValidacaoException;

}
