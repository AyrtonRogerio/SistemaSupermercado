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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
	    private TextField nome_cliente_field;

	    @FXML
	    private TextField cpf_cliente_field;

	    @FXML
	    private ComboBox<?> sexo_combo_cliente;

	    @FXML
	    private ComboBox<?> estad_civ_ccombo_client;

	    @FXML
	    private ComboBox<?> ocupacao_combo_cliente;

	    @FXML
	    private DatePicker data_cliente;

	    @FXML
	    private Button voltar_cliente_button;

	    @FXML
	    private Button continuar_cliente_button;

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
	    private TextField estado_end_cliente_field;

	    @FXML
	    private Button voltar_end_clien_button;

	    @FXML
	    private Button contin_end_clien_button;

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
		
		endereco.setRua(rua_end_cliente_field.getText());
		
		
		contato = new Contato();
		contatos = new ArrayList<>();
		
	}

}
