package br.com.sistemasupermercado.controle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleInicio implements Initializable {

	private Pane CadastroCliente;
	private Pane CadastroFuncionario;
	private Pane CadastroProduto;

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
	private MenuItem funcionario_menu;

	@FXML
	private MenuItem cliente_menu;

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

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == cliente_menu) {
			System.out.println("asdasd");
			atualizarTela("cliente");
		}

		if (event.getSource() == funcionario_menu) {
			System.out.println("Funcionario");
			atualizarTela("funcionario");
		}

		if (event.getSource() == novo_produto_menu) {
			atualizarTela("produto");
		}

		if (event.getSource() == inicioButton) {
			System.out.println("ta pegano");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			CadastroCliente = FXMLLoader.load(
					getClass().getClassLoader().getResource("br/com/sistemasupermercado/view/Cliente.fxml"));
			CadastroFuncionario = FXMLLoader.load(getClass().getClassLoader()
					.getResource("br/com/sistemasupermercado/view/Funcionario.fxml"));
			CadastroProduto = FXMLLoader.load(
					getClass().getClassLoader().getResource("br/com/sistemasupermercado/view/Produto.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualizarTela(String tela) {

		if (tela.equalsIgnoreCase("cliente")) {
			AnchorPane.setBottomAnchor(CadastroCliente, 0.0);
			AnchorPane.setLeftAnchor(CadastroCliente, 0.0);
			AnchorPane.setRightAnchor(CadastroCliente, 0.0);
			AnchorPane.setTopAnchor(CadastroCliente, 0.0);
			pane.getChildren().setAll(CadastroCliente);
		}

		if (tela.equalsIgnoreCase("funcionario")) {
			AnchorPane.setBottomAnchor(CadastroFuncionario, 0.0);
			AnchorPane.setLeftAnchor(CadastroFuncionario, 0.0);
			AnchorPane.setRightAnchor(CadastroFuncionario, 0.0);
			AnchorPane.setTopAnchor(CadastroFuncionario, 0.0);
			pane.getChildren().setAll(CadastroFuncionario);
		}

		if (tela.equalsIgnoreCase("produto")) {

			AnchorPane.setBottomAnchor(CadastroProduto, 0.0);
			AnchorPane.setLeftAnchor(CadastroProduto, 0.0);
			AnchorPane.setRightAnchor(CadastroProduto, 0.0);
			AnchorPane.setTopAnchor(CadastroProduto, 0.0);
			pane.getChildren().setAll(CadastroProduto);
		}
	}

}
