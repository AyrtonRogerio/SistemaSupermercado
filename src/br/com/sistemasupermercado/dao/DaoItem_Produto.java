/**
 * 
 */
package br.com.sistemasupermercado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.*;
import br.com.sistemasupermercado.sql.SQLConections;
import br.com.sistemasupermercado.sql.SQLUtil;

/**
 * @author ayrton
 *
 */
public class DaoItem_Produto implements IDaoItem_Produto {

	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
//	private Fachada fachada = Fachada.getInstance();
	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.dao.IDaoItem_Produto#salvar(br.com.sistemasupermercado.model.Item_Produto)
	 */
	@Override
	public void salvar(Item_Produto item_Produto,int produto_id, int id_fornecedor) throws DaoException {
		// TODO Auto-generated method stub
		try {
			
//			int produto_id = Fachada.getInstance().salvarProduto(item_Produto.getProduto_id());
						
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Item_Produto.INSERT);
			this.statement.setLong(1, item_Produto.getCod_barras());
			this.statement.setDouble(2, item_Produto.getUnid_medida());
			this.statement.setDate(3, new java.sql.Date(item_Produto.getData_fabricacao().getTime()));
			this.statement.setDate(4, new java.sql.Date(item_Produto.getData_validade().getTime()));
			this.statement.setDate(5, new java.sql.Date( item_Produto.getData_compra().getTime()));
			this.statement.setDouble(6, item_Produto.getPreco_unidade());
			this.statement.setDouble(7, item_Produto.getPorc_atacado());
			this.statement.setDouble(8, item_Produto.getPorc_varejo());
			this.statement.setInt(9, item_Produto.getQuantidade());
			this.statement.setInt(10,item_Produto.getVendidos());
			this.statement.setBoolean(11, item_Produto.isPerecivel());
			this.statement.setBoolean(12,item_Produto.isStatus());
			this.statement.setInt(13, id_fornecedor);
			this.statement.setInt(14, produto_id);
			this.statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoItem_Produto.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.dao.IDaoItem_Produto#buscarPorId(int)
	 */
	@Override
	public Item_Produto buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		Item_Produto item_Produto = null;
		try {
			Fornecedor fornecedor = null;
			Produto produto = null;
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Item_Produto.NOME_TABELA, id));
			this.result = this.statement.executeQuery();

