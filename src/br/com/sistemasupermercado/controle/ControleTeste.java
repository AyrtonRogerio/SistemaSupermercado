package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControleTeste implements Initializable{

	@FXML
    private Button button;

    @FXML
    void action(ActionEvent event) {
    	System.out.println("click");
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
