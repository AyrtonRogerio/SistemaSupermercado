/**
 * 
 */
package br.com.sistemasupermercado.model;

/**
 * @author ayrton
 *
 */
public class Item_Venda {

//	id serial PRIMARY KEY NOT NULL,
//	valor_desc FLOAT,
//	porc_promoc FLOAT,
//	promocao BOOLEAN,
//	tipo VARCHAR(255),
//	quant INTEGER,
//	valor_item FLOAT,
//	desconto BOOLEAN,
//	venda_id INTEGER REFERENCES venda(id) NOT NULL,
//	item_produro_id INTEGER REFERENCES item_produto(id) NOT NULL
//	);

	
	private Integer id;
	private double valor_desc;
	private double proc_promoc;
	private boolean promocao;
	private String tipo;
	private int quantidade;
	private double valor_item;
	private boolean desconto;
	private Integer venda_id;
	private Integer item_produto_id;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getValor_desc() {
		return valor_desc;
	}
	public void setValor_desc(double valor_desc) {
		this.valor_desc = valor_desc;
	}
	public double getProc_promoc() {
		return proc_promoc;
	}
	public void setProc_promoc(double proc_promoc) {
		this.proc_promoc = proc_promoc;
	}
	public boolean isPromocao() {
		return promocao;
	}
	public void setPromocao(boolean promocao) {
		this.promocao = promocao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValor_item() {
		return valor_item;
	}
	public void setValor_item(double valor_item) {
		this.valor_item = valor_item;
	}
	public boolean isDesconto() {
		return desconto;
	}
	public void setDesconto(boolean desconto) {
		this.desconto = desconto;
	}
	public Integer getVenda_id() {
		return venda_id;
	}
	public void setVenda_id(Integer venda_id) {
		this.venda_id = venda_id;
	}
	public Integer getItem_produto_id() {
		return item_produto_id;
	}
	public void setItem_produto_id(Integer item_produto_id) {
		this.item_produto_id = item_produto_id;
	}
	
	
	
	
}
