package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Funcionario;
import br.com.sistemasupermercado.principal.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleLogin implements Initializable{

	private Fachada fachada = Fachada.getInstance();
	
	@FXML
    private TextField login_field;

    @FXML
    private PasswordField senha_pass_field;

    @FXML
    private Button logarButton;

    @FXML
    void action(ActionEvent event) {
    	
    	if(event.getSource() == logarButton) {
    		if(efetuarLogin())
    		Main.changeStage("Menu");
    	}
    	else {
    		{
    			System.out.println("eita");
//    			Main.changeStage("");
    		}
		}
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public boolean efetuarLogin() {
		Funcionario funcionario;
		try {
			funcionario = fachada.buscarPorLoginFuncionario(login_field.getText(), senha_pass_field.getText());
			if(funcionario == null) {
				return false;
			}
			return true;
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("controle login");
			return false;
		}
		
		
	}
	
	
}
