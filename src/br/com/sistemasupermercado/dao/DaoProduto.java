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
import br.com.sistemasupermercado.model.Produto;
import br.com.sistemasupermercado.sql.SQLConections;
import br.com.sistemasupermercado.sql.SQLUtil;

public class DaoProduto implements IDaoProduto {

	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;

	@Override
	public int salvar(Produto produto) throws DaoException {
		// TODO Auto-generated method stub
		int id = 0;
		
		try {
			
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Produto.INSERT);
			this.statement.setString(1, produto.getNome());
			this.statement.setString(2, produto.getMarca());
			this.statement.setString(3, produto.getDescricao());
			this.result = this.statement.executeQuery();
			
			if(result.next()) {
				id = result.getInt(1);
			}
		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return id;
	}

	@Override
	public Produto buscarPorId(int id) throws DaoException {
		Produto produto = null;
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Produto.NOME_TABELA, id));
			this.result = this.statement.executeQuery();

			if (result.next()) {
				produto = new Produto();
				produto.setId(result.getInt(1));
				produto.setNome(result.getString(SQLUtil.Produto.NOME_PRODUTO));
				produto.setMarca(result.getString(SQLUtil.Produto.MARCA));
				produto.setDescricao(result.getString(SQLUtil.Produto.DESCRICAO));
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return produto;
	}

	@Override
	public List<Produto> getAll() throws DaoException {
		List<Produto> produtos = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Produto.NOME_TABELA));
			this.result = this.statement.executeQuery();
			Produto produto;
			while (result.next()) {
				produto = new Produto();
				produto.setId(result.getInt(1));
				produto.setNome(result.getString(SQLUtil.Produto.NOME_PRODUTO));
				produto.setMarca(result.getString(SQLUtil.Produto.MARCA));
				produto.setDescricao(result.getString(SQLUtil.Produto.DESCRICAO));
				produtos.add(produto);
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return produtos;
	}

	@Override
	public void editar(Produto produto) throws DaoException {
		// TODO Auto-generated method stub

		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Produto.UPDATE);
			this.statement.setString(1, produto.getNome());
			this.statement.setString(2, produto.getMarca());
			this.statement.setString(3, produto.getDescricao());

			this.statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ativarDesativar(int id) throws DaoException {
		// TODO Auto-generated method stub

	}

}
