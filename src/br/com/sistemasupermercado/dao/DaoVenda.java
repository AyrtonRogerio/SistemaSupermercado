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

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.*;
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
	public int salvar(Venda venda, int id_cliente, int id_funcionario, int id_caixa) throws DaoException {
		// TODO Auto-generated method stub
		int id = 0;
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Venda.INSERT);
			this.statement.setDouble(1, venda.getValor_total());
			this.statement.setDouble(2, venda.getDesc_geral());
			this.statement.setDouble(3, venda.getValor_troco());
			this.statement.setDouble(4, venda.getValor_recebido());
			this.statement.setDate(5, new java.sql.Date(venda.getData_venda().getTime()));
			this.statement.setInt(6, id_cliente);
			this.statement.setInt(7, id_funcionario);
			this.statement.setInt(8,id_caixa);

			this.result = this.statement.executeQuery();

			if(this.result.next()){
				id = this.result.getInt(1);
			}

		} catch (SQLException ex) {
			Logger.getLogger(DaoVenda.class.getName()).log(Level.SEVERE, null, ex);
		}
		return  id;
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.dao.IDaoVenda#buscarPorId(int)
	 */
	@Override
	public Venda buscarPorId(int id) throws DaoException {
		// TODO Auto-generated method stub
		Venda venda = null;

		Cliente cliente = null;
		Funcionario funcionario = null;
		Caixa caixa = null;

		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Venda.NOME_TABELA, id));
			this.result = this.statement.executeQuery();

			if (result.next()) {
				venda = new Venda();
				venda.setId(result.getInt(1));
				venda.setValor_total(result.getDouble(SQLUtil.Venda.COL_VALOR_TOTAL));
				venda.setDesc_geral(result.getDouble(SQLUtil.Venda.COL_DESC_GERAL));
				venda.setValor_troco(result.getDouble(SQLUtil.Venda.COL_VALOR_TROCO));
				venda.setValor_recebido(result.getDouble(SQLUtil.Venda.COL_VALOR_RECEBIDO));
				venda.setData_venda(new Date(result.getDate(SQLUtil.Venda.COL_DATA_VENDA).getTime()));


				cliente = Fachada.getInstance().buscarPorIdCliente(result.getInt(SQLUtil.Venda.COL_CLIENTE_ID));
				funcionario = Fachada.getInstance().buscarPorIdFuncionario(result.getInt(SQLUtil.Venda.COL_FUNCIONARIO_ID));
				caixa = Fachada.getInstance().buscarPorIdCaixa(result.getInt(SQLUtil.Venda.COL_CAIXA_ID));


				venda.setCliente_id(cliente);
				venda.setFuncionario_id(funcionario);
				venda.setCaixa_id(caixa);


			}
			this.conexao.close();

		} catch (SQLException | BusinessException ex) {
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
		Venda venda = null;

		Cliente cliente = null;
		Funcionario funcionario = null;
		Caixa caixa = null;

		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Produto.NOME_TABELA));
			this.result = this.statement.executeQuery();

			while (result.next()) {

				venda = new Venda();
				venda.setId(result.getInt(1));
				venda.setValor_total(result.getDouble(SQLUtil.Venda.COL_VALOR_TOTAL));
				venda.setDesc_geral(result.getDouble(SQLUtil.Venda.COL_DESC_GERAL));
				venda.setValor_troco(result.getDouble(SQLUtil.Venda.COL_VALOR_TROCO));
				venda.setValor_recebido(result.getDouble(SQLUtil.Venda.COL_VALOR_RECEBIDO));
				venda.setData_venda(new Date(result.getDate(SQLUtil.Venda.COL_DATA_VENDA).getTime()));

				cliente = Fachada.getInstance().buscarPorIdCliente(result.getInt(SQLUtil.Venda.COL_CLIENTE_ID));
				funcionario = Fachada.getInstance().buscarPorIdFuncionario(result.getInt(SQLUtil.Venda.COL_FUNCIONARIO_ID));
				caixa = Fachada.getInstance().buscarPorIdCaixa(result.getInt(SQLUtil.Venda.COL_CAIXA_ID));

				venda.setCliente_id(cliente);
				venda.setFuncionario_id(funcionario);
				venda.setCaixa_id(caixa);
				vendas.add(venda);
			}
			this.conexao.close();

		} catch (SQLException | BusinessException ex) {
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
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Venda.UPDATE);
			this.statement.setDouble(1, venda.getValor_total());
			this.statement.setDouble(2, venda.getDesc_geral());
			this.statement.setDouble(4, venda.getValor_troco());
			this.statement.setDouble(5, venda.getValor_recebido());
			this.statement.setDate(6, new java.sql.Date(venda.getData_venda().getTime()));
			this.statement.execute();
		} catch (SQLException ex) {
			Logger.getLogger(DaoVenda.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/* (non-Javadoc)
	 * @see br.com.sistemasupermercado.dao.IDaoVenda#ativarDesativar(int)
	 */
	@Override
	public void ativarDesativar(int id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
