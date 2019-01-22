/**
 * 
 */
package br.com.sistemasupermercado.business;

import java.util.List;

import com.sun.org.apache.xml.internal.utils.ThreadControllerWrapper;

import br.com.sistemasupermercado.dao.DaoItem_Produto;
import br.com.sistemasupermercado.dao.IDaoItem_Produto;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.model.*;

/**
 * @author ayrton
 *
 */
public class BusinessItem_Produto implements IBusinessItem_Produto {

	private IDaoItem_Produto daoItemProduto;

	public BusinessItem_Produto() {
		daoItemProduto = new DaoItem_Produto();
	}

	@Override
	public void salvar(Item_Produto item_Produto, int produto_id, int id_fornecedor) throws BusinessException {

		try {
			validar(item_Produto);
			if (item_Produto.getId() == null)
				daoItemProduto.salvar(item_Produto, produto_id, id_fornecedor);

		} catch (DaoException | ValidacaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void editar(Item_Produto item_produto) throws BusinessException {
		try {
			daoItemProduto.editar(item_produto);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public Item_Produto buscarPorId(int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoItemProduto.buscarPorId(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<Item_Produto> getAll() throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoItemProduto.getAll();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<ProdutoTabAdapter> getAllAdapter() throws BusinessException {
		try {
			return daoItemProduto.getAllAdapter();
		} catch (DaoException e) {
			e.printStackTrace();

			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<EstoqueTabAdapter> getAllEstoqueAdapter() throws BusinessException {
		try {
			return daoItemProduto.getAllEstoqueAdapter();
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<EstoqueTabAdapter> getAllEstoqueAdapterPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoItemProduto.getAllEstoqueAdapterPorBusca(busca);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public List<ProdutoTabAdapter> getAllAdapterPorBusca(String busca) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return daoItemProduto.getAllAdapterPorBusca(busca);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public VendaTabAdapter buscarPorIdVendaAdapter(int id) throws BusinessException {
		try {
			return daoItemProduto.buscarPorIdVendaAdapter(id);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void atualizarVenidos(Item_Produto item_Produto) throws BusinessException {
		try {
			daoItemProduto.atualizarVenidos(item_Produto);
		} catch (DaoException e) {
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void ativarDesativar(int id) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			daoItemProduto.ativarDesativar(id);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public void validar(Item_Produto item_Produto) throws ValidacaoException {
		// TODO Auto-generated method stub
		if (item_Produto.getCod_barras() == 0)
			throw new ValidacaoException("O código de barras não pode ser nulo!!!");

		if (item_Produto.getData_compra() == null) {
			throw new ValidacaoException("A data de compra não pode ser nulo!!!");
		}

		if (item_Produto.getData_fabricacao() == null) {
			throw new ValidacaoException("A data de fabicação não pode ser nula!!!");
		}

		if (item_Produto.getData_validade() == null) {
			throw new ValidacaoException("A data de validade não pode ser nula!!");
			
		}

		if (item_Produto.getFornecedor_id() == null) {
			throw new ValidacaoException("O fornecedor não pode ser nulo!!!");
		}

//		if (item_Produto.getId() == 0) {
//			throw new ValidacaoException("O código de barras não pode ser nulo!!!");
//		}

		if (item_Produto.getPorc_atacado() < 0.00) {
			throw new ValidacaoException("O valor não pode ser menos que isso!!!");
		}

		if (item_Produto.getPorc_varejo() < 0.00) {
			throw new ValidacaoException("O valor não pode ser menor que isso!!!");
		}

//		if (item_Produto.getCod_barras() == 0) {
//			throw new ValidacaoException("O código de barras não pode ser nulo!!!");
//		}
	}

}
