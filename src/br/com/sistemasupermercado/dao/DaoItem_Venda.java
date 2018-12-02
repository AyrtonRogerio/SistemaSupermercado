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
			this.statement = this.conexao.prepareStatement(SQLUtil.Produto.INSERT);
			this.statement.setString(1, item_Venda.getNome());
			this.statement.setString(2, item_Venda.getMarca());
			this.statement.setString(3, item_Venda.getDescricao());
			statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public Item_Venda buscarPorId(int id) throws DaoException {
		Item_Venda item_Venda = null;
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Produto.NOME_TABELA, id));
			this.result = this.statement.executeQuery();

			if (result.next()) {
				item_Venda = new Produto();
				item_Venda.setId(result.getInt(1));
				item_Venda.setNome(result.getString(SQLUtil.Produto.NOME_PRODUTO));
				item_Venda.setMarca(result.getString(SQLUtil.Produto.MARCA));
				item_Venda.setDescricao(result.getString(SQLUtil.Produto.DESCRICAO));
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return item_Venda;
	}

	@Override
	public List<Item_Venda> getAll() throws DaoException {
		List<Item_Venda> item_Vendas = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Produto.NOME_TABELA));
			this.result = this.statement.executeQuery();
			Item_Venda item_Venda;
			while (result.next()) {
				item_Venda = new Item_Venda();
				item_Venda.setId(result.getInt(1));
				item_Venda.setNome(result.getString(SQLUtil.Produto.NOME_PRODUTO));
				item_Venda.setMarca(result.getString(SQLUtil.Produto.MARCA));
				item_Venda.setDescricao(result.getString(SQLUtil.Produto.DESCRICAO));
				item_Vendas.add(item_Venda);
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
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
