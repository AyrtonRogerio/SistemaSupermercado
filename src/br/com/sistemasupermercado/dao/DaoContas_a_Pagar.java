package br.com.sistemasupermercado.dao;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Caixa;
import br.com.sistemasupermercado.model.Contas_a_Pagar_Adapter;
import br.com.sistemasupermercado.model.Contas_a_pagar;
import br.com.sistemasupermercado.model.Contas_a_receber;
import br.com.sistemasupermercado.model.Fornecedor;
import br.com.sistemasupermercado.model.RelatorioFinanceiro;
import br.com.sistemasupermercado.model.Venda;
import br.com.sistemasupermercado.sql.SQLConections;
import br.com.sistemasupermercado.sql.SQLUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoContas_a_Pagar implements IDaoContas_a_Pagar {

	private Connection conexao;
	private PreparedStatement statement;
	private ResultSet result;

	@Override
	public void salvar(Contas_a_pagar contas_a_pagar, int caixa_id, int fornecedor_id) throws DaoException {

		try {

			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Contas_a_Pagar.INSERT);
			this.statement.setString(1, contas_a_pagar.getDescricao());
			this.statement.setDouble(2, contas_a_pagar.getValor());
			this.statement.setDouble(3, contas_a_pagar.getValor_quitado());
			this.statement.setInt(4, contas_a_pagar.getQtd_pgmt());
			this.statement.setInt(5, contas_a_pagar.getQtd_paga());
			this.statement.setDate(6, new java.sql.Date(contas_a_pagar.getData_pagamento().getTime()));
			this.statement.setDate(7, new java.sql.Date(contas_a_pagar.getData_vencimento().getTime()));
			this.statement.setInt(8, caixa_id);
			this.statement.setInt(9, fornecedor_id);
			this.statement.setBoolean(10, contas_a_pagar.isStatus());

			this.statement.execute();

		} catch (SQLException ex) {
			Logger.getLogger(DaoContas_a_Pagar.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			throw new DaoException("Erro ao salvar conta a pagar!");
		}

	}

	@Override
	public Contas_a_pagar buscarPorId(int id) throws DaoException {
		Contas_a_pagar contas_a_pagar = null;
		Caixa caixa = null;
		Fornecedor fornecedor = null;
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Contas_a_Pagar.NOME_TABELA, id));
			this.result = this.statement.executeQuery();

			if (result.next()) {
				contas_a_pagar = new Contas_a_pagar();
				contas_a_pagar.setId(result.getInt(1));
				contas_a_pagar.setDescricao(result.getString(SQLUtil.Contas_a_Pagar.COL_DESCRICAO));
				contas_a_pagar.setValor(result.getDouble(SQLUtil.Contas_a_Pagar.COL_VALOR));
				contas_a_pagar.setValor_quitado(result.getDouble(SQLUtil.Contas_a_Pagar.COL_VALOR_QUITADO));
				contas_a_pagar.setQtd_pgmt(result.getInt(SQLUtil.Contas_a_Pagar.COL_QTD_PGMT));
				contas_a_pagar.setQtd_paga(result.getInt(SQLUtil.Contas_a_Pagar.COL_QTD_PAGA));
				contas_a_pagar.setData_pagamento(
						new java.util.Date(result.getDate(SQLUtil.Contas_a_Pagar.COL_DATA_PAG).getTime()));
				contas_a_pagar.setData_vencimento(
						new java.util.Date(result.getDate(SQLUtil.Contas_a_Pagar.COL_DATA_VENC).getTime()));
				caixa = Fachada.getInstance().buscarPorIdCaixa(result.getInt(SQLUtil.Contas_a_Pagar.COL_CAIXA_ID));
				contas_a_pagar.setCaixa_id(caixa);
				fornecedor = Fachada.getInstance()
						.buscarPorIdFornecedor(result.getInt(SQLUtil.Contas_a_Pagar.COL_FORNEC_ID));
				contas_a_pagar.setFornecedor_id(fornecedor);
				contas_a_pagar.setStatus(result.getBoolean(SQLUtil.Contas_a_Pagar.COL_STATUS));

			}
			this.conexao.close();

		} catch (SQLException | BusinessException ex) {
			Logger.getLogger(DaoContas_a_Pagar.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			throw new DaoException("Erro ao buscar conta a pagar!");
		}
		return contas_a_pagar;
	}

	@Override
	public List<Contas_a_Pagar_Adapter> getAll() throws DaoException {
		List<Contas_a_Pagar_Adapter> contas_a_Pagar_Adapters = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Contas_a_Pagar.SELECT_ALL_ADAPTER);
			this.result = this.statement.executeQuery();
			Contas_a_Pagar_Adapter contas_a_Pagar_Adapter;
			while (result.next()) {
				contas_a_Pagar_Adapter = new Contas_a_Pagar_Adapter();
				contas_a_Pagar_Adapter.setId(result.getInt(1));
				contas_a_Pagar_Adapter.setDescricao(result.getString(SQLUtil.Contas_a_Pagar.COL_DESCRICAO));
				contas_a_Pagar_Adapter.setValor(result.getDouble(SQLUtil.Contas_a_Pagar.COL_VALOR));
				contas_a_Pagar_Adapter.setValor_quitado(result.getDouble(SQLUtil.Contas_a_Pagar.COL_VALOR_QUITADO));
				contas_a_Pagar_Adapter.setQtd_pgmt(result.getInt(SQLUtil.Contas_a_Pagar.COL_QTD_PGMT));
				contas_a_Pagar_Adapter.setQtd_paga(result.getInt(SQLUtil.Contas_a_Pagar.COL_QTD_PAGA));
				contas_a_Pagar_Adapter.setData_vencimento(
						new java.util.Date(result.getDate(SQLUtil.Contas_a_Pagar.COL_DATA_VENC).getTime()));

				contas_a_Pagar_Adapters.add(contas_a_Pagar_Adapter);

			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoContas_a_Pagar.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			throw new DaoException("Erro ao buscar todas as contas a pagar!");
		}
		return contas_a_Pagar_Adapters;
	}

	@Override
	public List<Contas_a_Pagar_Adapter> getAllHistorico(String busca) throws DaoException {
		List<Contas_a_Pagar_Adapter> contas_a_Pagar_Adapters = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Contas_a_Pagar.SELECT_ALL_ADAPTER);
			this.result = this.statement.executeQuery();
			Contas_a_Pagar_Adapter contas_a_Pagar_Adapter;
			while (result.next()) {
				contas_a_Pagar_Adapter = new Contas_a_Pagar_Adapter();
				contas_a_Pagar_Adapter.setId(result.getInt(1));
				contas_a_Pagar_Adapter.setDescricao(result.getString(SQLUtil.Contas_a_Pagar.COL_DESCRICAO));
				contas_a_Pagar_Adapter.setValor(result.getDouble(SQLUtil.Contas_a_Pagar.COL_VALOR));
				contas_a_Pagar_Adapter.setValor_quitado(result.getDouble(SQLUtil.Contas_a_Pagar.COL_VALOR_QUITADO));
				contas_a_Pagar_Adapter.setQtd_pgmt(result.getInt(SQLUtil.Contas_a_Pagar.COL_QTD_PGMT));
				contas_a_Pagar_Adapter.setQtd_paga(result.getInt(SQLUtil.Contas_a_Pagar.COL_QTD_PAGA));
				contas_a_Pagar_Adapter.setData_vencimento(
						new java.util.Date(result.getDate(SQLUtil.Contas_a_Pagar.COL_DATA_VENC).getTime()));

				contas_a_Pagar_Adapters.add(contas_a_Pagar_Adapter);

			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoContas_a_Pagar.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			throw new DaoException("Erro ao buscar histórico de contas a pagar!");
		}
		return contas_a_Pagar_Adapters;
	}

	@Override
	public List<Contas_a_Pagar_Adapter> getAll_Paga() throws DaoException {
		List<Contas_a_Pagar_Adapter> contas_a_Pagar_Adapters = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Contas_a_Pagar.SELECT_PAGA_ADAPTER);
			this.result = this.statement.executeQuery();
			Contas_a_Pagar_Adapter contas_a_Pagar_Adapter;
			while (result.next()) {
				contas_a_Pagar_Adapter = new Contas_a_Pagar_Adapter();
				contas_a_Pagar_Adapter.setId(result.getInt(1));
				contas_a_Pagar_Adapter.setDescricao(result.getString(SQLUtil.Contas_a_Pagar.COL_DESCRICAO));
				contas_a_Pagar_Adapter.setValor(result.getDouble(SQLUtil.Contas_a_Pagar.COL_VALOR));
				contas_a_Pagar_Adapter.setValor_quitado(result.getDouble(SQLUtil.Contas_a_Pagar.COL_VALOR_QUITADO));
				contas_a_Pagar_Adapter.setQtd_pgmt(result.getInt(SQLUtil.Contas_a_Pagar.COL_QTD_PGMT));
				contas_a_Pagar_Adapter.setQtd_paga(result.getInt(SQLUtil.Contas_a_Pagar.COL_QTD_PAGA));
				contas_a_Pagar_Adapter.setData_vencimento(
						new java.util.Date(result.getDate(SQLUtil.Contas_a_Pagar.COL_DATA_VENC).getTime()));

				contas_a_Pagar_Adapters.add(contas_a_Pagar_Adapter);

			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoContas_a_Pagar.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			throw new DaoException("Erro ao buscar as contas pagas!");
		}
		return contas_a_Pagar_Adapters;
	}

	@Override
	public List<Contas_a_Pagar_Adapter> getAll_A_Pagar() throws DaoException {
		List<Contas_a_Pagar_Adapter> contas_a_Pagar_Adapters = new ArrayList<>();
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Contas_a_Pagar.SELECT_A_PAG_ADAPTER);
			this.result = this.statement.executeQuery();
			Contas_a_Pagar_Adapter contas_a_Pagar_Adapter;
			while (result.next()) {
				contas_a_Pagar_Adapter = new Contas_a_Pagar_Adapter();
				contas_a_Pagar_Adapter.setId(result.getInt(1));
				contas_a_Pagar_Adapter.setDescricao(result.getString(SQLUtil.Contas_a_Pagar.COL_DESCRICAO));
				contas_a_Pagar_Adapter.setValor(result.getDouble(SQLUtil.Contas_a_Pagar.COL_VALOR));
				contas_a_Pagar_Adapter.setValor_quitado(result.getDouble(SQLUtil.Contas_a_Pagar.COL_VALOR_QUITADO));
				contas_a_Pagar_Adapter.setQtd_pgmt(result.getInt(SQLUtil.Contas_a_Pagar.COL_QTD_PGMT));
				contas_a_Pagar_Adapter.setQtd_paga(result.getInt(SQLUtil.Contas_a_Pagar.COL_QTD_PAGA));
				contas_a_Pagar_Adapter.setData_vencimento(
						new java.util.Date(result.getDate(SQLUtil.Contas_a_Pagar.COL_DATA_VENC).getTime()));

				contas_a_Pagar_Adapters.add(contas_a_Pagar_Adapter);

			}
			this.conexao.close();

		} catch (SQLException ex) {
			Logger.getLogger(DaoContas_a_Pagar.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			throw new DaoException("Erro ao buscar as contas a pagar!");
		}
		return contas_a_Pagar_Adapters;
	}

	public List<RelatorioFinanceiro> getRelatorio(java.util.Date inicio, Date fim) throws DaoException {

		List<RelatorioFinanceiro> financeiros = new ArrayList<>();

		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Contas_a_Pagar.SELECT_RELATORIO);
			this.statement.setDate(1, new java.sql.Date(inicio.getTime()));
			this.statement.setDate(2, new java.sql.Date(fim.getTime()));
			this.statement.setDate(3, new java.sql.Date(inicio.getTime()));
			this.statement.setDate(4, new java.sql.Date(fim.getTime()));
			
			this.result = this.statement.executeQuery();

			RelatorioFinanceiro relatorioFinanceiro = null;

			Caixa caixa = null;
			Fornecedor fornecedor = null;
			Venda venda = null;
			while (result.next()) {
				relatorioFinanceiro = new RelatorioFinanceiro();
				Contas_a_pagar contas_a_pagar = new Contas_a_pagar();
				

				contas_a_pagar.setId(result.getInt(1));
				contas_a_pagar.setDescricao(result.getString(SQLUtil.Contas_a_Pagar.COL_DESCRICAO));
				contas_a_pagar.setValor(result.getDouble(SQLUtil.Contas_a_Pagar.COL_VALOR));
				contas_a_pagar.setValor_quitado(result.getDouble(SQLUtil.Contas_a_Pagar.COL_VALOR_QUITADO));
				contas_a_pagar.setQtd_pgmt(result.getInt(SQLUtil.Contas_a_Pagar.COL_QTD_PGMT));
				contas_a_pagar.setQtd_paga(result.getInt(SQLUtil.Contas_a_Pagar.COL_QTD_PAGA));
				contas_a_pagar.setData_pagamento(
						new java.util.Date(result.getDate(SQLUtil.Contas_a_Pagar.COL_DATA_PAG).getTime()));
				contas_a_pagar.setData_vencimento(
						new java.util.Date(result.getDate(SQLUtil.Contas_a_Pagar.COL_DATA_VENC).getTime()));
				caixa = Fachada.getInstance().buscarPorIdCaixa(result.getInt(SQLUtil.Contas_a_Pagar.COL_CAIXA_ID));
				contas_a_pagar.setCaixa_id(caixa);
				fornecedor = Fachada.getInstance()
						.buscarPorIdFornecedor(result.getInt(SQLUtil.Contas_a_Pagar.COL_FORNEC_ID));
				contas_a_pagar.setFornecedor_id(fornecedor);
				contas_a_pagar.setStatus(result.getBoolean(SQLUtil.Contas_a_Pagar.COL_STATUS));

				Contas_a_receber contas_a_receber = new Contas_a_receber();
				contas_a_receber.setId(result.getInt(1));
				contas_a_receber.setDesc(result.getString(SQLUtil.Contas_a_Receber.COL_DESCRICAO));
				contas_a_receber.setValor_total(result.getDouble(SQLUtil.Contas_a_Receber.COL_VALOR));
				contas_a_receber.setValor_pago(result.getDouble(SQLUtil.Contas_a_Receber.COL_VALOR_QUITADO));
				contas_a_receber.setQtd_pagmt(result.getInt(SQLUtil.Contas_a_Receber.COL_QTD_PGMT));
				contas_a_receber.setQtd_pag(result.getInt(SQLUtil.Contas_a_Receber.COL_QTD_PAGA));
				contas_a_receber.setSaldo(result.getDouble(SQLUtil.Contas_a_Receber.COL_SALDO));
				contas_a_receber.setData_pag(
						new java.util.Date(result.getDate(SQLUtil.Contas_a_Receber.COL_DATA_PAG).getTime()));
				contas_a_receber.setData_venc(
						new java.util.Date(result.getDate(SQLUtil.Contas_a_Receber.COL_DATA_VENC).getTime()));
				caixa = Fachada.getInstance().buscarPorIdCaixa(result.getInt(SQLUtil.Contas_a_Receber.COL_CAIXA_ID));
				contas_a_receber.setId_caixa(caixa);
				venda = Fachada.getInstance().buscarPorIdVenda(result.getInt(SQLUtil.Contas_a_Receber.COL_VENDA_ID));
				contas_a_receber.setId_venda(venda);
				contas_a_receber.setAtivo(result.getBoolean(SQLUtil.Contas_a_Receber.COL_STATUS));

				relatorioFinanceiro.setContas_a_pagar(contas_a_pagar);
				relatorioFinanceiro.setContas_a_receber(contas_a_receber);
				financeiros.add(relatorioFinanceiro);

			}

			RelatorioFinanceiro.setInicio(inicio);
			RelatorioFinanceiro.setFim(fim);
			this.conexao.close();

		} catch (SQLException | BusinessException ex) {
			Logger.getLogger(DaoContas_a_Pagar.class.getName()).log(Level.SEVERE, null, ex);
			ex.printStackTrace();
			throw new DaoException("Erro ao gerar relatório de contas a pagar!");
		}

		return financeiros;
	}

	@Override
	public void editar(Contas_a_pagar contas_a_pagar) throws DaoException {

	}

	@Override
	public void ativarDesativar(int id) throws DaoException {

	}
}
