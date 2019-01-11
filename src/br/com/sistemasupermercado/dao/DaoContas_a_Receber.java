package br.com.sistemasupermercado.dao;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Caixa;
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
            this.statement.setDouble(1, contas_a_receber.getValor());
            this.statement.setString(2, contas_a_receber.getDescricao());
            this.statement.setInt(3, caixa_id);
            this.statement.setInt(4, contas_a_receber.getPagamento());
            this.statement.setInt(5, venda_id);
            this.statement.setBoolean(6, contas_a_receber.isStatus());

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
                contas_a_receber.setValor(result.getDouble(SQLUtil.Contas_a_Receber.COL_VALOR));
                contas_a_receber.setDescricao(result.getString(SQLUtil.Contas_a_Receber.COL_DESCRICAO));
                caixa = Fachada.getInstance().buscarPorIdCaixa(result.getInt(SQLUtil.Contas_a_Receber.COL_CAIXA_ID));
                contas_a_receber.setCaixa_id(caixa);
                contas_a_receber.setPagamento(result.getInt(SQLUtil.Contas_a_Receber.COL_QTD_PAGMT));
                venda = Fachada.getInstance().buscarPorIdVenda(result.getInt(SQLUtil.Contas_a_Receber.COL_VENDA_ID));
                contas_a_receber.setVenda_id(venda);
                contas_a_receber.setStatus(result.getBoolean(SQLUtil.Contas_a_Receber.COL_STATUS));

            }
            this.conexao.close();

        } catch (SQLException | BusinessException ex) {
            Logger.getLogger(DaoContas_a_Receber.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contas_a_receber;
    }

    @Override
    public List<Contas_a_receber> getAll() throws DaoException {
        List<Contas_a_receber> contas_a_recebers = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Fornecedor.NOME_TABELA));
            this.result = this.statement.executeQuery();
            Contas_a_receber contas_a_receber;
            Caixa caixa = null;
            Venda venda = null;
            while (result.next()) {
                contas_a_receber = new Contas_a_receber();
                contas_a_receber.setId(result.getInt(1));
                contas_a_receber.setValor(result.getDouble(SQLUtil.Contas_a_Receber.COL_VALOR));
                contas_a_receber.setDescricao(result.getString(SQLUtil.Contas_a_Receber.COL_DESCRICAO));
                caixa = Fachada.getInstance().buscarPorIdCaixa(result.getInt(SQLUtil.Contas_a_Receber.COL_CAIXA_ID));
                contas_a_receber.setCaixa_id(caixa);
                contas_a_receber.setPagamento(result.getInt(SQLUtil.Contas_a_Receber.COL_QTD_PAGMT));
                venda = Fachada.getInstance().buscarPorIdVenda(result.getInt(SQLUtil.Contas_a_Receber.COL_VENDA_ID));
                contas_a_receber.setVenda_id(venda);
                contas_a_receber.setStatus(result.getBoolean(SQLUtil.Contas_a_Receber.COL_STATUS));
                contas_a_recebers.add(contas_a_receber);

            }
            this.conexao.close();

        } catch (SQLException | BusinessException ex) {
            Logger.getLogger(DaoContas_a_Receber.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contas_a_recebers;
    }

    @Override
    public void editar(Contas_a_receber contas_a_receber) throws DaoException {

    }

    @Override
    public void ativarDesativar(int id) throws DaoException {

    }
}
