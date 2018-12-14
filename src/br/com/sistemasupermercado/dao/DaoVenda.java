/**
 * 
 */
package br.com.sistemasupermercado.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Item_Venda;
import br.com.sistemasupermercado.model.Venda;
import br.com.sistemasupermercado.sql.SQLConections;
import br.com.sistemasupermercado.sql.SQLUtil;

/**
 * @author ayrton
 *
 */
public class DaoVenda implements IDaoVenda{

	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;
	
	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.dao.IDaoVenda#salvar(br.com.sistemasupermercado.model.Venda)
	 */
	@Override
	public void salvar(Venda venda) throws DaoException {
		// TODO Auto-generated method stub
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Venda.INSERT);
			this.statement.setDouble(1, venda.getDesc_geral());
			this.statement.setInt(2, venda.getQuant_parc());
			this.statement.setDouble(3, venda.getValor_total());
			this.statement.setDate(3, new java.sql.Date(venda.getData_venda().getTime()));
			this.statement.setInt(3, venda.getPagamento_id());
			this.statement.setInt(3, venda.getCliente_id());
			this.statement.setInt(3, venda.getFuncionario_id());
			statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoVenda.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.dao.IDaoVenda#buscarPorId(int)
	 */
	@Override
	public Venda buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		Venda venda = null;
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Venda.NOME_TABELA, id));
			this.result = this.statement.executeQuery();

			if (result.next()) {
				venda = new Venda();
				venda.setId(result.getInt(1));
				venda.setDesc_geral((result.getDouble(SQLUtil.Venda.COL_DESC_GERAL)));
				venda.setQuant_parc(result.getInt(SQLUtil.Venda.COL_QUANT_PARC));
				venda.setValor_total(result.getDouble(SQLUtil.Venda.COL_VALOR_TOTAL));
				venda.setData_venda(new Date(result.getDate(SQLUtil.Venda.COL_DATA_VENDA).getTime()));
				venda.setPagamento_id(result.getInt(SQLUtil.Venda.COL_PAGAMENTO_ID));
				venda.setCliente_id(result.getInt(SQLUtil.Venda.COL_CLIENTE_ID));
				venda.setFuncionario_id(result.getInt(SQLUtil.Venda.COL_FUNCIONARIO_ID));
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoVenda.class.getName()).log(Level.SEVERE, null, ex);
		}
		return venda;
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.dao.IDaoVenda#getAll()
	 */
	@Override
	public List<Venda> getAll() throws DaoException {
		// TODO Auto-generated method stub
		List<Venda> vendas = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Produto.NOME_TABELA));
			this.result = this.statement.executeQuery();
			Venda venda;
			while (result.next()) {
				venda = new Venda();
				venda.setId(result.getInt(1));
				venda.setDesc_geral((result.getDouble(SQLUtil.Venda.COL_DESC_GERAL)));
				venda.setQuant_parc(result.getInt(SQLUtil.Venda.COL_QUANT_PARC));
				venda.setValor_total(result.getDouble(SQLUtil.Venda.COL_VALOR_TOTAL));
				venda.setData_venda(new Date(result.getDate(SQLUtil.Venda.COL_DATA_VENDA).getTime()));
				venda.setPagamento_id(result.getInt(SQLUtil.Venda.COL_PAGAMENTO_ID));
				venda.setCliente_id(result.getInt(SQLUtil.Venda.COL_CLIENTE_ID));
				venda.setFuncionario_id(result.getInt(SQLUtil.Venda.COL_FUNCIONARIO_ID));
				vendas.add(venda);
			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
		}
		return vendas;
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.dao.IDaoVenda#editar(br.com.sistemasupermercado.model.Venda)
	 */
	@Override
	public void editar(Venda venda) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.dao.IDaoVenda#ativarDesativar(int)
	 */
	@Override
	public void ativarDesativar(int id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}