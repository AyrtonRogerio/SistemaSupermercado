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
			this.statement.setString(4, funcionario.getLogin());
			this.statement.setString(5, funcionario.getSenha());
			statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
            throw new DaoException("Erro ao salvar o funcionário!");
		}

	}

	@Override
	public Funcionario buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		Funcionario funcionario = null;
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Funcionario.NOME_TABELA, id));
			this.result = this.statement.executeQuery();

			if (result.next()) {
				funcionario = new Funcionario();
				funcionario.setId(result.getInt(1));
				funcionario.setNome(result.getString(SQLUtil.Funcionario.COL_NOME));
				funcionario.setCpf(result.getString(SQLUtil.Funcionario.COL_CPF));
				funcionario.setCargo(result.getString(SQLUtil.Funcionario.COL_CARGO));
				funcionario.setLogin(result.getString(SQLUtil.Funcionario.COL_LOGIN));
				funcionario.setSenha(result.getString(SQLUtil.Funcionario.COL_SENHA));
//				System.out.println(funcionario.getNome());
//				System.out.println(funcionario.getCpf());
//				System.out.println(funcionario.getCargo());
//				System.out.println(funcionario.getLogin());
//				System.out.println(funcionario.getSenha());
			}
			this.conexao.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
            throw new DaoException("Erro ao buscar o funcionário!");
		}
		return funcionario;
	}

	@Override
	public List<Funcionario> getAll() throws DaoException {
		// TODO Auto-generated method stub
		List<Funcionario> funcionarios = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Funcionario.NOME_TABELA));
			this.result = this.statement.executeQuery();
			Funcionario funcionario;
			while (result.next()) {
				funcionario = new Funcionario();
				funcionario.setId(result.getInt(1));
				funcionario.setNome(result.getString(SQLUtil.Funcionario.COL_NOME));
				funcionario.setCpf(result.getString(SQLUtil.Funcionario.COL_CPF));
				funcionario.setCargo(result.getString(SQLUtil.Funcionario.COL_CARGO));
				funcionario.setLogin(result.getString(SQLUtil.Funcionario.COL_LOGIN));
				funcionario.setSenha(result.getString(SQLUtil.Funcionario.COL_SENHA));
				funcionarios.add(funcionario);
//				System.out.println(funcionario.getNome());
//				System.out.println(funcionario.getCpf());
//				System.out.println(funcionario.getCargo());
//				System.out.println(funcionario.getLogin());
//				System.out.println(funcionario.getSenha());
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
            throw new DaoException("Erro ao buscar todos os funcionário!");
		}
		return funcionarios;
	}

	@Override
	public void editar(Funcionario funcionario) throws DaoException {
		// TODO Auto-generated method stub
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Funcionario.UPDATE);
			this.statement.setString(1, funcionario.getNome());
			this.statement.setString(2, funcionario.getCpf());
			this.statement.setString(3, funcionario.getCargo());
			this.statement.setString(4, funcionario.getLogin());
			this.statement.setString(5, funcionario.getSenha());
			statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
            throw new DaoException("Erro ao editar o funcionário!");
		}
	}

	@Override
	public void ativarDesativar(int id) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public Funcionario buscarLogin(String login, String senha) throws DaoException {
		try {
			Funcionario func = null;
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Funcionario.SELECT_LOGIN);
			this.statement.setString(1, login);
			this.statement.setString(2, senha);
			this.result = this.statement.executeQuery();

			if (result.next()) {
				func = new Funcionario();
				func.setId(result.getInt(1));
				func.setNome(result.getString(SQLUtil.Funcionario.COL_NOME));
				func.setCpf(result.getString(SQLUtil.Funcionario.COL_CPF));
				func.setCargo(result.getString(SQLUtil.Funcionario.COL_CARGO));
				func.setLogin(result.getString(SQLUtil.Funcionario.COL_LOGIN));
				func.setSenha(result.getString(SQLUtil.Funcionario.COL_SENHA));

			}
			return func;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("Erro ao buscar funcionário! Login ou Senha incorretos");
		}

	}

}
