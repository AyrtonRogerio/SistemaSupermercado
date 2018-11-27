package br.com.sistemasupermercado.business;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Fornecedor;

import java.util.List;

public interface IBusinessFornecedor {

    public void salvarEditar(Fornecedor fornecedor) throws BusinessException;

    public Fornecedor buscarPorId(int id) throws BusinessException;

    public List<Fornecedor> getAll() throws BusinessException;

    public void ativarDesativar(int id) throws BusinessException;

    public void validar(Fornecedor fornecedor) throws ValidacaoException;

}
