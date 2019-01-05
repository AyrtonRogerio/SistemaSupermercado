package br.com.sistemasupermercado.fachada;

import java.util.List;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.*;

public interface IFachada {

	// Produto
	public int salvarEditarProduto(Produto produto) throws BusinessException;

	public Produto buscarPorIdProduto(int id) throws BusinessException;

	public List<Produto> getAllProduto() throws BusinessException;

	public void ativarDesativarProduto(int id) throws BusinessException;

	// Caixa
	public void salvarEditarCaixa(Caixa caixa) throws BusinessException;

	public Caixa buscarPorIdCaixa(int id) throws BusinessException;

	public List<Caixa> getAllCaixa() throws BusinessException;

	public void ativarDesativarCaixa(int id) throws BusinessException;



	// Funcionario
	public void salvarEditarFuncionario(Funcionario funcionario) throws BusinessException;

	public Funcionario buscarPorIdFuncionario(int id) throws BusinessException;

	public List<Funcionario> getAllFuncionario() throws BusinessException;
	
	public Funcionario buscarPorLoginFuncionario(String login, String senha) throws BusinessException;

	public void ativarDesativarFuncionario(int id) throws BusinessException;

	//Fornecedor

	public int salvarEditarFornecedor(Fornecedor fornecedor) throws BusinessException;

	public Fornecedor buscarPorIdFornecedor(int id) throws BusinessException;

	public Fornecedor buscarPorNomeFornecedor(String nome) throws BusinessException;
	
	public List<Fornecedor> getAllFornecedor() throws BusinessException;

	public void ativarDesativarFornecedor(int id) throws BusinessException;


	//Pagamento
	
	public void salvarEditarPagamento(Pagamento pagamento, int id_cliente, int id_venda) throws BusinessException;

	public Pagamento buscarPorIdPagamento(int id) throws BusinessException;

	public List<Pagamento> getAllPagamento() throws BusinessException;

	public void ativarDesativarPagamento(int id) throws BusinessException;
	
	//Cliente
	
	
	public void salvarEditarCliente(Cliente cliente) throws BusinessException;

	public Cliente buscarPorIdCliente(int id) throws BusinessException;

	public ClienteTabAdapter buscarPorCPFCliente(String cpf) throws BusinessException;
	
	public List<Cliente> getAllCliente() throws BusinessException;

	public void ativarDesativarCliente(int id) throws BusinessException;
	
	//ItemProduto
	
	public void salvarEditarItemProduto(Item_Produto item_Produto, int id_fornecedor) throws BusinessException;

	public Item_Produto buscarPorIdItemProduto(int id) throws BusinessException;
	
	public List<Item_Produto> getAllItemProduto() throws BusinessException;

	public List<ProdutoTabAdapter> getAllAdapterItemProduto() throws BusinessException;

	public List<EstoqueTabAdapter> getAllEstoqueAdapter() throws BusinessException;

	public void ativarDesativarItemProduto(int id) throws BusinessException;

	//Venda

	public void salvarEditarVenda(Venda venda, int id_cliente, int id_funcionario, int id_caixa) throws BusinessException;

	public Venda buscarPorIdVenda(int id) throws BusinessException;

	public List<Venda> getAllVenda() throws BusinessException;

	public void ativarDesativarVenda(int id) throws BusinessException;

}
