/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.com.sistemasupermercado.enuns.TipoContato;
import br.com.sistemasupermercado.enuns.TipoEstadoCivil;
import br.com.sistemasupermercado.enuns.TipoOcupacao;
import br.com.sistemasupermercado.enuns.TipoSexo;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Cliente;
import br.com.sistemasupermercado.model.ClienteTabAdapter;
import br.com.sistemasupermercado.model.Contato;
import br.com.sistemasupermercado.model.Endereco;
import br.com.sistemasupermercado.model.MaskFieldUtil;
import br.com.sistemasupermercado.principal.Main;
import br.com.sistemasupermercado.view.Mensagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author ayrton
 *
 */
public class ControleCliente implements Initializable {

	private Fachada fachada = Fachada.getInstance();
	private Cliente cliente;
	private ClienteTabAdapter clienteTabAdapter;
	private List<ClienteTabAdapter> clienteTabAdapters;
	private Endereco endereco;
	private Contato contato;
	private Contato contato2;
	private List<Contato> contatos;

	@FXML
	private Tab lista_cliente_tab;

	@FXML
	private TextField busca_cliente_field;

	@FXML
	private Button busca_cliente_button;

	@FXML
	private Button novo_cliente_button;

	@FXML
	private TableView<ClienteTabAdapter> tabela_clentes;

	@FXML
	private TableColumn<ClienteTabAdapter, String> nome_cliente_col;

	@FXML
	private TableColumn<ClienteTabAdapter, String> cpf_cliente_col;

	@FXML
	private TableColumn<ClienteTabAdapter, Date> nasc_cliente_col;

	@FXML
	private TableColumn<ClienteTabAdapter, String> rua_cliente_col;

	@FXML
	private TableColumn<ClienteTabAdapter, String> bairro_cliente_col;

	@FXML
	private TableColumn<ClienteTabAdapter, String> num_cliente_col;

	@FXML
    private Button detalhes_cli_button;

    @FXML
    private Button editar_cliente_button;
	
	@FXML
	private Tab dados_cliente_tab;

	@FXML
	private TextField nome_cliente_field;

	@FXML
	private TextField cpf_cliente_field;

	@FXML
	private ComboBox<TipoSexo> sexo_cliente_combo;

	@FXML
	private ComboBox<TipoEstadoCivil> estad_civ_client_combo;

	@FXML
	private ComboBox<TipoOcupacao> ocupacao_cliente_combo;

	@FXML
	private DatePicker data_cliente;

	@FXML
	private Button voltar_cliente_button;

	@FXML
	private Button continuar_cliente_button;

	@FXML
	private Tab end_cliente_tab;

	@FXML
	private TextField rua_end_cliente_field;

	@FXML
	private TextField cep_end_cliente_field;

	@FXML
	private TextField num_end_cliente_field;

	@FXML
	private TextField bairro_end_cliente_field;

	@FXML
	private TextField cidade_end_cliente_field;

	@FXML
	private TextField uf_end_cliente_field;

	@FXML
	private Button voltar_end_clien_button;

	@FXML
	private Button contin_end_clien_button;

	@FXML
	private Tab cont_cliente_tab;

	@FXML
	private TextField fone_cont_cliente_field1;

	@FXML
	private TextField email_cont_cliente_field;

	@FXML
	private TextField fone_cont_cliente_field2;

	@FXML
	private Button voltar_cont_clie_button;

	@FXML
	private Button cadast_clien_button;

	@FXML
	void action(ActionEvent event) {


		if(event.getSource() == busca_cliente_button){

			try {

				clienteTabAdapter = fachada.buscarPorCPFCliente(busca_cliente_field.getText());
				tabela_clentes.getItems().setAll(clienteTabAdapter);
				
			} catch (BusinessException e) {
				Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Buscar Cliente", "Erro ao buscar cliente", e.getMessage());
				e.printStackTrace();
			}
		}

		if(event.getSource() == novo_cliente_button){

			dados_cliente_tab.getTabPane().getSelectionModel().select(dados_cliente_tab);

		}

		if(event.getSource() == continuar_cliente_button) {

			end_cliente_tab.getTabPane().getSelectionModel().select(end_cliente_tab);

		}

		if(event.getSource() == voltar_cliente_button){

			lista_cliente_tab.getTabPane().getSelectionModel().select(lista_cliente_tab);

		}

		if(event.getSource() == contin_end_clien_button) {

			cont_cliente_tab.getTabPane().getSelectionModel().select(cont_cliente_tab);

		}

		if(event.getSource() == voltar_end_clien_button){

			dados_cliente_tab.getTabPane().getSelectionModel().select(dados_cliente_tab);

		}

		if(event.getSource() == cadast_clien_button) {

			cadastrarCliente();

			try {

				fachada.salvarCliente(cliente);
				clienteTabAdapters = fachada.getAllAdapterCliente();
				tabela_clentes.getItems().setAll(clienteTabAdapters);
				Mensagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo", "O cliente foi salvo com sucesso!");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro salvar Cliente", "Erro ao salvar o cliente", e.getMessage());
			}

			limparCampos();
			lista_cliente_tab.getTabPane().getSelectionModel().select(lista_cliente_tab);

		}

