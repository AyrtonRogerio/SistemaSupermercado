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
import br.com.sistemasupermercado.model.Endereco;
import br.com.sistemasupermercado.sql.SQLConections;
import br.com.sistemasupermercado.sql.SQLUtil;

public class DaoEndereco implements IDaoEndereco {

	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	@Override
	public void salvar(Endereco endereco) throws DaoException {
		// TODO Auto-generated method stub

		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Endereco.INSERT);
			this.statement.setString(1, endereco.getCep());
			this.statement.setString(2, endereco.getRua());
			this.statement.setString(3, endereco.getNumero());
			this.statement.setString(4, endereco.getBairro());
			this.statement.setString(5, endereco.getEstado());
			statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public Endereco buscarPorId(int id) throws DaoException {
		Endereco endereco = null;
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Endereco.NOME_TABELA, id));
//			statement.setInt(1, id);
			this.result = this.statement.executeQuery();

			if (result.next()) {
				endereco = new Endereco();
				endereco.setId(result.getInt(1));
				endereco.setCep(result.getString(SQLUtil.Endereco.COL_CEP));
				endereco.setRua(result.getString(SQLUtil.Endereco.COL_RUA));
				endereco.setNumero(result.getString(SQLUtil.Endereco.COL_NUMERO));
				endereco.setBairro(result.getString(SQLUtil.Endereco.COL_BAIRRO));
				endereco.setEstado(result.getString(SQLUtil.Endereco.COL_ESTADO));
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return endereco;
	}

	@Override
	public List<Endereco> getAll() throws DaoException {
		List<Endereco> enderecos = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Endereco.NOME_TABELA));
			this.result = this.statement.executeQuery();
			Endereco endereco;
			while (result.next()) {
				endereco = new Endereco();
				endereco.setId(result.getInt(1));
				endereco.setCep(result.getString(SQLUtil.Endereco.COL_CEP));
				endereco.setRua(result.getString(SQLUtil.Endereco.COL_RUA));
				endereco.setNumero(result.getString(SQLUtil.Endereco.COL_NUMERO));
				endereco.setBairro(result.getString(SQLUtil.Endereco.COL_BAIRRO));
				endereco.setEstado(result.getString(SQLUtil.Endereco.COL_ESTADO));
				enderecos.add(endereco);
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return enderecos;
	}

	@Override
	public void editar(Endereco endereco) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ativarDesativar(int id) throws DaoException {
		// TODO Auto-generated method stub

	}

}
