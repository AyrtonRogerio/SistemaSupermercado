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

import br.com.sistemasupermercado.enuns.FormaPagamento;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Cliente;
import br.com.sistemasupermercado.model.Endereco;
import br.com.sistemasupermercado.model.Funcionario;
import br.com.sistemasupermercado.model.Pagamento;
import br.com.sistemasupermercado.sql.SQLConections;
import br.com.sistemasupermercado.sql.SQLUtil;

/**
 * @author ayrton
 *
 */
public class DaoPagamento implements IDaoPagamento {

	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.sistemasupermercado.dao.IDaoPagamento#salvar(br.com.
	 * sistemasupermercado.model.Pagamento)
	 */
	@Override
	public void salvar(Pagamento pagamento) throws DaoException {
		// TODO Auto-generated method stub
		try {

			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Cliente.INSERT);
			this.statement.setString(1, pagamento.getFormaPagamento().getValor());
			this.statement.setFloat(2, pagamento.getValor());
			this.statement.setFloat(3, pagamento.getTroco());
			this.statement.setFloat(4, pagamento.getDesconto());

			statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.sistemasupermercado.dao.IDaoPagamento#buscarPorId(int)
	 */
	@Override
	public Pagamento buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		Pagamento pagamento;

		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Endereco.NOME_TABELA, id));
			this.result = this.statement.executeQuery();

			if (result.next()) {
				pagamento = new Pagamento();
				pagamento.setId(result.getInt(1));
				pagamento.setFormaPagamento(
						FormaPagamento.getFormaPagamento(result.getString(SQLUtil.Pagamento.COL_FORMA_PAGAMENTO)));
				pagamento.setValor(result.getFloat(SQLUtil.Pagamento.COL_VALOR));
				pagamento.setTroco(result.getFloat((SQLUtil.Pagamento.COL_TROCO)));
				pagamento.setDesconto(result.getFloat((SQLUtil.Pagamento.COL_DESCONTO)));
			}
			this.conexao.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.sistemasupermercado.dao.IDaoPagamento#getAll()
	 */
	@Override
	public List<Pagamento> getAll() throws DaoException {
		// TODO Auto-generated method stub
		List<Pagamento> pagamentos = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Pagamento.NOME_TABELA));
			this.result = this.statement.executeQuery();
			Pagamento pagamento;
			while (result.next()) {
				pagamento = new Pagamento();
				pagamento.setId(result.getInt(1));
				pagamento.setFormaPagamento(
				FormaPagamento.getFormaPagamento(result.getString(SQLUtil.Pagamento.COL_FORMA_PAGAMENTO)));
				pagamento.setValor(result.getFloat(SQLUtil.Pagamento.COL_VALOR));
				pagamento.setTroco(result.getFloat(SQLUtil.Pagamento.COL_TROCO));
				pagamento.setDesconto(result.getFloat(SQLUtil.Pagamento.COL_DESCONTO));
				pagamentos.add(pagamento);
			}
			this.conexao.close();
		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return pagamentos;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.sistemasupermercado.dao.IDaoPagamento#editar(br.com.
	 * sistemasupermercado.model.Pagamento)
	 */
	@Override
	public void editar(Pagamento pagamento) throws DaoException {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.sistemasupermercado.dao.IDaoPagamento#ativarDesativar(int)
	 */
	@Override
	public void ativarDesativar(int id) throws DaoException {
		// TODO Auto-generated method stub

	}

}
