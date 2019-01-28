/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.net.URL;
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
import javafx.scene.control.Alert.AlertType;

/**
 * @author ayrton
 *
 */
public class ControleFuncionario implements Initializable {

	private Funcionario funcionario;
	private FuncionarioAdapter adapter;
	private Endereco end;
	private Fachada fachada = Fachada.getInstance();

	@FXML
    private Tab list_func_tab;

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
		
		
		if (event.getSource() == cadast_func_button) {
			try {
				
				if(senha_field.getText().equals(conf_senha_field.getText())) {

					int end_id = DaoCommum.salvarEndereco(end);
					fachada.salvarFuncionario(funcionario,end_id);
				} else {
					Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao Salvar", "Erro ao salvar o funcionário", "As senhas não correspondem!");
				}
				Mensagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Salvo", "Funcionário salvo", "O funcionário foi salvo com sucesso!");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao Salvar", "Erro ao salvar o funcionário", e.getMessage());
			} catch (ValidacaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao salvar", "Informações inválidas!", e.getMessage());

			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao salvar", "Erro ao salvar endereço do funcionário", e.getMessage());
			}
		}
	
		if(event.getSource() == editar_button) {
						
			try {
				
				adapter = tabela_list.getSelectionModel().getSelectedItem();
				funcionario = fachada.buscarPorIdFuncionario(adapter.getId());
				
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
    
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		
		MaskFieldUtil.cpfField(cpf_field);
		MaskFieldUtil.cepField(cep_field);
		
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

	public void carregarFunc(Funcionario funcionario, Endereco endereco) {
		
		nome_field.setText(funcionario.getNome());
		cpf_field.setText(funcionario.getCpf());
		cargo_field.setText(funcionario.getCargo());
		login_field.setText(funcionario.getLogin());
		senha_field.setText(funcionario.getSenha());
		conf_senha_field.setText(funcionario.getSenha());
		situacao_cb.setSelected(funcionario.isSituacao());
		
		rua_field.setText(endereco.getRua());
		num_field.setText(endereco.getNumero());
		estado_field.setText(endereco.getEstado());
		cidade_field.setText(endereco.getCidade());
		cep_field.setText(endereco.getCep());
		bairro_field.setText(endereco.getBairro());
		
	}
	
}
