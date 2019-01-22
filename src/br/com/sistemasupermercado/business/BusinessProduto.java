package br.com.sistemasupermercado.business;

import java.util.List;

import br.com.sistemasupermercado.dao.DaoProduto;
import br.com.sistemasupermercado.dao.IDaoProduto;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.Produto;

public class BusinessProduto implements IBusinessProduto {

	private IDaoProduto daoProduto;

	public BusinessProduto() {
		daoProduto = new DaoProduto();
	}

	@Override
	public int salvar(Produto produto) throws BusinessException {
		try {
			validar(produto);
			if (produto.getId() == null)
				return daoProduto.salvar(produto);

		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		} catch (ValidacaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			throw new ValidacaoException(e.getMessage());
		}
		return 0;
	}

	@Override
	public void editar(Produto produto) throws BusinessException {
		try {
			daoProduto.editar(produto);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Produto buscarPorId(int id) throws BusinessException {

		try {
			return daoProduto.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Produto> getAll() throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoProduto.getAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void ativarDesativar(int id) throws BusinessException {

		try {
			daoProduto.ativarDesativar(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}

	}

	@Override
	public void validar(Produto produto) throws ValidacaoException {

		if (produto.getNome() == null) {
			throw new ValidacaoException("Informe um nome!!!");
		}

		if (produto.getDescricao() == null) {
			throw new ValidacaoException("Informe uma descrição!!!");	
		}

		if (produto.getMarca() == null) {
			throw new ValidacaoException("Informe uma marca!!!");
		}

	}
}