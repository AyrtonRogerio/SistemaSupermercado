package br.com.sistemasupermercado.fachada;

import java.util.List;

import br.com.sistemasupermercado.business.BusinessProduto;
import br.com.sistemasupermercado.business.IBusinessProduto;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Caixa;
import br.com.sistemasupermercado.model.Endereco;
import br.com.sistemasupermercado.model.Funcionario;
import br.com.sistemasupermercado.model.Produto;

public class Fachada implements IFachada {

	private static Fachada instance;
	private IBusinessProduto businessProduto;

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	private Fachada() {

		businessProduto = new BusinessProduto();

	}

	@Override
	public void salvarEditarProduto(Produto produto) throws BusinessException {
		this.businessProduto.salvarEditar(produto);

	}

	@Override
	public Produto buscarPorIdProduto(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessProduto.buscarPorId(id);
	}

	@Override
	public List<Produto> getAllProduto() throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessProduto.getAll();
	}

	@Override
	public void ativarDesativarProduto(int id) throws BusinessException {
		// TODO Auto-generated method stub

	}

	@Override
	public void validarProduto(Produto produto) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salvarEditarCaixa(Caixa caixa) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Caixa buscarPorIdCaixa(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Caixa> getAllCaixa() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ativarDesativarCaixa(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarCaixa(Caixa caixa) throws ValidacaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salvarEditarEndereco(Endereco endereco) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Endereco buscarPorIdEndereco(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> getAllEndereco() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ativarDesativarEndereco(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarEndereco(Endereco endereco) throws ValidacaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salvarEditarFuncionario(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Funcionario buscarPorIdFuncionario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> getAllFuncionario() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ativarDesativarFuncionario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validarFuncionario(Funcionario funcionario) throws ValidacaoException {
		// TODO Auto-generated method stub
		
	}

}
