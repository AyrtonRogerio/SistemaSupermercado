/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Cliente;
import br.com.sistemasupermercado.model.Contato;
import br.com.sistemasupermercado.model.Endereco;
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
	
	private Cliente cliente;
	private Endereco endereco;
	private Contato contato;
	private List<Contato> contatos;
	

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
	
	Fachada fachada = Fachada.getInstance();

	@FXML
    void action(ActionEvent event) {

    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	public void cadastrarCliente() {
		cliente = new Cliente();
		
		cliente.setNome(nome_cliente_field.getText());
		cliente.setCpf(cpf_cliente_field.getText());
		
		endereco = new Endereco();
		
		endereco.setRua();
		
		contato = new Contato();
		contatos = new ArrayList<>();
		
	}

}
