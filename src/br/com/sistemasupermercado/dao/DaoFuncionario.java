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
import br.com.sistemasupermercado.model.Funcionario;
import br.com.sistemasupermercado.sql.SQLConections;
import br.com.sistemasupermercado.sql.SQLUtil;

public class DaoFuncionario implements IDaoFuncionario {

	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	
	@Override
	public void salvar(Funcionario funcionario) throws DaoException {
		// TODO Auto-generated method stub
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Funcionario.INSERT);
			this.statement.setString(1, funcionario.getNome());
			this.statement.setString(2, funcionario.getCpf());
			this.statement.setString(3, funcionario.getCargo());
			statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	@Override
	public Funcionario buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		Funcionario funcionario = null;
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Endereco.NOME_TABELA, id));
//			statement.setInt(1, id);
			this.result = this.statement.executeQuery();

			if (result.next()) {
				funcionario = new Funcionario();
				funcionario.setId(result.getInt(1));
				funcionario.setNome(result.getString(SQLUtil.Funcionario.COL_NOME));
				funcionario.setCpf(result.getString(SQLUtil.Funcionario.COL_CPF));
				funcionario.setCargo(result.getString(SQLUtil.Funcionario.COL_CARGO));
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return funcionario;
	}

	@Override
	public List<Funcionario> getAll() throws DaoException {
		// TODO Auto-generated method stub
		List<Funcionario> funcionarios = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Endereco.NOME_TABELA));
			this.result = this.statement.executeQuery();
			Funcionario funcionario;
			while (result.next()) {
				funcionario = new Funcionario();
				funcionario.setId(result.getInt(1));
				funcionario.setNome(result.getString(SQLUtil.Funcionario.COL_NOME));
				funcionario.setCpf(result.getString(SQLUtil.Funcionario.COL_CPF));
				funcionario.setCargo(result.getString(SQLUtil.Funcionario.COL_CARGO));
				funcionarios.add(funcionario);
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return funcionarios;
	}

	@Override
	public void editar(Funcionario funcionario) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ativarDesativar(int id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}