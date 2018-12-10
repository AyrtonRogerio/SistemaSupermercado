/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Fornecedor;
import br.com.sistemasupermercado.model.Item_Produto;
import br.com.sistemasupermercado.model.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @author ayrton
 *
 */
public class ControleCadastroProduto implements Initializable {

	private Fachada fachada = Fachada.getInstance();

	@FXML
	private Tab lista_prod_tabPane;

	@FXML
	private TextField busca_avanc_produto_field;

	@FXML
	private TextField cod_produto_field;

	@FXML
	private DatePicker data_compra_produto_field;

	@FXML
	private DatePicker data_valid_produto_field;

	@FXML
	private Button busca_avanc_produto_button;

	@FXML
	private TableView<Produto> tabela_produto;

	@FXML
	private TableColumn<Produto, String> nome_tabela;

	@FXML
	private TableColumn<Produto, String> marca_tabela;

	@FXML
	private TableView<Item_Produto> tabela_item_produto;

	@FXML
	private TableColumn<Item_Produto, Integer> codigo_tabela;

	@FXML
	private TableColumn<Item_Produto, Double> valor_varejo_tabela;

	@FXML
	private TableColumn<Item_Produto, Integer> estoque_tabela;

	@FXML
	private TableColumn<Item_Produto, Date> data_cadastro_tabela;

	@FXML
	private TableColumn<Item_Produto, Boolean> status_tabela;

	@FXML
	private Tab novo_produto_tab;

	@FXML
	private Button continuar_prod_cadast_button;

	@FXML
	private TextField quant_prod_cadast_field;

	@FXML
	private TextField nome_prod_cadast_field;

	@FXML
	private TextField cod_prod_cadast_field;

	@FXML
	private TextField descri_prod_cadast_field;

	@FXML
	private TextField marca_prod_cadastro_field;

	@FXML
	private DatePicker dataCad_prod_cadast_data;

	@FXML
	private DatePicker data_valid_prod_cadast_data;

	@FXML
	private DatePicker data_fabric_prod_cadast_data;

	@FXML
	private CheckBox perecivel_prod_cadast_checkB;

	@FXML
	private CheckBox status_prod_cadast_checkB;

	@FXML
	private Tab valores_tab;

	@FXML
	private Button voltar_prod_cadast_button;

	@FXML
	private Button cont_valores_prod_cadast_button;

	@FXML
	private TextField preco_unit_prod_cadastro_field;

	@FXML
	private TextField preco_varej_prod_cadastro_field;

	@FXML
	private TextField preco_atac_prod_cadast_field;

	@FXML
	private TextField porc_varej_prod_cadast_field;

	@FXML
	private TextField porc_atac_prod_cadast_field;

	@FXML
	private TextField busca_fornec_field;

	@FXML
	private Button busca_fornec_button;

	@FXML
	private TableView<?> tebela_fornec;

	@FXML
	private Button add_fornec_button;

	@FXML
	private TextField busca_prod_nome_field;

	@FXML
	private Button busca_prod_nome_button;

	@FXML
	void action(ActionEvent event) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javafx.fxml.Initializable#initialize(java.net.URL,
	 * java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
