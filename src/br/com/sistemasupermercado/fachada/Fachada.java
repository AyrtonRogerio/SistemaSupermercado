package br.com.sistemasupermercado.fachada;

import java.sql.Date;
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
	private IBusinessItem_Produto businessItem_Produto;
	private IBusinessVenda businessVenda;
	private IBusinessItem_Venda businessItem_venda;
	private IBusinessContas_a_Pagar businessContas_a_pagar;
	private IBusinessContas_a_Receber businessContas_a_receber;

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
		businessItem_Produto = new BusinessItem_Produto();
		businessVenda = new BusinessVenda();
		businessItem_venda = new BusinessItem_Venda();
		businessContas_a_pagar = new BusinessContas_a_Pagar();
		businessContas_a_receber = new BusinessContas_a_Receber();

	}

	
	//Produto
	@Override
	public int salvarProduto(Produto produto) throws BusinessException {
		 return this.businessProduto.salvar(produto);

	}

	@Override
	public void editarProduto(Produto produto) throws BusinessException {
			this.businessProduto.editar(produto);
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
		this.businessProduto.ativarDesativar(id);
	}

	//Caixa
	@Override
	public void salvarCaixa(Caixa caixa, int funcionario_id) throws BusinessException {
		// TODO Auto-generated method stub
		this.businessCaixa.salvar(caixa, funcionario_id);
	}

	@Override
	public void editarCaixa(Caixa caixa) throws BusinessException {
		this.businessCaixa.editar(caixa);
	}

	@Override
	public Caixa buscarPorIdCaixa(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessCaixa.buscarPorId(id);
	}

	@Override
	public Caixa buscarPorDataCaixa(Date data) throws BusinessException {
		return this.businessCaixa.buscarPorData(data);
	}

	@Override
	public Caixa buscarPorAnterior() throws BusinessException {
		return this.businessCaixa.buscarPorAnterior();
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
	public void salvarFuncionario(Funcionario funcionario) throws BusinessException {
		// TODO Auto-generated method stub
		this.businessFuncionario.salvar(funcionario);
	}

	@Override
	public void editarFuncionario(Funcionario funcionario) throws BusinessException {
		this.businessFuncionario.editar(funcionario);
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
	
	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.fachada.IFachada#buscarPorLoginFuncionario(java.lang.String, java.lang.String)
	 */
	@Override
	public Funcionario buscarPorLoginFuncionario(String login, String senha) throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessFuncionario.buscarPorLogin(login, senha);
	}

	@Override
	public void ativarDesativarFuncionario(int id) throws BusinessException {
		// TODO Auto-generated method stub
		this.businessFuncionario.ativarDesativar(id);
	}

	//Fornecedor

	@Override
	public int salvarFornecedor(Fornecedor fornecedor) throws BusinessException {

	    return this.businessFornecedor.salvar(fornecedor);
		
	}

	@Override
	public void editarFornecedor(Fornecedor fornecedor) throws BusinessException {
		this.businessFornecedor.editar(fornecedor);
	}

	@Override
	public Fornecedor buscarPorIdFornecedor(int id) throws BusinessException {
		return this.businessFornecedor.buscarPorId(id);
	}

	@Override
	public List<Fornecedor> getAllFornecedor() throws BusinessException {
		return this.businessFornecedor.getAll();
	}
	
	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.fachada.IFachada#buscarPorNomeFornecedor(java.lang.String)
	 */
	@Override
	public Fornecedor buscarPorNomeFornecedor(String nome) throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessFornecedor.buscarPorNome(nome);
	}

	@Override
	public void ativarDesativarFornecedor(int id) throws BusinessException {

		this.businessFornecedor.ativarDesativar(id);
	}

	//Pagamento
	
	@Override
	public void salvarPagamento(Pagamento pagamento, int id_cliente, int id_venda) throws BusinessException {
		// TODO Auto-generated method stub
		this.businessPagamento.salvar(pagamento, id_cliente,id_venda);
	}

	@Override
	public void editarPagamento(Pagamento pagamento) throws BusinessException {
		this.businessPagamento.editar(pagamento);
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
	public void salvarCliente(Cliente cliente) throws BusinessException {
		// TODO Auto-generated method stub
		 this.businessCliente.salvar(cliente);
	}

	@Override
	public void editarCliente(Cliente cliente) throws BusinessException {
		this.businessCliente.editar(cliente);
	}

	@Override
	public Cliente buscarPorIdCliente(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessCliente.buscarPorId(id);
	}

	@Override
	public ClienteTabAdapter buscarPorCPFCliente(String cpf) throws BusinessException {
		return this.businessCliente.buscarPorCPF(cpf);
	}

	@Override
	public List<ClienteTabAdapter> getAllAdapterCliente() throws BusinessException {
		return this.businessCliente.getAllAdapter();
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
	
	//ItemProduto

	
	@Override
	public void salvarItemProduto(Item_Produto item_Produto,int produto_id, int id_fornecedor) throws BusinessException {
		// TODO Auto-generated method stub
		this.businessItem_Produto.salvar(item_Produto,produto_id, id_fornecedor);
	}

	@Override
	public void editar_Item_Produto(Item_Produto item_produto) throws BusinessException {
		this.businessItem_Produto.editar(item_produto);
	}


	@Override
	public Item_Produto buscarPorIdItemProduto(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessItem_Produto.buscarPorId(id);
	}

	
	@Override
	public List<Item_Produto> getAllItemProduto() throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessItem_Produto.getAll();
	}

	@Override
	public List<ProdutoTabAdapter> getAllAdapterItemProduto() throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessItem_Produto.getAllAdapter();
	}

	@Override
	public List<EstoqueTabAdapter> getAllEstoqueAdapterPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessItem_Produto.getAllEstoqueAdapterPorBusca(busca);
	}
	
	@Override
	public List<ProdutoTabAdapter> getAllAdapterPorBuscaItemProduto(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessItem_Produto.getAllAdapterPorBusca(busca);
	}

	@Override
	public VendaTabAdapter buscarPorIdVendaAdapterProduto(int id) throws BusinessException {
		return this.businessItem_Produto.buscarPorIdVendaAdapter(id);
	}

	@Override
	public void atualizarVendidos_Item_Produto(Item_Produto item_produto) throws BusinessException {
			this.businessItem_Produto.atualizarVenidos(item_produto);
	}

	@Override
	public List<EstoqueTabAdapter> getAllEstoqueAdapterProduto() throws BusinessException {
		return this.businessItem_Produto.getAllEstoqueAdapter();
	}


	@Override
	public void ativarDesativarItemProduto(int id) throws BusinessException {
		// TODO Auto-generated method stub
		this.businessItem_Produto.ativarDesativar(id);
	}

	//Venda

	@Override
	public int salvarVenda(Venda venda, int id_cliente, int id_funcionario, int id_caixa) throws BusinessException {
			return this.businessVenda.salvar(venda, id_cliente, id_funcionario, id_caixa);
	}

	@Override
	public void editar_Venda(Venda venda) throws BusinessException {
		this.businessVenda.editar(venda);
	}

	@Override
	public Venda buscarPorIdVenda(int id) throws BusinessException {
		return this.businessVenda.buscarPorId(id);
	}

	@Override
	public List<Venda> getAllVenda() throws BusinessException {
		return this.businessVenda.getAll();
	}

	@Override
	public void ativarDesativarVenda(int id) throws BusinessException {
		this.businessVenda.ativarDesativar(id);
	}

	//Item_Venda

	@Override
	public void salvar_Item_Venda(Item_Venda item_Venda, int venda_id, int item_produto_id) throws BusinessException {
		this.businessItem_venda.salvar(item_Venda,venda_id,item_produto_id);
	}

	@Override
	public void editar_Item_Venda(Item_Venda item_venda) throws BusinessException {
		this.businessItem_venda.editar(item_venda);
	}

	@Override
	public Item_Venda buscarPorId_Item_Venda(int id) throws BusinessException {
		return this.businessItem_venda.buscarPorId(id);
	}

	@Override
	public List<Item_Venda> getAll_Item_Venda() throws BusinessException {
		return this.businessItem_venda.getAll();
	}

	@Override
	public void ativarDesativar_Item_Venda(int id) throws BusinessException {
		this.businessItem_venda.ativarDesativar(id);
	}

	//Conta a pagar

	@Override
	public void salvarConta_a_Pagar(Contas_a_pagar contas_a_pagar, int caixa_id, int fornecedor_id) throws BusinessException {
			this.businessContas_a_pagar.salvar(contas_a_pagar,caixa_id,fornecedor_id);
	}

	@Override
	public void editarConta_a_Pagar(Contas_a_pagar contas_a_pagar) throws BusinessException {
			this.businessContas_a_pagar.editar(contas_a_pagar);
	}

	@Override
	public Contas_a_pagar buscarPorIdConta_a_Pagar(int id) throws BusinessException {
		return this.businessContas_a_pagar.buscarPorId(id);
	}

	@Override
	public List<Contas_a_Pagar_Adapter> getAllConta_a_Pagar() throws BusinessException {
		return this.businessContas_a_pagar.getAll();
	}

	@Override
	public List<Contas_a_Pagar_Adapter> getAll_PagaConta_a_Pagar() throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessContas_a_pagar.getAll_Paga();
	}

	@Override
	public List<Contas_a_Pagar_Adapter> getAll_A_PagarConta_a_Pagar() throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessContas_a_pagar.getAll_A_Pagar();
	}
	
	@Override
	public List<RelatorioFinanceiro> getRelatorio(java.util.Date inicio, java.util.Date fim) throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessContas_a_pagar.getRelatorio(inicio, fim);
	}
	
	@Override
	public void ativarDesativarConta_a_Pagar(int id) throws BusinessException {
			this.businessContas_a_pagar.ativarDesativar(id);
	}

	//Conta a Receber

	@Override
	public void salvarConta_a_Receber(Contas_a_receber contas_a_receber, int caixa_id, int venda_id) throws BusinessException {
			this.businessContas_a_receber.salvar(contas_a_receber,caixa_id,venda_id);
	}

	@Override
	public void editarConta_a_Receber(Contas_a_receber contas_a_receber) throws BusinessException {
			this.businessContas_a_receber.editar(contas_a_receber);
	}

	@Override
	public Contas_a_receber buscarPorIdConta_a_Receber(int id) throws BusinessException {
		return this.businessContas_a_receber.buscarPorId(id);
	}

	@Override
	public List<Contas_a_Receber_Adapter> getAllConta_a_Receber() throws BusinessException {
		return this.businessContas_a_receber.getAll();
	}

	@Override
	public void ativarDesativarConta_a_Receber(int id) throws BusinessException {
			this.businessContas_a_receber.ativarDesativar(id);
	}

	@Override
	public List<Contas_a_Receber_Adapter> getAll_RecebidaConta_a_Receber() throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessContas_a_receber.getAll_Recebida();
	}

	@Override
	public List<Contas_a_Receber_Adapter> getAll_A_ReceberConta_a_Receber() throws BusinessException {
		// TODO Auto-generated method stub
		return this.businessContas_a_receber.getAll_A_Receber();
	}
	

}
