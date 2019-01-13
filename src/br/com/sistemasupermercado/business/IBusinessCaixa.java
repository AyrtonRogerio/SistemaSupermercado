package br.com.sistemasupermercado.business;

import java.sql.Date;
import java.util.List;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Caixa;

public interface IBusinessCaixa {

	public void salvar(Caixa caixa, int funcionario_id) throws BusinessException;

	public void editar(Caixa caixa) throws BusinessException;

	public Caixa buscarPorId(int id) throws BusinessException;

	public Caixa buscarPorData(Date data) throws BusinessException;

	public Caixa buscarPorAnterior() throws BusinessException;

	public List<Caixa> getAll() throws BusinessException;

	public void ativarDesativar(int id) throws BusinessException;

	public void validar(Caixa caixa) throws ValidacaoException;
	
}
