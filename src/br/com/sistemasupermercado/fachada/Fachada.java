package br.com.sistemasupermercado.fachada;

import java.util.List;

import br.com.sistemasupermercado.business.*;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.model.*;

public class Fachada implements IFachada {

	private static Fachada instance;
	private IBusinessProduto businessProduto;
	private IBusinessFuncionario businessFuncionario;
	private IBusinessCaixa businessCaixa;
	private IBusinessFornecedor businessFornecedor;
	private IBusinessPagamento businessPagamento;
	private IBusinessCliente businessCliente;

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
		businessFornecedor = new BusinessFornecedor();
		businessPagamento = new BusinessPagamento();
		businessCliente = new BusinessCliente();
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
		this.businessCaixa.ativarDesativar(id);
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

	//Fornecedor

	@Override
	public void salvarEditarFornecedor(Fornecedor fornecedor) throws BusinessException {

	    this.businessFornecedor.salvarEditar(fornecedor);
	}

	@Override
	public Fornecedor buscarPorIdFornecedor(int id) throws BusinessException {
		return this.businessFornecedor.buscarPorId(id);
	}

	@Override
	public List<Fornecedor> getAllFornecedor() throws BusinessException {
		return this.businessFornecedor.getAll();
	}

	@Override
	public void ativarDesativarFornecedor(int id) throws BusinessException {

	}

	//Pagamento
	
	@Override
	public void salvarEditarPagamento(Pagamento pagamento) throws BusinessException {
		// TODO Auto-generated method stub
		this.businessPagamento.salvarEditar(pagamento);
	}

	
	@Override
	public Pagamento buscarPorIdPagamento(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessPagamento.buscarPorId(id);
	}

	
	@Override
	public List<Pagamento> getAllPagamento() throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessPagamento.getAll();
	}

	
	@Override
	public void ativarDesativarPagamento(int id) throws BusinessException {
		// TODO Auto-generated method stub
		this.businessPagamento.ativarDesativar(id);
	}

	//Cliente
	
	@Override
	public void salvarEditarCliente(Cliente cliente) throws BusinessException {
		// TODO Auto-generated method stub
		this.businessCliente.salvarEditar(cliente);
	}

	@Override
	public Cliente buscarPorIdCliente(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessCliente.buscarPorId(id);
	}

	@Override
	public List<Cliente> getAllCliente() throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessCliente.getAll();
	}

	@Override
	public void ativarDesativarCliente(int id) throws BusinessException {
		// TODO Auto-generated method stub
		this.businessCliente.ativarDesativar(id);
	}

}
