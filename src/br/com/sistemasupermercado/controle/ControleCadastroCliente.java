/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * @author ayrton
 *
 */
public class ControleCadastroCliente implements Initializable {

	@FXML
	private ComboBox<?> tipo_contato_combo;

	@FXML
	private TextField tipo_contato_cliente_field;

	@FXML
	private TextField nome_cliente_field;

	@FXML
	private TextField cpf_cliente_field;

	@FXML
	private TextField endereco_cliente_field;

	@FXML
	private TextField cep_cliente_field;

	@FXML
	private TextField numero_cliente_field;

	@FXML
	private TextField bairro_cliente_field;

	@FXML
	private TextField ciadade_cliente_field;

	@FXML
	private TextField estado_cliente_field;

	@FXML
    void action(ActionEvent event) {

    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
