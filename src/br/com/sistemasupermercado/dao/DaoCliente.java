package br.com.sistemasupermercado.dao;


import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Cliente;
import br.com.sistemasupermercado.model.ClienteTabAdapter;
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
			this.statement.setString(3, cliente.getSexo());
			this.statement.setString(4, cliente.getEstado_civil());
			this.statement.setString(5, cliente.getOcupacao());
			this.statement.setDate(6, new java.sql.Date(cliente.getData_nascimento().getTime()));
			this.statement.setInt(7, id_endereco);
			this.result = this.statement.executeQuery();
			int id = 0;
			
			if (result.next()) {
				id = result.getInt(1);
			}
			this.statement.close();

			for (Contato cont : cliente.getContatos()) {
				DaoCommum.salvarContato(cont, id);
			}

		} catch (PSQLException e) {
			e.printStackTrace();
			throw new DaoException("Dados Iguais - CPF ja cadastrado");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao salvar Cliente - Contate o ADM");
		}

	}

	@Override
	public Cliente buscarPorId(int id) throws DaoException {

		Cliente cliente = null;
		Endereco endereco = null;
		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.selectById(SQLUtil.Cliente.NOME_TABELA, id));
			this.result = this.statement.executeQuery();

			if (result.next()) {
				cliente = new Cliente();
				cliente.setId(result.getInt(1));
				cliente.setNome(result.getString(SQLUtil.Cliente.COL_NOME));
				cliente.setCpf(result.getString(SQLUtil.Cliente.COL_CPF));
				cliente.setSexo(result.getString(SQLUtil.Cliente.COL_SEXO));
				cliente.setEstado_civil(result.getString(SQLUtil.Cliente.COL_ESTADO_CIVIL));
				cliente.setOcupacao(result.getString(SQLUtil.Cliente.COL_OCUPACAO));
				cliente.setData_nascimento(
						new java.util.Date(result.getDate(SQLUtil.Cliente.COL_DATA_NASCIMENTO).getTime()));
				endereco = DaoCommum.buscarEndereco(result.getInt(SQLUtil.Cliente.COL_ENDERECO_ID));
				cliente.setEndereco(endereco);

			}
			this.conexao.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
			throw new DaoException("Erro ao buscar cliente!");
		}
		return cliente;

	}

	@Override
	public ClienteTabAdapter buscarPorCPF(String busca) throws DaoException {

		ClienteTabAdapter clienteTabAdapter = null;

		try {

			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Cliente.SELECT_CPF);
			this.statement.setString(1,"%" + busca + "%");
			this.statement.setString(2,"%" + busca + "%");
			this.statement.setString(3,"%" + busca + "%");
			this.result = this.statement.executeQuery();

			if (result.next()) {
				clienteTabAdapter = new ClienteTabAdapter();
				clienteTabAdapter.setId(result.getInt(1));
				clienteTabAdapter.setNome(result.getString("nome"));
				clienteTabAdapter.setCpf(result.getString("cpf"));
				clienteTabAdapter.setData_nascimento(
						new java.util.Date(result.getDate("data_nascimento").getTime()));
				clienteTabAdapter.setRua(result.getString("rua"));
				clienteTabAdapter.setBairro(result.getString("bairro"));
				clienteTabAdapter.setNumero(result.getString("numero"));


			}
			this.conexao.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
			throw new DaoException("Erro ao buscar cliente por!");
		}

		return clienteTabAdapter;
	}

	@Override
	public List<ClienteTabAdapter> getAllAdapter() throws DaoException {

		List<ClienteTabAdapter> clienteTabAdapters = new ArrayList<>();

		try {
			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Cliente.SELECT_ALL_ADAPTER);
			this.result = this.statement.executeQuery();
			ClienteTabAdapter clienteTabAdapter = null;
			while(result.next()) {
				clienteTabAdapter = new ClienteTabAdapter();
				clienteTabAdapter.setId(result.getInt(1));
				clienteTabAdapter.setNome(result.getString("nome"));
				clienteTabAdapter.setCpf(result.getString("cpf"));
				clienteTabAdapter.setData_nascimento(
						new java.util.Date(result.getDate("data_nascimento").getTime()));
				clienteTabAdapter.setRua(result.getString("rua"));
				clienteTabAdapter.setBairro(result.getString("bairro"));
				clienteTabAdapter.setNumero(result.getString("numero"));
				clienteTabAdapters.add(clienteTabAdapter);
			}
			this.conexao.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
			throw new DaoException("Erro ao buscar cliente!");
		}

		return clienteTabAdapters;
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
				cliente.setSexo(result.getString(SQLUtil.Cliente.COL_SEXO));
				cliente.setEstado_civil(result.getString(SQLUtil.Cliente.COL_ESTADO_CIVIL));
				cliente.setOcupacao(result.getString(SQLUtil.Cliente.COL_OCUPACAO));
				cliente.setData_nascimento(
						new java.util.Date(result.getDate(SQLUtil.Cliente.COL_DATA_NASCIMENTO).getTime()));
				Endereco endereco = DaoCommum.buscarEndereco(cliente.getId());
				cliente.setEndereco(endereco);
				clientes.add(cliente);
			}
			this.conexao.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(DaoCliente.class.getName()).log(Level.SEVERE, null, ex);
			throw new DaoException("Erro ao buscar todos os clientes!");
		}
		return clientes;

	}

	@Override
	public void editar(Cliente cliente) throws DaoException {

		try {

			this.conexao = SQLConections.getInstance();
			this.statement = this.conexao.prepareStatement(SQLUtil.Cliente.UPDATE);
			this.statement.setString(1, cliente.getNome());
			this.statement.setString(2, cliente.getCpf());
			this.statement.setString(3, cliente.getSexo());
			this.statement.setString(4, cliente.getEstado_civil());
			this.statement.setString(5, cliente.getOcupacao());
			this.statement.setDate(6, new java.sql.Date(cliente.getData_nascimento().getTime()));
			this.statement.setInt(7, cliente.getId());
			this.statement.execute();


			this.statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException("Erro ao editar o cliente");
		}
	}

	@Override
	public void ativarDesativar(int id) throws DaoException {

	}
}
