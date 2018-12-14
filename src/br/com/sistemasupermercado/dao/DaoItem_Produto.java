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
import br.com.sistemasupermercado.model.Fornecedor;
import br.com.sistemasupermercado.model.Item_Produto;
import br.com.sistemasupermercado.model.Produto;
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
	public void salvar(Item_Produto item_Produto) throws DaoException {
		// TODO Auto-generated method stub
		try {

			int fornecedor_id = Fachada.getInstance().salvarEditarFornecedor(item_Produto.getFornecedor_id()); 
			int produto_id = Fachada.getInstance().salvarEditarProduto(item_Produto.getProduto_id());
			
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Item_Produto.INSERT);
			this.statement.setBoolean(1, item_Produto.isPerecivel());
			this.statement.setBoolean(2, item_Produto.isStatus());
			this.statement.setInt(3, item_Produto.getQuantidade());
			this.statement.setInt(4, item_Produto.getCod_barras());
			this.statement.setDouble(5, item_Produto.getUnid_medida());
			this.statement.setDate(6, new java.sql.Date(item_Produto.getData_fabricacao().getTime()));
			this.statement.setDate(7, new java.sql.Date(item_Produto.getData_validade().getTime()));
			this.statement.setDate(8, new java.sql.Date( item_Produto.getData_compra().getTime()));
			this.statement.setDouble(9, item_Produto.getPreco_unidade());
			this.statement.setDouble(10, item_Produto.getPreco_atacado());
			this.statement.setDouble(11, item_Produto.getPreco_varejo());
			this.statement.setDouble(12, item_Produto.getPorc_atacado());
			this.statement.setDouble(13, item_Produto.getPorc_varejo());
			this.statement.setInt(14, fornecedor_id);
			this.statement.setInt(15, produto_id);
			statement.execute();
		} catch (SQLException | BusinessException ex) {
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
				item_Produto.setPerecivel(result.getBoolean(SQLUtil.Item_Produto.COL_PERECIVEL));
				item_Produto.setStatus(result.getBoolean(SQLUtil.Item_Produto.COL_STATUS));
				item_Produto.setQuantidade(result.getInt(SQLUtil.Item_Produto.COL_QUANTIDADE));
				item_Produto.setCod_barras(result.getInt(SQLUtil.Item_Produto.COL_COD_BARRAS));
				item_Produto.setUnid_medida(result.getDouble(SQLUtil.Item_Produto.COL_UNIADE_MEDIDA));
				item_Produto.setData_fabricacao(new Date(result.getDate(SQLUtil.Item_Produto.COL_DATA_FABRICACAO).getTime()));
				item_Produto.setData_validade(new Date(result.getDate(SQLUtil.Item_Produto.COL_DATA_VALIDADE).getTime()));
				item_Produto.setData_fabricacao(new Date(result.getDate(SQLUtil.Item_Produto.COL_DATA_COMPRA).getTime()));
				item_Produto.setPreco_unidade(result.getDouble(SQLUtil.Item_Produto.COL_PRECO_UNIDADE));
				item_Produto.setPreco_atacado(result.getDouble(SQLUtil.Item_Produto.COL_PRECO_ATACADO));
				item_Produto.setPreco_varejo(result.getDouble(SQLUtil.Item_Produto.COL_PRECO_VAREJO));
				item_Produto.setPorc_atacado(result.getDouble(SQLUtil.Item_Produto.COL_PORC_ATACADO));
				item_Produto.setPorc_varejo(result.getDouble(SQLUtil.Item_Produto.COL_PORC_VAREJO));
				
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
				item_Produto.setPerecivel(result.getBoolean(SQLUtil.Item_Produto.COL_PERECIVEL));
				item_Produto.setStatus(result.getBoolean(SQLUtil.Item_Produto.COL_STATUS));
				item_Produto.setQuantidade(result.getInt(SQLUtil.Item_Produto.COL_QUANTIDADE));
				item_Produto.setCod_barras(result.getInt(SQLUtil.Item_Produto.COL_COD_BARRAS));
				item_Produto.setUnid_medida(result.getDouble(SQLUtil.Item_Produto.COL_UNIADE_MEDIDA));
				item_Produto.setData_fabricacao(new Date(result.getDate(SQLUtil.Item_Produto.COL_DATA_FABRICACAO).getTime()));
				item_Produto.setData_validade(new Date(result.getDate(SQLUtil.Item_Produto.COL_DATA_VALIDADE).getTime()));
				item_Produto.setData_fabricacao(new Date(result.getDate(SQLUtil.Item_Produto.COL_DATA_COMPRA).getTime()));
				item_Produto.setPreco_unidade(result.getDouble(SQLUtil.Item_Produto.COL_PRECO_UNIDADE));
				item_Produto.setPreco_atacado(result.getDouble(SQLUtil.Item_Produto.COL_PRECO_ATACADO));
				item_Produto.setPreco_varejo(result.getDouble(SQLUtil.Item_Produto.COL_PRECO_VAREJO));
				item_Produto.setPorc_atacado(result.getDouble(SQLUtil.Item_Produto.COL_PORC_ATACADO));
				item_Produto.setPorc_varejo(result.getDouble(SQLUtil.Item_Produto.COL_PORC_VAREJO));
				
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

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.dao.IDaoItem_Produto#editar(br.com.sistemasupermercado.model.Item_Produto)
	 */
	@Override
	public void editar(Item_Produto item_Produto) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.dao.IDaoItem_Produto#ativarDesativar(int)
	 */
	@Override
	public void ativarDesativar(int id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	
}
