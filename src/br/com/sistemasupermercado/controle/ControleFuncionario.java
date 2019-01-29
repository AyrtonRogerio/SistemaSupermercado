/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.sun.scenario.effect.Effect.AccelType;

import br.com.sistemasupermercado.dao.DaoCommum;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.exception.ValidacaoException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Endereco;
import br.com.sistemasupermercado.model.Funcionario;
import br.com.sistemasupermercado.model.FuncionarioAdapter;
import br.com.sistemasupermercado.model.MaskFieldUtil;
import br.com.sistemasupermercado.view.Mensagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Alert.AlertType;

/**
 * @author ayrton
 *
 */
public class ControleFuncionario implements Initializable {

	private Funcionario funcionario, func;
	private List<FuncionarioAdapter> adapters;
	private FuncionarioAdapter adapter;
	private Endereco endereco, end;
	private Fachada fachada = Fachada.getInstance();

	@FXML
	private Tab list_func_tab;

	@FXML
    private TextField busca_field;

    @FXML
    private Button busca_button;
    
    @FXML
    private Button novo_func_button;
	
	@FXML
	private TableView<FuncionarioAdapter> tabela_list;

	@FXML
	private TableColumn<FuncionarioAdapter, String> nome_col;

	@FXML
	private TableColumn<FuncionarioAdapter, String> cpf_col;

	@FXML
	private TableColumn<FuncionarioAdapter, String> cargo_col;

	@FXML
	private TableColumn<FuncionarioAdapter, String> rua_col;

	@FXML
	private TableColumn<FuncionarioAdapter, String> bairro_col;

	@FXML
	private TableColumn<FuncionarioAdapter, Boolean> situacao_col;

	@FXML
	private Tab func_tab;

	@FXML
	private Button voltar_func_button;

	@FXML
	private Button cont_func_button;

	@FXML
	private TextField nome_field;

	@FXML
	private TextField cpf_field;

	@FXML
	private TextField cargo_field;

	@FXML
	private TextField login_field;

	@FXML
	private PasswordField senha_field;

	@FXML
	private PasswordField conf_senha_field;

	@FXML
	private CheckBox situacao_cb;

	@FXML
	private Tab end_tab;

	@FXML
	private Button atualizar_button;

	@FXML
	private Button voltar_end_button;

	@FXML
	private Button cadast_func_button;

	@FXML
	private TextField rua_field;

	@FXML
	private TextField bairro_field;

	@FXML
	private TextField num_field;

	@FXML
	private TextField cep_field;

	@FXML
	private TextField cidade_field;

	@FXML
	private TextField estado_field;

	@FXML
	private Button editar_button;

