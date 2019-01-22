package br.com.sistemasupermercado.fachada;

import java.sql.Date;
import java.util.List;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.*;

public interface IFachada {

	// Produto
	public int salvarProduto(Produto produto) throws BusinessException;

	public void editarProduto(Produto produto) throws BusinessException;

	public Produto buscarPorIdProduto(int id) throws BusinessException;

	public List<Produto> getAllProduto() throws BusinessException;

	public void ativarDesativarProduto(int id) throws BusinessException;

	// Caixa
	public void salvarCaixa(Caixa caixa, int funcionario_id) throws BusinessException;

	public void editarCaixa(Caixa caixa) throws BusinessException;

	public Caixa buscarPorIdCaixa(int id) throws BusinessException;

	public Caixa buscarPorDataCaixa(Date data) throws BusinessException;

	public Caixa buscarPorAnterior() throws BusinessException;

	public List<Caixa> getAllCaixa() throws BusinessException;

	public void ativarDesativarCaixa(int id) throws BusinessException;



	// Funcionario
	public void salvarFuncionario(Funcionario funcionario) throws BusinessException, ValidacaoException;

	public void editarFuncionario(Funcionario funcionario) throws BusinessException;

	public Funcionario buscarPorIdFuncionario(int id) throws BusinessException;

	public List<Funcionario> getAllFuncionario() throws BusinessException;
	
	public Funcionario buscarPorLoginFuncionario(String login, String senha) throws BusinessException;

	public void ativarDesativarFuncionario(int id) throws BusinessException;

	//Fornecedor

	public int salvarFornecedor(Fornecedor fornecedor) throws BusinessException;

	public void editarFornecedor(Fornecedor fornecedor) throws BusinessException;

	public Fornecedor buscarPorIdFornecedor(int id) throws BusinessException;

	public Fornecedor buscarPorNomeFornecedor(String nome) throws BusinessException;
	
	public List<Fornecedor> getAllFornecedor() throws BusinessException;

	public void ativarDesativarFornecedor(int id) throws BusinessException;


	//Pagamento
	
	public void salvarPagamento(Pagamento pagamento, int id_cliente, int id_venda) throws BusinessException;

	public void editarPagamento(Pagamento pagamento) throws BusinessException;

	public Pagamento buscarPorIdPagamento(int id) throws BusinessException;

	public List<Pagamento> getAllPagamento() throws BusinessException;

	public void ativarDesativarPagamento(int id) throws BusinessException;
	
	//Cliente
	
	
	public void salvarCliente(Cliente cliente) throws BusinessException;

	public void editarCliente(Cliente cliente) throws BusinessException;

	public Cliente buscarPorIdCliente(int id) throws BusinessException;

	public ClienteTabAdapter buscarPorCPFCliente(String cpf) throws BusinessException;

	public List<ClienteTabAdapter> getAllAdapterCliente() throws BusinessException;
	
	public List<Cliente> getAllCliente() throws BusinessException;

	public void ativarDesativarCliente(int id) throws BusinessException;
	
	//ItemProduto
	
	public void salvarItemProduto(Item_Produto item_Produto,int produto_id, int id_fornecedor) throws BusinessException;

	public void editar_Item_Produto(Item_Produto item_produto) throws BusinessException;

	public Item_Produto buscarPorIdItemProduto(int id) throws BusinessException;
	
	public List<Item_Produto> getAllItemProduto() throws BusinessException;

	public List<ProdutoTabAdapter> getAllAdapterItemProduto() throws BusinessException;

	public List<EstoqueTabAdapter> getAllEstoqueAdapterProduto() throws BusinessException;
	
	public List<EstoqueTabAdapter> getAllEstoqueAdapterPorBusca(String busca) throws BusinessException;
	
	public List<ProdutoTabAdapter> getAllAdapterPorBuscaItemProduto(String busca) throws BusinessException;

	public VendaTabAdapter buscarPorIdVendaAdapterProduto(int id) throws BusinessException;

	public void atualizarVendidos_Item_Produto(Item_Produto item_produto) throws BusinessException;

	public void ativarDesativarItemProduto(int id) throws BusinessException;

	//Venda

	public int salvarVenda(Venda venda, int id_cliente, int id_funcionario, int id_caixa) throws BusinessException;

	public void editar_Venda(Venda venda) throws BusinessException;

	public Venda buscarPorIdVenda(int id) throws BusinessException;

	public List<Venda> getAllVenda() throws BusinessException;

	public void ativarDesativarVenda(int id) throws BusinessException;

	//Item_Venda

	public void salvar_Item_Venda(Item_Venda item_Venda, int venda_id, int item_produto_id) throws BusinessException;

	public void editar_Item_Venda(Item_Venda item_venda) throws BusinessException;

	public Item_Venda buscarPorId_Item_Venda(int id) throws BusinessException;

	public List<Item_Venda> getAll_Item_Venda() throws BusinessException;

	public void ativarDesativar_Item_Venda(int id) throws BusinessException;

	//Contas a Pagar

	public void salvarConta_a_Pagar(Contas_a_pagar contas_a_pagar, int caixa_id, int fornecedor_id) throws BusinessException;

	public void editarConta_a_Pagar(Contas_a_pagar contas_a_pagar) throws BusinessException;

	public Contas_a_pagar buscarPorIdConta_a_Pagar(int id) throws BusinessException;

	public List<Contas_a_Pagar_Adapter> getAllConta_a_Pagar() throws BusinessException;
	
	public List<Contas_a_Pagar_Adapter> getAll_PagaConta_a_Pagar() throws BusinessException;
	
	public List<Contas_a_Pagar_Adapter> getAll_A_PagarConta_a_Pagar() throws BusinessException;
	
	public List<RelatorioFinanceiro> getRelatorio(java.util.Date inicio, java.util.Date fim) throws BusinessException;

	public void ativarDesativarConta_a_Pagar(int id) throws BusinessException;

	//Contas a Receber

	public void salvarConta_a_Receber(Contas_a_receber contas_a_receber, int caixa_id, int venda_id) throws BusinessException;

	public void editarConta_a_Receber(Contas_a_receber contas_a_receber) throws BusinessException;

	public Contas_a_receber buscarPorIdConta_a_Receber(int id) throws BusinessException;

	public List<Contas_a_Receber_Adapter> getAllConta_a_Receber() throws BusinessException;
	
	public List<Contas_a_Receber_Adapter> getAll_RecebidaConta_a_Receber() throws BusinessException;
	
	public List<Contas_a_Receber_Adapter> getAll_A_ReceberConta_a_Receber() throws BusinessException;

	public void ativarDesativarConta_a_Receber(int id) throws BusinessException;


}
