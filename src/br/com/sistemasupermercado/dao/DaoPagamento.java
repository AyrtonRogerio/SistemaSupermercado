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

import br.com.sistemasupermercado.enuns.FormaPagamento;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Cliente;
import br.com.sistemasupermercado.model.Pagamento;
import br.com.sistemasupermercado.model.Venda;
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
	public void salvar(Pagamento pagamento, int id_cliente, int id_venda) throws DaoException {
		// TODO Auto-generated method stub


		try {

			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Cliente.INSERT);
			this.statement.setDouble(1, pagamento.getValor());
			this.statement.setDate(2, new java.sql.Date(pagamento.getData_vencimento().getTime()));
			this.statement.setInt(3, pagamento.getNumero());
			this.statement.setString(4, pagamento.getFormaPagamento().getValor());
			this.statement.setInt(5, id_cliente);
			this.statement.setInt(6, id_venda);
			this.statement.setBoolean(7, pagamento.isStatus());

			statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoPagamento.class.getName()).log(Level.SEVERE, null, ex);
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
		Cliente cliente = null;
		Venda venda = null;

		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Endereco.NOME_TABELA, id));
			this.result = this.statement.executeQuery();


			if (result.next()) {
				pagamento = new Pagamento();

				pagamento.setId(result.getInt(1));

				pagamento.setValor(result.getDouble(SQLUtil.Pagamento.COL_VALOR));
				pagamento.setData_vencimento( new Date(result.getDate(SQLUtil.Pagamento.COL_DATA_VENCIMENTO).getTime()));
				pagamento.setNumero(result.getInt(result.getString(SQLUtil.Pagamento.COL_NUMERO)));
				pagamento.setFormaPagamento(FormaPagamento.getFormaPagamento
						(result.getString(SQLUtil.Pagamento.COL_FORMA_PAGAMENTO)));
				cliente = Fachada.getInstance().buscarPorIdCliente(result.getInt(SQLUtil.Pagamento.COL_CLIENTE_ID));
				pagamento.setCliente_id(cliente);

				venda = Fachada.getInstance().buscarPorIdVenda(result.getInt(SQLUtil.Pagamento.COL_VENDA_ID));
				pagamento.setVenda_id(venda);

				pagamento.setStatus(result.getBoolean(SQLUtil.Pagamento.COL_STATUS));

			}
			this.conexao.close();

		} catch (SQLException | BusinessException e) {
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
		Pagamento pagamento;
		Cliente cliente = null;
		Venda venda = null;

		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Pagamento.NOME_TABELA));
			this.result = this.statement.executeQuery();

			while (result.next()) {
				pagamento = new Pagamento();
				pagamento.setId(result.getInt(1));
				pagamento.setValor(result.getDouble(SQLUtil.Pagamento.COL_VALOR));
				pagamento.setData_vencimento( new Date(result.getDate(SQLUtil.Pagamento.COL_DATA_VENCIMENTO).getTime()));
				pagamento.setNumero(result.getInt(result.getString(SQLUtil.Pagamento.COL_NUMERO)));
				pagamento.setFormaPagamento(FormaPagamento.getFormaPagamento
						(result.getString(SQLUtil.Pagamento.COL_FORMA_PAGAMENTO)));
				 cliente = Fachada.getInstance().buscarPorIdCliente(result.getInt(SQLUtil.Pagamento.COL_CLIENTE_ID));
				pagamento.setCliente_id(cliente);
				venda = Fachada.getInstance().buscarPorIdVenda(result.getInt(SQLUtil.Pagamento.COL_VENDA_ID));
				pagamento.setVenda_id(venda);
				pagamento.setStatus(result.getBoolean(SQLUtil.Pagamento.COL_STATUS));

				pagamentos.add(pagamento);
			}
			this.conexao.close();
		} catch (SQLException | BusinessException ex) {
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

		try {

			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Cliente.UPDATE);
			this.statement.setDouble(1, pagamento.getValor());
			this.statement.setDate(2, new java.sql.Date(pagamento.getData_vencimento().getTime()));
			this.statement.setInt(3, pagamento.getNumero());
			this.statement.setString(4, pagamento.getFormaPagamento().getValor());
			this.statement.setBoolean(5, pagamento.isStatus());

			statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoPagamento.class.getName()).log(Level.SEVERE, null, ex);
		}

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