			if (result.next()) {
				item_Produto = new Item_Produto();
				item_Produto.setId(result.getInt(1));
				item_Produto.setCod_barras(result.getInt(SQLUtil.Item_Produto.COL_COD_BARRAS));
				item_Produto.setUnid_medida(result.getDouble(SQLUtil.Item_Produto.COL_UNIADE_MEDIDA));
				item_Produto.setData_fabricacao(new Date(result.getDate(SQLUtil.Item_Produto.COL_DATA_FABRICACAO).getTime()));
				item_Produto.setData_validade(new Date(result.getDate(SQLUtil.Item_Produto.COL_DATA_VALIDADE).getTime()));
				item_Produto.setData_fabricacao(new Date(result.getDate(SQLUtil.Item_Produto.COL_DATA_COMPRA).getTime()));
				item_Produto.setPreco_unidade(result.getDouble(SQLUtil.Item_Produto.COL_PRECO_UNIDADE));
				item_Produto.setPorc_atacado(result.getDouble(SQLUtil.Item_Produto.COL_PORC_ATACADO));
				item_Produto.setPorc_varejo(result.getDouble(SQLUtil.Item_Produto.COL_PORC_VAREJO));
				item_Produto.setQuantidade(result.getInt(SQLUtil.Item_Produto.COL_QUANTIDADE));
				item_Produto.setVendidos(result.getInt(SQLUtil.Item_Produto.COL_VENDIDOS));
				item_Produto.setPerecivel(result.getBoolean(SQLUtil.Item_Produto.COL_PERECIVEL));
				item_Produto.setStatus(result.getBoolean(SQLUtil.Item_Produto.COL_STATUS));

				fornecedor = Fachada.getInstance().buscarPorIdFornecedor(result.getInt(SQLUtil.Item_Produto.COL_FORNECEDOR_ID));
				produto = Fachada.getInstance().buscarPorIdProduto(result.getInt(SQLUtil.Item_Produto.COL_PRODUTO_ID));
				
				item_Produto.setFornecedor_id(fornecedor);
				item_Produto.setProduto_id(produto);
				
			}
			this.conexao.close();

		} catch (SQLException | BusinessException ex) {
			Logger.getLogger(DaoItem_Produto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return item_Produto;
	}

	@Override
	public VendaTabAdapter buscarPorIdVendaAdapter(int id) throws DaoException {
		// TODO Auto-generated method stub
		VendaTabAdapter vendaTabAdapter = null;
		try {

			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Item_Produto.SELECT_PROD_LIST_VEND);
			this.statement.setInt(1,id);
			this.result = this.statement.executeQuery();

			if (result.next()) {
				vendaTabAdapter = new VendaTabAdapter();
				vendaTabAdapter.setVenda_cod_barras(result.getInt("cod_barras"));
				vendaTabAdapter.setVenda_descricao(result.getString("descricao"));
				vendaTabAdapter.setVenda_quantidade(result.getInt("quantidade"));
				vendaTabAdapter.setVenda_preco_varejo(result.getDouble("porc_varejo"));


			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoItem_Produto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return vendaTabAdapter;
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.dao.IDaoItem_Produto#getAll()
	 */
	@Override
	public List<Item_Produto> getAll() throws DaoException {
		// TODO Auto-generated method stub
		List<Item_Produto> item_Produtos = new ArrayList<>();
		try {
			Fornecedor fornecedor = null;
			Produto produto = null;
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Item_Produto.NOME_TABELA));
			this.result = this.statement.executeQuery();
			Item_Produto item_Produto;
			while (result.next()) {
				item_Produto = new Item_Produto();
				item_Produto.setId(result.getInt(1));
				item_Produto.setCod_barras(result.getInt(SQLUtil.Item_Produto.COL_COD_BARRAS));
				item_Produto.setUnid_medida(result.getDouble(SQLUtil.Item_Produto.COL_UNIADE_MEDIDA));
				item_Produto.setData_fabricacao(new Date(result.getDate(SQLUtil.Item_Produto.COL_DATA_FABRICACAO).getTime()));
				item_Produto.setData_validade(new Date(result.getDate(SQLUtil.Item_Produto.COL_DATA_VALIDADE).getTime()));
				item_Produto.setData_fabricacao(new Date(result.getDate(SQLUtil.Item_Produto.COL_DATA_COMPRA).getTime()));
				item_Produto.setPreco_unidade(result.getDouble(SQLUtil.Item_Produto.COL_PRECO_UNIDADE));
				item_Produto.setPorc_atacado(result.getDouble(SQLUtil.Item_Produto.COL_PORC_ATACADO));
				item_Produto.setPorc_varejo(result.getDouble(SQLUtil.Item_Produto.COL_PORC_VAREJO));
				item_Produto.setQuantidade(result.getInt(SQLUtil.Item_Produto.COL_QUANTIDADE));
				item_Produto.setVendidos(result.getInt(SQLUtil.Item_Produto.COL_VENDIDOS));
				item_Produto.setPerecivel(result.getBoolean(SQLUtil.Item_Produto.COL_PERECIVEL));
				item_Produto.setStatus(result.getBoolean(SQLUtil.Item_Produto.COL_STATUS));


				fornecedor = Fachada.getInstance().buscarPorIdFornecedor(result.getInt(SQLUtil.Item_Produto.COL_FORNECEDOR_ID));
				produto = Fachada.getInstance().buscarPorIdProduto(result.getInt(SQLUtil.Item_Produto.COL_PRODUTO_ID));
				
				item_Produto.setFornecedor_id(fornecedor);
				item_Produto.setProduto_id(produto);
				item_Produtos.add(item_Produto);
			}
			this.conexao.close();

		} catch (SQLException | BusinessException ex) {
			Logger.getLogger(DaoItem_Produto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return item_Produtos;
	}

	@Override
	public List<ProdutoTabAdapter> getAllAdapter() throws DaoException {
		// TODO Auto-generated method stub
		List<ProdutoTabAdapter> produtoTabAdapters = new ArrayList<>();
		try {


			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Item_Produto.SELECT_PRODUTO_ALL);
			this.result = this.statement.executeQuery();
			ProdutoTabAdapter produtoTabAdapter;
			while (result.next()) {
				produtoTabAdapter = new ProdutoTabAdapter();
				produtoTabAdapter.setDescricao(result.getString("descricao"));
				produtoTabAdapter.setMarca(result.getString("marca"));
				produtoTabAdapter.setCod_barras(result.getInt("cod_barras"));
				produtoTabAdapter.setPreco_varejo(result.getDouble("porc_varejo"));
				produtoTabAdapter.setEstoque(result.getInt("quantidade"));
				produtoTabAdapter.setData_cadastro(new java.util.Date(result.getDate("data_compra").getTime()));
				produtoTabAdapter.setStatus(result.getBoolean("status"));

				produtoTabAdapters.add(produtoTabAdapter);
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoItem_Produto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return produtoTabAdapters;
	}


	@Override
	public List<EstoqueTabAdapter> getAllEstoqueAdapter() throws DaoException {
		// TODO Auto-generated method stub
		List<EstoqueTabAdapter> estoqueTabAdapters = new ArrayList<>();
		try {


			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Item_Produto.SELECT_PROD_LIST_EST_ALL);
			this.result = this.statement.executeQuery();
			EstoqueTabAdapter estoqueTabAdapter;
			while (result.next()) {
				estoqueTabAdapter = new EstoqueTabAdapter();

				estoqueTabAdapter.setId(result.getInt("id"));
				estoqueTabAdapter.setCod_barras(result.getInt("cod_barras"));
				estoqueTabAdapter.setDescricao(result.getString("descricao"));
				estoqueTabAdapter.setQuantidade(result.getInt("quantidade"));
				estoqueTabAdapter.setPreco_unidade(result.getDouble("porc_varejo"));
				estoqueTabAdapters.add(estoqueTabAdapter);
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoItem_Produto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return estoqueTabAdapters;
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.dao.IDaoItem_Produto#editar(br.com.sistemasupermercado.model.Item_Produto)
	 */
	@Override
	public void editar(Item_Produto item_Produto) throws DaoException {
		// TODO Auto-generated method stub
		try {

			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Item_Produto.UPDATE);
			this.statement.setLong(1, item_Produto.getCod_barras());
			this.statement.setDouble(2, item_Produto.getUnid_medida());
			this.statement.setDate(3, new java.sql.Date(item_Produto.getData_fabricacao().getTime()));
			this.statement.setDate(4, new java.sql.Date(item_Produto.getData_validade().getTime()));
			this.statement.setDate(5, new java.sql.Date( item_Produto.getData_compra().getTime()));
			this.statement.setDouble(6, item_Produto.getPreco_unidade());
			this.statement.setDouble(7, item_Produto.getPorc_atacado());
			this.statement.setDouble(8, item_Produto.getPorc_varejo());
			this.statement.setInt(9, item_Produto.getQuantidade());
			this.statement.setInt(10,item_Produto.getVendidos());
			this.statement.setBoolean(11, item_Produto.isPerecivel());
			this.statement.setBoolean(12,item_Produto.isStatus());
			this.statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoItem_Produto.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void atualizarVenidos(Item_Produto item_Produto) throws DaoException {
		// TODO Auto-generated method stub
		try {

			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Item_Produto.UPDATE_VENDIDOS);
			this.statement.setInt(1, item_Produto.getVendidos());
			this.statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoItem_Produto.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.dao.IDaoItem_Produto#ativarDesativar(int)
	 */
	@Override
	public void ativarDesativar(int id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	
}
