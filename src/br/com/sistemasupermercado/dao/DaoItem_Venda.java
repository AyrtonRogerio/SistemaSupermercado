/**
 * 
 */
package br.com.sistemasupermercado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Item_Venda;
import br.com.sistemasupermercado.sql.SQLConections;
import br.com.sistemasupermercado.sql.SQLUtil;

/**
 * @author ayrton
 *
 */
public class DaoItem_Venda implements IDaoItem_Venda{

	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;

	@Override
	public void salvar(Item_Venda item_Venda) throws DaoException {
		// TODO Auto-generated method stub

		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Item_Venda.INSERT);
			this.statement.setDouble(1, item_Venda.getValor_desc());
			this.statement.setDouble(2, item_Venda.getProc_promoc());
			this.statement.setBoolean(3, item_Venda.isPromocao());
			this.statement.setString(4, item_Venda.getTipo());
			this.statement.setInt(5, item_Venda.getQuantidade());
			this.statement.setDouble(6, item_Venda.getValor_item());
			this.statement.setBoolean(7, item_Venda.isDesconto());
//			this.statement.setInt(8, item_Venda.getVenda_id());
//			this.statement.setInt(9, item_Venda.getItem_produto_id());
			statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoItem_Venda.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public Item_Venda buscarPorId(int id) throws DaoException {
		Item_Venda item_Venda = null;
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Item_Venda.NOME_TABELA, id));
			this.result = this.statement.executeQuery();

			if (result.next()) {
				item_Venda = new Item_Venda();
				item_Venda.setId(result.getInt(1));
				item_Venda.setValor_desc(result.getDouble(SQLUtil.Item_Venda.COL_VALOR_DESC));
				item_Venda.setProc_promoc(result.getDouble(SQLUtil.Item_Venda.COL_PORC_PROMOC));
				item_Venda.setPromocao(result.getBoolean(SQLUtil.Item_Venda.COL_PROMOCAO));
				item_Venda.setTipo(result.getString(SQLUtil.Item_Venda.COL_TIPO));
				item_Venda.setQuantidade(result.getInt(SQLUtil.Item_Venda.COL_QUANT));
				item_Venda.setValor_item(result.getDouble(SQLUtil.Item_Venda.COL_VALOR_ITEM));
				item_Venda.setDesconto(result.getBoolean(SQLUtil.Item_Venda.COL_DESCONTO));
//				item_Venda.setVenda_id(result.getInt(SQLUtil.Item_Venda.COL_VENDA_ID));
//				item_Venda.setItem_produto_id(result.getInt(SQLUtil.Item_Venda.COL_ITEM_PRODUTO_ID));
				
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoItem_Venda.class.getName()).log(Level.SEVERE, null, ex);
		}
		return item_Venda;
	}

	@Override
	public List<Item_Venda> getAll() throws DaoException {
		List<Item_Venda> item_Vendas = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Item_Venda.NOME_TABELA));
			this.result = this.statement.executeQuery();
			Item_Venda item_Venda;
			while (result.next()) {
				item_Venda = new Item_Venda();
				item_Venda.setId(result.getInt(1));
				item_Venda.setId(result.getInt(1));
				item_Venda.setValor_desc(result.getDouble(SQLUtil.Item_Venda.COL_VALOR_DESC));
				item_Venda.setProc_promoc(result.getDouble(SQLUtil.Item_Venda.COL_PORC_PROMOC));
				item_Venda.setPromocao(result.getBoolean(SQLUtil.Item_Venda.COL_PROMOCAO));
				item_Venda.setTipo(result.getString(SQLUtil.Item_Venda.COL_TIPO));
				item_Venda.setQuantidade(result.getInt(SQLUtil.Item_Venda.COL_QUANT));
				item_Venda.setValor_item(result.getDouble(SQLUtil.Item_Venda.COL_VALOR_ITEM));
				item_Venda.setDesconto(result.getBoolean(SQLUtil.Item_Venda.COL_DESCONTO));
//				item_Venda.setVenda_id(result.getInt(SQLUtil.Item_Venda.COL_VENDA_ID));
//				item_Venda.setItem_produto_id(result.getInt(SQLUtil.Item_Venda.COL_ITEM_PRODUTO_ID));
				item_Vendas.add(item_Venda);
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoItem_Venda.class.getName()).log(Level.SEVERE, null, ex);
		}
		return item_Vendas;
	}

	@Override
	public void editar(Item_Venda item_Venda) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ativarDesativar(int id) throws DaoException {
		// TODO Auto-generated method stub

	}
	
}
