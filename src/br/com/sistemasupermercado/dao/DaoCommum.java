package br.com.sistemasupermercado.dao;

import br.com.sistemasupermercado.enuns.TipoContato;
import br.com.sistemasupermercado.model.Contato;
import br.com.sistemasupermercado.model.Endereco;
import br.com.sistemasupermercado.sql.SQLConections;
import br.com.sistemasupermercado.sql.SQLUtil;
import org.postgresql.core.SqlCommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoCommum {

    private static Connection conexao;
    private static PreparedStatement statement;
    private static ResultSet result;

    public static int salvarEndereco(Endereco end) {
        int id = 0;
        try {
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Endereco.INSERT);
            statement.setString(1, end.getCep());
            statement.setString(2, end.getRua());
            statement.setString(3, end.getNumero());
            statement.setString(4, end.getBairro());
            statement.setString(5, end.getEstado());

            result = statement.executeQuery();

            if (result.next()) {
                id = result.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DaoCommum.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public static int salvarContato(Contato contato, int cliente_id) {
        int id =0;
    	try {
            System.out.println(contato);
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.Contato.INSERT);
            statement.setString(1, contato.getTipo().getValor());
            statement.setString(2, contato.getDescricao());
            statement.setInt(3, cliente_id);

            statement.execute();
            if (result.next()) {
                id = result.getInt(1);
            }
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoCommum.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public  static  Endereco buscarEndereco(Endereco end){


        try {
            conexao = SQLConections.getInstance();
            statement = conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Endereco.NOME_TABELA, end.getId()));
            result = statement.executeQuery();

            if(result.next()){
                end.setId(result.getInt(1));
                end.setCep(result.getString(SQLUtil.Endereco.COL_CEP));
                end.setRua(result.getString(SQLUtil.Endereco.COL_RUA));
                end.setNumero(result.getString(SQLUtil.Endereco.COL_NUMERO));
                end.setBairro(result.getString(SQLUtil.Endereco.COL_BAIRRO));
                end.setEstado(result.getString(SQLUtil.Endereco.COL_ESTADO));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  end;
    }
    
    public static Contato buscarContato(Contato cont) {
    	
    	try {
    		conexao = SQLConections.getInstance();
			statement = conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Contato.NOME_TABELA, cont.getId()));
			result = statement.executeQuery();
			
			if(result.next()) {
				cont.setId(result.getInt(1));
				cont.setTipo(TipoContato.getTipoContato(result.getString(SQLUtil.Contato.COL_TIPO)));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return cont;
    }
}