		if(event.getSource() == voltar_cont_clie_button){

			end_cliente_tab.getTabPane().getSelectionModel().select(end_cliente_tab);

		}
		
		
		if(event.getSource() == detalhes_cli_button) {
			Dialog<Contato> dialog = new Dialog<>();
			
			dialog.getDialogPane().setContent(Main.telaContato());
			dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
			dialog.showAndWait();
			
			
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		MaskFieldUtil.cpfField(cpf_cliente_field);
		MaskFieldUtil.foneField(fone_cont_cliente_field1);
		MaskFieldUtil.cepField(cep_end_cliente_field);
		
		sexo_cliente_combo.getItems().setAll(TipoSexo.values());
		estad_civ_client_combo.getItems().setAll(TipoEstadoCivil.values());
		ocupacao_cliente_combo.getItems().setAll(TipoOcupacao.values());

		nome_cliente_col.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpf_cliente_col.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		nasc_cliente_col.setCellValueFactory(new PropertyValueFactory<>("data_nascimento"));
		rua_cliente_col.setCellValueFactory(new PropertyValueFactory<>("rua"));
		bairro_cliente_col.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		num_cliente_col.setCellValueFactory(new PropertyValueFactory<>("numero"));

		try {

			clienteTabAdapters = fachada.getAllAdapterCliente();
			tabela_clentes.getItems().setAll(clienteTabAdapters);

		} catch (BusinessException e) {
			e.printStackTrace();
		}



		nasc_cliente_col.setCellFactory(coluna -> {

			return new TableCell<ClienteTabAdapter, Date>() {
				protected void updateItem(Date item, boolean empty) {

					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(new SimpleDateFormat("dd/MM/yyyy").format(item));
					}
				}
			};
		});

	}

//	public void teste(String...strings)
//	{
//		
//	}
	
	
	public void cadastrarCliente() {

		cliente = new Cliente();

		cliente.setNome(nome_cliente_field.getText());
		cliente.setCpf(cpf_cliente_field.getText());
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		try {

			cliente.setData_nascimento(format.parse(data_cliente.getEditor().getText()));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cliente.setSexo(sexo_cliente_combo.getValue()+"");
		cliente.setEstado_civil(estad_civ_client_combo.getValue()+"");
		cliente.setOcupacao(ocupacao_cliente_combo.getValue()+"");
		
		
		endereco = new Endereco();

		endereco.setRua(rua_end_cliente_field.getText());
		endereco.setNumero(num_end_cliente_field.getText());
		endereco.setCep(cep_end_cliente_field.getText());
		endereco.setBairro(bairro_end_cliente_field.getText());
		endereco.setCidade(cidade_end_cliente_field.getText());
		endereco.setEstado(uf_end_cliente_field.getText());
		
		cliente.setEndereco(endereco);
		
		contato = new Contato();
		contato2 = new Contato();
		contatos = new ArrayList<>();

		contato.setCliente(cliente);
		contato.setTipo(TipoContato.TELEFONE);
		contato.setDescricao(fone_cont_cliente_field1.getText());
		
		
		contato2.setCliente(cliente);
		contato2.setTipo(TipoContato.EMAIL);
		contato2.setDescricao(email_cont_cliente_field.getText());

		contatos.add(contato);
		contatos.add(contato2);

//		if(!fone_cont_cliente_field2.getText().isEmpty()) {
//
//			contato3 = new Contato();	
//			contato3.setCliente(cliente);
//			contato3.setTipo(TipoContato.TELEFONE);
//			contato3.setDescricao(fone_cont_cliente_field2.getText());
//			
//			contatos.add(contato3);
//
//		}
		
		
		cliente.setContatos(contatos);
	}

	public void limparCampos(){

		nome_cliente_field.clear();
		cpf_cliente_field.clear();
		rua_end_cliente_field.clear();
		data_cliente.getEditor().clear();

		num_end_cliente_field.clear();
		cep_end_cliente_field.clear();
		bairro_end_cliente_field.clear();
		cidade_end_cliente_field.clear();
		uf_end_cliente_field.clear();
		fone_cont_cliente_field1.clear();
		email_cont_cliente_field.clear();
		fone_cont_cliente_field2.clear();

	}

}
