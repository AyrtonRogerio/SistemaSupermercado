package br.com.sistemasupermercado.dao;

import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Cliente;
import br.com.sistemasupermercado.model.Contato;
import br.com.sistemasupermercado.model.Endereco;
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

import org.postgresql.util.PSQLException;

public class DaoCliente implements IDaoCliente {

    private Connection conexao;
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public void salvar(Cliente cliente) throws DaoException {


        try {
            int id_endereco = DaoCommum.salvarEndereco(cliente.getEndereco());
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.Cliente.INSERT);
            this.statement.setString(1, cliente.getNome());
            this.statement.setString(2, cliente.getCpf());
            this.statement.setInt(3, id_endereco);
            
            statement.execute();
        } catch (PSQLException e) {
			e.printStackTrace();
			throw new DaoException("Dados Iguais - CPF já cadastrado");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao salvar Cliente - Contate o ADM");
		}

    }

    @Override
    public Cliente buscarPorId(int id) throws DaoException {

        Cliente cliente = null;
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Cliente.NOME_TABELA, id));
            this.result = this.statement.executeQuery();

            if (result.next()) {
                cliente = new Cliente();
                cliente.setId(result.getInt(1));
                cliente.setNome(result.getString(SQLUtil.Cliente.COL_NOME));
                cliente.setCpf(result.getString(SQLUtil.Cliente.COL_CPF));
                Endereco endereco = DaoCommum.buscarEndereco(cliente.getEndereco());
                cliente.setEndereco(endereco);
                System.out.println(cliente.getNome());
				System.out.println(cliente.getCpf());
				System.out.println(cliente.getEndereco().getCep());



            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;

    }

    @Override
    public List<Cliente> getAll() throws DaoException {

        List<Cliente> clientes = new ArrayList<>();
        try {
            this.conexao = SQLConections.getInstance();
            this.statement = this.conexao.prepareStatement(SQLUtil.selectAll(SQLUtil.Cliente.NOME_TABELA));
            this.result = this.statement.executeQuery();
            Cliente cliente;
            while (result.next()) {
                cliente = new Cliente();
                cliente.setId(result.getInt(1));
                cliente.setNome(result.getString(SQLUtil.Cliente.COL_NOME));
                cliente.setCpf(result.getString(SQLUtil.Cliente.COL_CPF));
                Endereco endereco = DaoCommum.buscarEndereco(cliente.getEndereco());
                cliente.setEndereco(endereco);
                clientes.add(cliente);
            }
            this.conexao.close();

        } catch (SQLException ex) {
            Logger.getLogger(DaoProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;

    }

    @Override
    public void editar(Cliente cliente) throws DaoException {

    }

    @Override
    public void ativarDesativar(int id) throws DaoException {

    }
}
