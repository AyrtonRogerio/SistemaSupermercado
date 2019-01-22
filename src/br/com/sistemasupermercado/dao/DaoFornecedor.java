package br.com.sistemasupermercado.dao;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Fornecedor;
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

public class DaoFornecedor implements IDaoFornecedor {

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public int salvar(Fornecedor fornecedor) throws DaoException {
    	int id = 0;
        try {
        	System.out.println("fornec");
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Fornecedor.INSERT);
            this.statement.setString(1, fornecedor.getNome());
            this.statement.setString(2, fornecedor.getRazao_social());
            this.statement.setString(3, fornecedor.getCnpj());
            this.statement.setString(4, fornecedor.getEstado());
            this.statement.setString(5, fornecedor.getCidade());
            
            this.result = this.statement.executeQuery();

            if(result.next()) {
            	id = result.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DaoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            throw new DaoException("Erro ao salvar o fornecedor!");
        }
        	return id;
    }

    @Override
    public Fornecedor buscarPorId(int id) throws DaoException {
        Fornecedor fornecedor = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Fornecedor.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setId(result.getInt(1));
                fornecedor.setNome(result.getString(SQLUtil.Fornecedor.COL_NOME));
                fornecedor.setRazao_social(result.getString(SQLUtil.Fornecedor.COL_RAZAO_SOCIAL));
                fornecedor.setCnpj(result.getString(SQLUtil.Fornecedor.COL_CNPJ));
                fornecedor.setEstado(result.getString(SQLUtil.Fornecedor.COL_ESTADO));
                fornecedor.setCidade(result.getString(SQLUtil.Fornecedor.COL_CIDADE));
                System.out.println(fornecedor.getNome());
				System.out.println(fornecedor.getRazao_social());
				System.out.println(fornecedor.getCnpj());
				System.out.println(fornecedor.getEstado());
				System.out.println(fornecedor.getCidade());
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            throw new DaoException("Erro ao buscar o fornecedor!");
        }
        return fornecedor;
    }

    @Override
    public List<Fornecedor> getAll() throws DaoException {

        List<Fornecedor> fornecedores = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Fornecedor.NOME_TABELA));
            this.result = this.statement.executeQuery();
            Fornecedor fornecedor;
            while (result.next()) {
                fornecedor = new Fornecedor();
                fornecedor.setId(result.getInt(1));
                fornecedor.setNome(result.getString(SQLUtil.Fornecedor.COL_NOME));
                fornecedor.setRazao_social(result.getString(SQLUtil.Fornecedor.COL_RAZAO_SOCIAL));
                fornecedor.setCnpj(result.getString(SQLUtil.Fornecedor.COL_CNPJ));
                fornecedor.setEstado(result.getString(SQLUtil.Fornecedor.COL_ESTADO));
                fornecedor.setCidade(result.getString(SQLUtil.Fornecedor.COL_CIDADE));
                fornecedores.add(fornecedor);
                System.out.println(fornecedor.getNome());
				System.out.println(fornecedor.getRazao_social());
				System.out.println(fornecedor.getCnpj());
				System.out.println(fornecedor.getEstado());
				System.out.println(fornecedor.getCidade());
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            throw new DaoException("Erro ao buscar todos os fornecedores!");
        }
        return fornecedores;

    }

    public Fornecedor buscarPorNome(String nome) throws DaoException {
    	
    	Fornecedor fornecedor = null;
    	try {
    		this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Fornecedor.SELECT_NOME);
			this.statement.setString(1, nome);
			this.result = statement.executeQuery();
			
			if(result.next()) {
				fornecedor = new Fornecedor();
				
				fornecedor.setId(result.getInt(1));
				fornecedor.setNome(result.getString(SQLUtil.Fornecedor.COL_NOME));
				fornecedor.setRazao_social(result.getString(SQLUtil.Fornecedor.COL_RAZAO_SOCIAL));
				fornecedor.setCnpj(result.getString(SQLUtil.Fornecedor.COL_CNPJ));
				fornecedor.setCidade(result.getString(SQLUtil.Fornecedor.COL_CIDADE));
				fornecedor.setEstado(result.getString(SQLUtil.Fornecedor.COL_ESTADO));
				
			}
			
    	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
            throw new DaoException("Erro ao buscar o fornecedor!");
		}
    	return fornecedor;
    	
    }
    
    @Override
    public void editar(Fornecedor fornecedor) throws DaoException {

        try {

            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Fornecedor.UPDATE);
            this.statement.setString(1, fornecedor.getNome());
            this.statement.setString(2, fornecedor.getRazao_social());
            this.statement.setString(3, fornecedor.getCnpj());
            this.statement.setString(4, fornecedor.getEstado());
            this.statement.setString(5, fornecedor.getCidade());
            this.statement.setInt(6, fornecedor.getId());

            this.result = this.statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DaoFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            throw new DaoException("Erro ao editar o fornecedor!");
        }
    }

    @Override
    public void ativarDesativar(int id) throws DaoException {

    }
}
