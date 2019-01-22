/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author ayrton
 *
 */
public class ControleEditarContato implements Initializable {

	@FXML
	private TextField fone_field;

	@FXML
	private TextField email_field;

	@FXML
	private Button salvar_button;

	@FXML
	void action(ActionEvent event) {

		
		if(event.getSource() == salvar_button) {
			
			
			
		}
		
		
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
