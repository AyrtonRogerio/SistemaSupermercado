package br.com.sistemasupermercado.fachada;

import java.util.List;

import br.com.sistemasupermercado.business.BusinessCaixa;
import br.com.sistemasupermercado.business.BusinessEndereco;
import br.com.sistemasupermercado.business.BusinessFuncionario;
import br.com.sistemasupermercado.business.BusinessProduto;
import br.com.sistemasupermercado.business.IBusinessCaixa;
import br.com.sistemasupermercado.business.IBusinessEndereco;
import br.com.sistemasupermercado.business.IBusinessFuncionario;
import br.com.sistemasupermercado.business.IBusinessProduto;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.model.Caixa;
import br.com.sistemasupermercado.model.Endereco;
import br.com.sistemasupermercado.model.Funcionario;
import br.com.sistemasupermercado.model.Produto;

public class Fachada implements IFachada {

	private static Fachada instance;
	private IBusinessProduto businessProduto;
	private IBusinessFuncionario businessFuncionario;
	private IBusinessCaixa businessCaixa;
	private IBusinessEndereco businessEndereco;

	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	private Fachada() {

		businessProduto = new BusinessProduto();
		businessFuncionario = new BusinessFuncionario();
		businessCaixa = new BusinessCaixa();
		businessEndereco = new BusinessEndereco();
		

	}

	
	//Produto
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

	//Caixa
	@Override
	public void salvarEditarCaixa(Caixa caixa) throws BusinessException {
		// TODO Auto-generated method stub
		this.businessCaixa.salvarEditar(caixa);
	}

	@Override
	public Caixa buscarPorIdCaixa(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return this.buscarPorIdCaixa(id);
	}

	@Override
	public List<Caixa> getAllCaixa() throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessCaixa.getAll();
	}

	@Override
	public void ativarDesativarCaixa(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	//Endereco
	@Override
	public void salvarEditarEndereco(Endereco endereco) throws BusinessException {
		// TODO Auto-generated method stub
		this.businessEndereco.salvarEditar(endereco);
	}

	@Override
	public Endereco buscarPorIdEndereco(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessEndereco.buscarPorId(id);
	}

	@Override
	public List<Endereco> getAllEndereco() throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessEndereco.getAll();
	}

	@Override
	public void ativarDesativarEndereco(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	
	//Funcionário
	@Override
	public void salvarEditarFuncionario(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		this.businessFuncionario.salvarEditar(funcionario);
	}

	@Override
	public Funcionario buscarPorIdFuncionario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		 return this.businessFuncionario.buscarPorId(id);
	}

	@Override
	public List<Funcionario> getAllFuncionario() throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessFuncionario.getAll();
	}

	@Override
	public void ativarDesativarFuncionario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

}
