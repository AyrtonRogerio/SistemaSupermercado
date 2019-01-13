package br.com.sistemasupermercado.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Caixa;
import br.com.sistemasupermercado.model.Funcionario;
import br.com.sistemasupermercado.sql.SQLConections;
import br.com.sistemasupermercado.sql.SQLUtil;

public class DaoCaixa implements IDaoCaixa {

	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	
	@Override
	public void salvar(Caixa caixa, int funcionario_id) throws DaoException {
		// TODO Auto-generated method stub
		
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Caixa.INSERT);
			this.statement.setDouble(1, caixa.getEntrada());
			this.statement.setDouble(2, caixa.getSaida());
			this.statement.setDouble(3, caixa.getSaldo());
			this.statement.setInt(4, funcionario_id);
			this.statement.setDate(5, new java.sql.Date(caixa.getData_abertura().getTime()));
			this.statement.setDate(6, new java.sql.Date(caixa.getData_fechamento().getTime()));
			this.statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public Caixa buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		Caixa caixa = null;
		Funcionario funcionario = null;
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Caixa.NOME_TABELA, id));
			this.result = this.statement.executeQuery();

			if (result.next()) {
				caixa = new Caixa();
				caixa.setId(result.getInt(1));
				caixa.setEntrada(result.getDouble(SQLUtil.Caixa.COL_ENTRADA));
				caixa.setSaida(result.getDouble(SQLUtil.Caixa.COL_SAIDA));
				caixa.setSaldo(result.getDouble(SQLUtil.Caixa.COL_SALDO));
				funcionario = Fachada.getInstance().buscarPorIdFuncionario(result.getInt(SQLUtil.Caixa.COL_FUNCIONARIO));
				caixa.setFuncionario_id(funcionario);
				caixa.setData_abertura(new java.util.Date(result.getDate(SQLUtil.Caixa.COL_DATA_ABERTURA).getTime()));
				caixa.setData_fechamento(new java.util.Date(result.getDate(SQLUtil.Caixa.COL_DATA_FECHAMENTO).getTime()));
				
			}
			this.conexao.close();

		} catch (SQLException | BusinessException ex) {
			Logger.getLogger(DaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
		}
		return caixa;
	}

	@Override
	public Caixa buscarPorData(Date data) throws DaoException {
		// TODO Auto-generated method stub
		Caixa caixa = null;
		Funcionario funcionario = null;
		try {

			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Caixa.SELECT_DATA);
			this.statement.setDate(1, data);
			this.result = this.statement.executeQuery();

			if (result.next()) {
				caixa = new Caixa();
				caixa.setId(result.getInt(1));
				caixa.setEntrada(result.getDouble(SQLUtil.Caixa.COL_ENTRADA));
				caixa.setSaida(result.getDouble(SQLUtil.Caixa.COL_SAIDA));
				caixa.setSaldo(result.getDouble(SQLUtil.Caixa.COL_SALDO));
				funcionario = Fachada.getInstance().buscarPorIdFuncionario(result.getInt(SQLUtil.Caixa.COL_FUNCIONARIO));
				caixa.setFuncionario_id(funcionario);
				caixa.setData_abertura(new java.util.Date(result.getDate(SQLUtil.Caixa.COL_DATA_ABERTURA).getTime()));
				caixa.setData_fechamento(new java.util.Date(result.getDate(SQLUtil.Caixa.COL_DATA_FECHAMENTO).getTime()));

			}
			this.conexao.close();

		} catch (SQLException | BusinessException ex) {
			Logger.getLogger(DaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
		}
		return caixa;
	}

	@Override
	public Caixa buscarPorAnterior() throws DaoException {
		// TODO Auto-generated method stub
		Caixa caixa = null;
		Funcionario funcionario = null;
		try {

			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Caixa.SELECT_ANTERIOR);
			this.result = this.statement.executeQuery();

			if (result.next()) {
				caixa = new Caixa();
				caixa.setId(result.getInt(1));
				caixa.setEntrada(result.getDouble(SQLUtil.Caixa.COL_ENTRADA));
				caixa.setSaida(result.getDouble(SQLUtil.Caixa.COL_SAIDA));
				caixa.setSaldo(result.getDouble(SQLUtil.Caixa.COL_SALDO));
				funcionario = Fachada.getInstance().buscarPorIdFuncionario(result.getInt(SQLUtil.Caixa.COL_FUNCIONARIO));
				caixa.setFuncionario_id(funcionario);
				caixa.setData_abertura(new java.util.Date(result.getDate(SQLUtil.Caixa.COL_DATA_ABERTURA).getTime()));
				caixa.setData_fechamento(new java.util.Date(result.getDate(SQLUtil.Caixa.COL_DATA_FECHAMENTO).getTime()));

			}
			this.conexao.close();

		} catch (SQLException | BusinessException ex) {
			Logger.getLogger(DaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
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
			Funcionario funcionario;
			while (result.next()) {
				caixa = new Caixa();
				caixa.setId(result.getInt(1));
				caixa.setEntrada(result.getDouble(SQLUtil.Caixa.COL_ENTRADA));
				caixa.setSaida(result.getDouble(SQLUtil.Caixa.COL_SAIDA));
				caixa.setSaldo(result.getDouble(SQLUtil.Caixa.COL_SALDO));
				funcionario = Fachada.getInstance().buscarPorIdFuncionario(result.getInt(SQLUtil.Caixa.COL_FUNCIONARIO));
				caixa.setFuncionario_id(funcionario);
				caixa.setData_abertura(new java.util.Date(result.getDate(SQLUtil.Caixa.COL_DATA_ABERTURA).getTime()));
				caixa.setData_fechamento(new java.util.Date(result.getDate(SQLUtil.Caixa.COL_DATA_FECHAMENTO).getTime()));
				caixas.add(caixa);
			}
			this.conexao.close();

		} catch (SQLException | BusinessException ex) {
			Logger.getLogger(DaoCaixa.class.getName()).log(Level.SEVERE, null, ex);
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