	@FXML
	void action(ActionEvent event) {

		if(event.getSource() == busca_button) {
			
			
			if(!(busca_field.getText().trim().isEmpty())) {
				try {
					tabela_list.getItems().clear();
					adapters = fachada.buscarPorBuscaFuncionario(busca_field.getText());
					tabela_list.getItems().setAll(adapters);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} else {
				Mensagem.getInstancia().exibirMensagem(AlertType.WARNING, "Atenção", "Campo vazio!", "Informe algo para pesquisa!");
			}
			
			
		}
		
		
		if (event.getSource() == cadast_func_button) {
			try {

				criarFuncionario();
				if (senha_field.getText().equals(conf_senha_field.getText())) {

					int end_id = DaoCommum.salvarEndereco(end);
					fachada.salvarFuncionario(funcionario, end_id);
				} else {
					Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao Salvar",
							"Erro ao salvar o funcionário", "As senhas não correspondem!");
					func_tab.getTabPane().getSelectionModel().select(func_tab);
				}
				Mensagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Salvo", "Funcionário salvo",
						"O funcionário foi salvo com sucesso!");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao Salvar",
						"Erro ao salvar o funcionário", e.getMessage());
			} catch (ValidacaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao salvar", "Informações inválidas!",
						e.getMessage());

			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao salvar",
						"Erro ao salvar endereço do funcionário", e.getMessage());
			}
			limparCampos();
			try {
				adapters = fachada.getAllAdapterFuncionario();
				tabela_list.getItems().setAll(adapters);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao buscar!", "Erro ao buscar funcionário!", e.getMessage());
			}
			list_func_tab.getTabPane().getSelectionModel().select(list_func_tab);
		}

		if (event.getSource() == editar_button) {

			func_tab.getTabPane().getSelectionModel().select(func_tab);
			situacao_cb.setVisible(true);
			carregarFunc();
			atualizar_button.setDisable(false);

		}

		if (event.getSource() == atualizar_button) {
			situacao_cb.setVisible(false);
			atualizar(func);
			try {
				adapters = fachada.getAllAdapterFuncionario();
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tabela_list.getItems().setAll(adapters);
			atualizar_button.setDisable(true);
			
			list_func_tab.getTabPane().getSelectionModel().select(list_func_tab);
		}

		if(event.getSource() == novo_func_button) {
			
			func_tab.getTabPane().getSelectionModel().select(func_tab);
			
		}
		
		if(event.getSource() == cont_func_button) {
			
			end_tab.getTabPane().getSelectionModel().select(end_tab);
			
		}
		
		if(event.getSource() == voltar_func_button) {
			
			list_func_tab.getTabPane().getSelectionModel().select(list_func_tab);
			
		}
		
		if(event.getSource() == voltar_end_button) {
			
			func_tab.getTabPane().getSelectionModel().select(func_tab);
			
		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		MaskFieldUtil.cpfField(cpf_field);
		MaskFieldUtil.cepField(cep_field);

		nome_col.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpf_col.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		cargo_col.setCellValueFactory(new PropertyValueFactory<>("cargo"));
		rua_col.setCellValueFactory(new PropertyValueFactory<>("rua"));
		bairro_col.setCellValueFactory(new PropertyValueFactory<>("bairro"));
		situacao_col.setCellValueFactory(new PropertyValueFactory<>("situacao"));
		
		try {
			adapters = fachada.getAllAdapterFuncionario();
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tabela_list.getItems().setAll(adapters);
		
	}

	public void criarFuncionario() {

		end = new Endereco();

		end.setRua(rua_field.getText());
		end.setNumero(num_field.getText());
		end.setEstado(estado_field.getText());
		end.setCidade(cidade_field.getText());
		end.setCep(cep_field.getText());
		end.setBairro(bairro_field.getText());

		funcionario = new Funcionario();
		funcionario.setNome(nome_field.getText());
		funcionario.setCpf(cpf_field.getText());
		funcionario.setCargo(cargo_field.getText());
		funcionario.setLogin(login_field.getText());
		funcionario.setSenha(senha_field.getText());
		funcionario.setSituacao(situacao_cb.isSelected());
		funcionario.setEndereco(end);

	}

	public void carregarFunc() {

		adapter = tabela_list.getSelectionModel().getSelectedItem();

		try {

			func = fachada.buscarPorIdFuncionario(adapter.getId());

		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		nome_field.setText(func.getNome());
		cpf_field.setText(func.getCpf());
		cargo_field.setText(func.getCargo());
		login_field.setText(func.getLogin());
		senha_field.setText(func.getSenha());
		conf_senha_field.setText(func.getSenha());
		situacao_cb.setVisible(true);
		situacao_cb.setSelected(func.isSituacao());

		rua_field.setText(func.getEndereco().getRua());
		num_field.setText(func.getEndereco().getNumero());
		estado_field.setText(func.getEndereco().getEstado());
		cidade_field.setText(func.getEndereco().getCidade());
		cep_field.setText(func.getEndereco().getCep());
		bairro_field.setText(func.getEndereco().getBairro());

	}

	public void atualizar(Funcionario func) {

	

		func.setNome(nome_field.getText());
		func.setCpf(cpf_field.getText());
		func.setCargo(cargo_field.getText());
		func.setLogin(login_field.getText());
		func.setSenha(senha_field.getText());
		func.setSituacao(situacao_cb.isSelected());
		endereco = func.getEndereco();
		
		endereco.setRua(rua_field.getText());
		endereco.setNumero(num_field.getText());
		endereco.setEstado(estado_field.getText());
		endereco.setCidade(cidade_field.getText());
		endereco.setCep(cep_field.getText());
		endereco.setBairro(bairro_field.getText());
		
		func.setEndereco(endereco);

		try {
			fachada.editarFuncionario(func);
			Mensagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Atualizado", "Funcionário atualizado",
					"O funcionário foi atualizado com sucesso!");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao atualizar",
					"Erro ao atualizar funcionário", e.getMessage());
		}

		limparCampos();
	}

	public void limparCampos() {

		nome_field.clear();
		cpf_field.clear();
		cargo_field.clear();
		login_field.clear();
		senha_field.clear();
		conf_senha_field.clear();

		rua_field.clear();
		num_field.clear();
		estado_field.clear();
		cidade_field.clear();
		cep_field.clear();
		bairro_field.clear();

	}

}
