package br.com.sistemasupermercado.dao;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Caixa;
import br.com.sistemasupermercado.model.Contas_a_Receber_Adapter;
import br.com.sistemasupermercado.model.Contas_a_receber;
import br.com.sistemasupermercado.model.Venda;
import br.com.sistemasupermercado.sql.SQLConections;
import br.com.sistemasupermercado.sql.SQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoContas_a_Receber implements  IDaoContas_a_Receber {

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;


    @Override
    public void salvar(Contas_a_receber contas_a_receber, int caixa_id, int venda_id) throws DaoException {
        try {

            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Contas_a_Receber.INSERT);
            this.statement.setString(1, contas_a_receber.getDesc());
            this.statement.setDouble(2, contas_a_receber.getValor_total());
            this.statement.setDouble(3, contas_a_receber.getValor_pago());
            this.statement.setInt(4, contas_a_receber.getQtd_pagmt());
            this.statement.setInt(5, contas_a_receber.getQtd_pag());
            this.statement.setDouble(6, contas_a_receber.getSaldo());
            this.statement.setDate(7, new java.sql.Date(contas_a_receber.getData_pag().getTime()));
            this.statement.setDate(8, new java.sql.Date(contas_a_receber.getData_venc().getTime()));
            this.statement.setInt(9, caixa_id);
            this.statement.setInt(10, venda_id);
            this.statement.setBoolean(11, contas_a_receber.isAtivo());

            this.statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoContas_a_Receber.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Contas_a_receber buscarPorId(int id) throws DaoException {
        Contas_a_receber contas_a_receber = null;
        Caixa caixa = null;
        Venda venda = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Contas_a_Receber.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                contas_a_receber = new Contas_a_receber();
                contas_a_receber.setId(result.getInt(1));
                contas_a_receber.setDesc(result.getString(SQLUtil.Contas_a_Receber.COL_DESCRICAO));
                contas_a_receber.setValor_total(result.getDouble(SQLUtil.Contas_a_Receber.COL_VALOR));
                contas_a_receber.setValor_pago(result.getDouble(SQLUtil.Contas_a_Receber.COL_VALOR_QUITADO));
                contas_a_receber.setQtd_pagmt(result.getInt(SQLUtil.Contas_a_Receber.COL_QTD_PGMT));
                contas_a_receber.setQtd_pag(result.getInt(SQLUtil.Contas_a_Receber.COL_QTD_PAGA));
                contas_a_receber.setSaldo(result.getDouble(SQLUtil.Contas_a_Receber.COL_SALDO));
                contas_a_receber.setData_pag(new java.util.Date(result.getDate(SQLUtil.Contas_a_Receber.COL_DATA_PAG).getTime()));
                contas_a_receber.setData_venc(new java.util.Date(result.getDate(SQLUtil.Contas_a_Receber.COL_DATA_VENC).getTime()));
                caixa = Fachada.getInstance().buscarPorIdCaixa(result.getInt(SQLUtil.Contas_a_Receber.COL_CAIXA_ID));
                contas_a_receber.setId_caixa(caixa);
                venda = Fachada.getInstance().buscarPorIdVenda(result.getInt(SQLUtil.Contas_a_Receber.COL_VENDA_ID));
                contas_a_receber.setId_venda(venda);
                contas_a_receber.setAtivo(result.getBoolean(SQLUtil.Contas_a_Receber.COL_STATUS));

            }
            this.conexao.close();

        } catch (SQLException | BusinessException ex) {
            Logger.getLogger(DaoContas_a_Receber.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contas_a_receber;
    }

    @Override
    public List<Contas_a_Receber_Adapter> getAll() throws DaoException {
        List<Contas_a_Receber_Adapter> contas_a_Receber_Adapters = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Contas_a_Receber.SELECT_ALL_ADAPTER);
            this.result = this.statement.executeQuery();
            Contas_a_Receber_Adapter contas_a_Receber_Adapter;
            while (result.next()) {
                contas_a_Receber_Adapter = new Contas_a_Receber_Adapter();
                contas_a_Receber_Adapter.setId(result.getInt(1));
                contas_a_Receber_Adapter.setDescricao(result.getString(SQLUtil.Contas_a_Receber.COL_DESCRICAO));
                contas_a_Receber_Adapter.setValor(result.getDouble(SQLUtil.Contas_a_Receber.COL_VALOR));
                contas_a_Receber_Adapter.setValor_quitado(result.getDouble(SQLUtil.Contas_a_Receber.COL_VALOR_QUITADO));
                contas_a_Receber_Adapter.setQtd_pgmt(result.getInt(SQLUtil.Contas_a_Receber.COL_QTD_PGMT));
                contas_a_Receber_Adapter.setQtd_paga(result.getInt(SQLUtil.Contas_a_Receber.COL_QTD_PAGA));
                
                contas_a_Receber_Adapters.add(contas_a_Receber_Adapter);

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoContas_a_Receber.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contas_a_Receber_Adapters;
    }
    
    @Override
    public List<Contas_a_Receber_Adapter> getAll_Recebida() throws DaoException {
        List<Contas_a_Receber_Adapter> contas_a_Receber_Adapters = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Contas_a_Receber.SELECT_RECEBIDA_ADAPTER);
            this.result = this.statement.executeQuery();
            Contas_a_Receber_Adapter contas_a_Receber_Adapter;
            while (result.next()) {
                contas_a_Receber_Adapter = new Contas_a_Receber_Adapter();
                contas_a_Receber_Adapter.setId(result.getInt(1));
                contas_a_Receber_Adapter.setDescricao(result.getString(SQLUtil.Contas_a_Receber.COL_DESCRICAO));
                contas_a_Receber_Adapter.setValor(result.getDouble(SQLUtil.Contas_a_Receber.COL_VALOR));
                contas_a_Receber_Adapter.setValor_quitado(result.getDouble(SQLUtil.Contas_a_Receber.COL_VALOR_QUITADO));
                contas_a_Receber_Adapter.setQtd_pgmt(result.getInt(SQLUtil.Contas_a_Receber.COL_QTD_PGMT));
                contas_a_Receber_Adapter.setQtd_paga(result.getInt(SQLUtil.Contas_a_Receber.COL_QTD_PAGA));
                
                contas_a_Receber_Adapters.add(contas_a_Receber_Adapter);

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoContas_a_Receber.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contas_a_Receber_Adapters;
    }
    
    @Override
    public List<Contas_a_Receber_Adapter> getAll_A_Receber() throws DaoException {
        List<Contas_a_Receber_Adapter> contas_a_Receber_Adapters = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Contas_a_Receber.SELECT_A_RECEB_ADAPTER);
            this.result = this.statement.executeQuery();
            Contas_a_Receber_Adapter contas_a_Receber_Adapter;
            while (result.next()) {
                contas_a_Receber_Adapter = new Contas_a_Receber_Adapter();
                contas_a_Receber_Adapter.setId(result.getInt(1));
                contas_a_Receber_Adapter.setDescricao(result.getString(SQLUtil.Contas_a_Receber.COL_DESCRICAO));
                contas_a_Receber_Adapter.setValor(result.getDouble(SQLUtil.Contas_a_Receber.COL_VALOR));
                contas_a_Receber_Adapter.setValor_quitado(result.getDouble(SQLUtil.Contas_a_Receber.COL_VALOR_QUITADO));
                contas_a_Receber_Adapter.setQtd_pgmt(result.getInt(SQLUtil.Contas_a_Receber.COL_QTD_PGMT));
                contas_a_Receber_Adapter.setQtd_paga(result.getInt(SQLUtil.Contas_a_Receber.COL_QTD_PAGA));
                
                contas_a_Receber_Adapters.add(contas_a_Receber_Adapter);

            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoContas_a_Receber.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contas_a_Receber_Adapters;
    }
    
    @Override
    public void editar(Contas_a_receber contas_a_receber) throws DaoException {

        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Contas_a_Receber.UPDATE);
            this.statement.setString(1, contas_a_receber.getDesc());
            this.statement.setDouble(2, contas_a_receber.getValor_total());
            this.statement.setInt(3, contas_a_receber.getQtd_pag());
            this.statement.setDouble(4, contas_a_receber.getValor_pago());
            this.statement.setDouble(5, contas_a_receber.getSaldo());
            this.statement.setBoolean(6, contas_a_receber.isAtivo());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void ativarDesativar(int id) throws DaoException {

    }
}
