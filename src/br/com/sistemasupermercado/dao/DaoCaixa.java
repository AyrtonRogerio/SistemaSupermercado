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
import br.com.sistemasupermercado.model.Caixa;
import br.com.sistemasupermercado.sql.SQLConections;
import br.com.sistemasupermercado.sql.SQLUtil;

public class DaoCaixa implements IDaoCaixa {

	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	
	@Override
	public void salvar(Caixa caixa) throws DaoException {
		// TODO Auto-generated method stub
		
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Caixa.INSERT);
			this.statement.setDouble(1, caixa.getEntrada());
			this.statement.setDouble(2, caixa.getSaida());
			this.statement.setDouble(3, caixa.getSaldo());
			statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public Caixa buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		Caixa caixa = null;
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Endereco.NOME_TABELA, id));
//			statement.setInt(1, id);
			this.result = this.statement.executeQuery();

			if (result.next()) {
				caixa = new Caixa();
				caixa.setId(result.getInt(1));
				caixa.setEntrada(result.getDouble(SQLUtil.Caixa.COL_ENTRADA));
				caixa.setSaida(result.getDouble(SQLUtil.Caixa.COL_SAIDA));
				caixa.setSaldo(result.getDouble(SQLUtil.Caixa.COL_SALDO));
				
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return caixa;
	}

	@Override
	public List<Caixa> getAll() throws DaoException {
		// TODO Auto-generated method stub
		List<Caixa> caixas = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Endereco.NOME_TABELA));
			this.result = this.statement.executeQuery();
			Caixa caixa;
			while (result.next()) {
				caixa = new Caixa();
				caixa.setId(result.getInt(1));
				caixa.setEntrada(result.getDouble(SQLUtil.Caixa.COL_ENTRADA));
				caixa.setSaida(result.getDouble(SQLUtil.Caixa.COL_SAIDA));
				caixa.setSaldo(result.getDouble(SQLUtil.Caixa.COL_SALDO));
				caixas.add(caixa);
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return caixas;
	}

	@Override
	public void editar(Caixa caixa) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ativarDesativar(int id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
