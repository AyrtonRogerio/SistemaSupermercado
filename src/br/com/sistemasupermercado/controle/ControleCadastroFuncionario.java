/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author ayrton
 *
 */
public class ControleCadastroFuncionario implements Initializable {

	private Funcionario funcionario;Fachada fachada = Fachada.getInstance();

	@FXML
	private Button cadastrar_func_button;

	@FXML
	private TextField nome_func_field;

	@FXML
	private TextField cpf_func_field;

	@FXML
	private TextField cargo_func_field;

	@FXML
	private TextField login_func_field;

	@FXML
	private TextField senha_func_field;

	Fachada fachada = Fachada.getInstance();

	@FXML
	void action(ActionEvent event) {
		if (event.getSource() == this.cadastrar_func_button) {
			try {
				fachada.salvarEditarFuncionario(funcionario);
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void criarFuncionario() {
		funcionario = new Funcionario();
		funcionario.setNome(nome_func_field.getText());
		funcionario.setCpf(cpf_func_field.getText());
		funcionario.setCargo(cargo_func_field.getText());
		funcionario.setLogin(login_func_field.getText());
		funcionario.setSenha(senha_func_field.getText());
	}

}
