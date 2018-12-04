package br.com.sistemasupermercado.controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleInicio implements Initializable {

	@FXML
	private Menu inicioButton;

	@FXML
	private MenuItem novo_produto_menu;

	@FXML
	private MenuItem exibir_produto_menu;

	@FXML
	private MenuItem alterar_produto_menu;

	@FXML
	private MenuItem remover_produto_menu;

	@FXML
	private MenuItem nova_venda_menu;

	@FXML
	private MenuItem historico_venda_menu;

	@FXML
	private MenuItem relatorio_venda_menu;

	@FXML
	private MenuItem novo_cliente_menu;

	@FXML
	private MenuItem financas_caixa_menu;

	@FXML
	private MenuItem financas_contas_pagar_menu;

	@FXML
	private MenuItem financas_contas_receber_menu;

	@FXML
	private MenuItem ajuda_menu;

	@FXML
	private AnchorPane pane;

	private Pane CadastroCliente;

	@FXML
	void action(ActionEvent event) {

		if(event.getSource() == novo_cliente_menu) {
		atualizarTela("");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			CadastroCliente = FXMLLoader.load(getClass().getClassLoader()
					.getResource("br/com/sistemasupermercado/view/CadastroFuncionario.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualizarTela(String tela) {

		AnchorPane.setBottomAnchor(CadastroCliente, 0.0);
		AnchorPane.setLeftAnchor(CadastroCliente, 0.0);
		AnchorPane.setRightAnchor(CadastroCliente, 0.0);
		AnchorPane.setTopAnchor(CadastroCliente, 0.0);

		pane.getChildren().setAll(CadastroCliente);
	}

}
