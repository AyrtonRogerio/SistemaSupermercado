package br.com.sistemasupermercado.dao;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Caixa;
import br.com.sistemasupermercado.model.Contas_a_pagar;
import br.com.sistemasupermercado.model.Fornecedor;
import br.com.sistemasupermercado.sql.SQLConections;
import br.com.sistemasupermercado.sql.SQLUtil;

import java.sql.*;
import java.util.ArrayList;
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
            this.statement.setDate(6, new java.sql.Date(contas_a_pagar.getData_vencimento().getTime()));
            this.statement.setInt(7, caixa_id);
            this.statement.setInt(8, fornecedor_id);
            this.statement.setBoolean(9, contas_a_pagar.isStatus());

            this.statement.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DaoContas_a_Pagar.class.getName()).log(Level.SEVERE, null, ex);
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
                contas_a_pagar.setData_vencimento(new java.util.Date(result.getDate(SQLUtil.Contas_a_Pagar.COL_DATA_VENC).getTime()));
                caixa = Fachada.getInstance().buscarPorIdCaixa(result.getInt(SQLUtil.Contas_a_Pagar.COL_CAIXA_ID));
                contas_a_pagar.setCaixa_id(caixa);
                fornecedor = Fachada.getInstance().buscarPorIdFornecedor(result.getInt(SQLUtil.Contas_a_Pagar.COL_FORNEC_ID));
                contas_a_pagar.setFornecedor_id(fornecedor);
                contas_a_pagar.setStatus(result.getBoolean(SQLUtil.Contas_a_Pagar.COL_STATUS));

            }
            this.conexao.close();

        } catch (SQLException | BusinessException ex) {
            Logger.getLogger(DaoContas_a_Pagar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contas_a_pagar;
    }

    @Override
    public List<Contas_a_pagar> getAll() throws DaoException {
        List<Contas_a_pagar> contas_a_pagars = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Fornecedor.NOME_TABELA));
            this.result = this.statement.executeQuery();
            Contas_a_pagar contas_a_pagar;
            Caixa caixa = null;
            Fornecedor fornecedor = null;
            while (result.next()) {
                contas_a_pagar = new Contas_a_pagar();
                contas_a_pagar.setId(result.getInt(1));
                contas_a_pagar.setDescricao(result.getString(SQLUtil.Contas_a_Pagar.COL_DESCRICAO));
                contas_a_pagar.setValor(result.getDouble(SQLUtil.Contas_a_Pagar.COL_VALOR));
                contas_a_pagar.setValor_quitado(result.getDouble(SQLUtil.Contas_a_Pagar.COL_VALOR_QUITADO));
                contas_a_pagar.setQtd_pgmt(result.getInt(SQLUtil.Contas_a_Pagar.COL_QTD_PGMT));
                contas_a_pagar.setQtd_paga(result.getInt(SQLUtil.Contas_a_Pagar.COL_QTD_PAGA));
                contas_a_pagar.setData_vencimento(new java.util.Date(result.getDate(SQLUtil.Contas_a_Pagar.COL_DATA_VENC).getTime()));
                caixa = Fachada.getInstance().buscarPorIdCaixa(result.getInt(SQLUtil.Contas_a_Pagar.COL_CAIXA_ID));
                contas_a_pagar.setCaixa_id(caixa);
                fornecedor = Fachada.getInstance().buscarPorIdFornecedor(result.getInt(SQLUtil.Contas_a_Pagar.COL_FORNEC_ID));
                contas_a_pagar.setFornecedor_id(fornecedor);
                contas_a_pagar.setStatus(result.getBoolean(SQLUtil.Contas_a_Pagar.COL_STATUS));
                contas_a_pagars.add(contas_a_pagar);

            }
            this.conexao.close();

        } catch (SQLException | BusinessException ex) {
            Logger.getLogger(DaoContas_a_Pagar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contas_a_pagars;
    }

    @Override
    public void editar(Contas_a_pagar contas_a_pagar) throws DaoException {

    }

    @Override
    public void ativarDesativar(int id) throws DaoException {

    }
}
