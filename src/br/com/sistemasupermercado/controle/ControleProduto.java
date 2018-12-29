/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Fornecedor;
import br.com.sistemasupermercado.model.Item_Produto;
import br.com.sistemasupermercado.model.Produto;
import br.com.sistemasupermercado.principal.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * @author ayrton
 *
 */
public class ControleProduto implements Initializable {

	private Produto produto = null;
	private Fornecedor fornecedor = null;
	private Item_Produto item_Produto;

	private Fachada fachada = Fachada.getInstance();

	// Date

	@FXML
	private DatePicker compra_prod_data;

	@FXML
	private DatePicker vencim_prod_data;

	@FXML
	private DatePicker cadast_prod_data;

	@FXML
	private DatePicker valid_prod_data;

	@FXML
	private DatePicker fabric_prod_data;

	// Fim DataPicker
	
	// TextField

	@FXML
	private TextField busca_avanc_produto_field;

	@FXML
	private TextField cod_produto_field;

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
	private TextField busca_prod_nome_field;

	// Fim TexteField

	// Button

	@FXML
	private Button busca_avanc_produto_button;

	@FXML
	private Button continuar_prod_cadast_button;

	@FXML
	private Button voltar_prod_cadast_button;

	@FXML
	private Button cont_valores_prod_cadast_button;

	@FXML
	private Button finalizar_cadas_prod_button;

	@FXML
	private Button add_fornec_button;

	@FXML
	private Button cadast_forn_button;

	@FXML
	private Button busca_fornec_button;

	@FXML
	private Button busca_prod_nome_button;

	// Fim Button

	// Tab

	@FXML
	private Tab lista_prod_tabPane;

	@FXML
	private Tab novo_produto_tab;

	@FXML
	private Tab valores_tab;

	@FXML
	private Tab fornecedor_tab;

	// Fim Tab

	// TableView

	@FXML
	private TableView<Produto> tabela_produto;

	@FXML
	private TableView<Item_Produto> tabela_item_produto;

	@FXML
	private TableView<Fornecedor> tabela_fornec;

	// Fim TableView

	// TableColumm
	@FXML
	private TableColumn<Produto, String> nome_tabela;

	@FXML
	private TableColumn<Produto, String> marca_tabela;

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
	private TableColumn<Fornecedor, String> nome_forn;

	@FXML
	private TableColumn<Fornecedor, String> razao_forn;

	@FXML
	private TableColumn<Fornecedor, String> cnpj_forn;

	@FXML
	private TableColumn<Fornecedor, String> cidade_forn;

	@FXML
	private TableColumn<Fornecedor, String> estado_forn;

	// Fim TableColumm

	// CheckBox
	@FXML
	private CheckBox perecivel_prod_cadast_checkB;

	@FXML
	private CheckBox status_prod_cadast_checkB;

	// Fim CheckBox

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == continuar_prod_cadast_button) {

			valores_tab.getTabPane().getSelectionModel().select(valores_tab);

		}

		if (event.getSource() == cont_valores_prod_cadast_button) {

			fornecedor_tab.getTabPane().getSelectionModel().select(fornecedor_tab);

		}

		if (event.getSource() == busca_fornec_button) {

			try {

				fornecedor = fachada.buscarPorNomeFornecedor(busca_fornec_field.getText());
				tabela_fornec.getItems().add(fornecedor);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		if (event.getSource() == add_fornec_button) {

			fornecedor = tabela_fornec.getSelectionModel().getSelectedItem();
		}

		if (event.getSource() == cadast_forn_button) {

			Dialog<Fornecedor> cadastrarFornecedor = new Dialog<>();

			cadastrarFornecedor.getDialogPane().setContent(Main.telaFornecedor());
			cadastrarFornecedor.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
			cadastrarFornecedor.showAndWait();

		}

		if (event.getSource() == finalizar_cadas_prod_button) {

			try {
				cadastrarProduto(fornecedor);
				System.out.println(fornecedor.getId());
				fachada.salvarEditarItemProduto(item_Produto, fornecedor.getId());
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		nome_forn.setCellValueFactory(new PropertyValueFactory<>("nome"));
		razao_forn.setCellValueFactory(new PropertyValueFactory<>("razao_social"));
		cnpj_forn.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
		cidade_forn.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		estado_forn.setCellValueFactory(new PropertyValueFactory<>("estado"));

	}

	public void cadastrarProduto(Fornecedor forne) {

		produto = new Produto();
		item_Produto = new Item_Produto();

		produto.setNome(nome_prod_cadast_field.getText());
		produto.setMarca(marca_prod_cadastro_field.getText());
		produto.setDescricao(descri_prod_cadast_field.getText());

		item_Produto.setCod_barras(Integer.parseInt(cod_prod_cadast_field.getText()));
		item_Produto.setQuantidade(Integer.parseInt(quant_prod_cadast_field.getText()));

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {

			System.out.println(cadast_prod_data.getEditor().getText().trim());
			item_Produto.setData_compra(format.parse(cadast_prod_data.getEditor().getText().trim()));
			item_Produto.setData_fabricacao(format.parse(fabric_prod_data.getEditor().getText().trim()));
			item_Produto.setData_validade(format.parse(valid_prod_data.getEditor().getText().trim()));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		item_Produto.setPerecivel(perecivel_prod_cadast_checkB.isSelected());
		item_Produto.setStatus(status_prod_cadast_checkB.isSelected());

		item_Produto.setPorc_atacado(Double.parseDouble(porc_atac_prod_cadast_field.getText()));
		item_Produto.setPorc_varejo(Double.parseDouble(porc_varej_prod_cadast_field.getText()));

		item_Produto.setPreco_atacado(Double.parseDouble(preco_atac_prod_cadast_field.getText()));
		item_Produto.setPreco_varejo(Double.parseDouble(preco_varej_prod_cadastro_field.getText()));

		item_Produto.setFornecedor_id(forne);
		item_Produto.setProduto_id(produto);
	}

}
