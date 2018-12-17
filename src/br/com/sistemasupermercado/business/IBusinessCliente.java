package br.com.sistemasupermercado.business;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Cliente;
import br.com.sistemasupermercado.model.ClienteTabAdapter;

import java.util.List;

public interface IBusinessCliente {

    public void salvarEditar(Cliente cliente) throws BusinessException;

    public Cliente buscarPorId(int id) throws BusinessException;

    public ClienteTabAdapter buscarPorCPF(String cpf) throws BusinessException;

    public List<Cliente> getAll() throws BusinessException;

    public void ativarDesativar(int id) throws BusinessException;

    public void validar(Cliente cliente) throws ValidacaoException;

}
