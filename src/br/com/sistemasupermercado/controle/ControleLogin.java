package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Caixa;
import br.com.sistemasupermercado.model.Funcionario;
import br.com.sistemasupermercado.principal.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleLogin implements Initializable {

	private Fachada fachada = Fachada.getInstance();
	private static Funcionario funcionario;
	private static Caixa caixa;

	@FXML
	private TextField login_field;

	@FXML
	private PasswordField senha_pass_field;

	@FXML
	private Button logarButton;

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == logarButton) {
			if (efetuarLogin()) {
				Main.changeStage("Menu");
				abrirCaixa();
			}

		} else {
			{
				System.out.println("eita");

			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public boolean efetuarLogin() {

		try {
			funcionario = fachada.buscarPorLoginFuncionario(login_field.getText(), senha_pass_field.getText());

			if (funcionario == null) {
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

	public void abrirCaixa(){

		try {
			java.sql.Date date = new Date(new java.util.Date().getTime());

			caixa = fachada.buscarPorDataCaixa(date);
			if (caixa == null){
				System.out.println("Novo Caixa");
				java.util.Date d = new java.util.Date();
				caixa = new Caixa();
				caixa.setEntrada(0.00);
				caixa.setSaida(0.00);
				caixa.setSaldo(caixa.getEntrada() - caixa.getSaida());
				caixa.setData_abertura(d);
				caixa.setData_fechamento(d);

				fachada.salvarEditarCaixa(caixa, funcionario.getId());
			}

		} catch (BusinessException e) {
			e.printStackTrace();
		}

	}

	public static  Funcionario getFuncionario(){
		return funcionario;
	}

	public static Caixa getCaixa(){return caixa;}

	public static int getIdCaixa(){
		return caixa.getId();
	}

	public static String nomeOp(){

		return  funcionario.getNome().toString();
	}
}
