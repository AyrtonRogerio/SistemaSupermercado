package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.sistemasupermercado.principal.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleLogin implements Initializable{

	@FXML
    private TextField login_field;

    @FXML
    private PasswordField senha_pass_field;

    @FXML
    private Button logarButton;

    @FXML
    void action(ActionEvent event) {
    	System.out.println("click");
    	Main.changeStage("Menu");
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
