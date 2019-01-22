package br.com.sistemasupermercado.controle;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Caixa;
import br.com.sistemasupermercado.model.Venda;
import br.com.sistemasupermercado.principal.Main;
import br.com.sistemasupermercado.view.Mensagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleInicio implements Initializable {

	private Pane CadastroCliente;
	private Pane CadastroFuncionario;
	private Pane CadastroProduto;
	private Pane ContasAPagar;
	private Pane Relatorio;
	private Pane ContasAReceber;
	private Caixa caixa;

	@FXML
	private MenuItem inicioMenu;

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
	private MenuItem relatorio_caixa_menu;

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
			atualizarTela("cliente");
		}

		if (event.getSource() == funcionario_menu) {
			atualizarTela("funcionario");
		}

		if (event.getSource() == novo_produto_menu) {
			atualizarTela("produto");
		}

		if (event.getSource() == inicioMenu) {
		}

		if(event.getSource() == nova_venda_menu){

			Dialog<Venda> vendaDialog = new Dialog<>();

			vendaDialog.initModality(Modality.NONE);
			vendaDialog.setResizable(true);
			vendaDialog.getDialogPane().setContent(Main.telaVenda());
			vendaDialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
			vendaDialog.showAndWait();
		}
		
		if(event.getSource() == financas_contas_pagar_menu) {
			atualizarTela("contasPagar");
			
		}
		
		if(event.getSource() == financas_contas_receber_menu) {
			atualizarTela("contasReceber");
		}

		if(event.getSource() == relatorio_caixa_menu) {
			atualizarTela("Relatorio");
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

			ContasAPagar = FXMLLoader.load(
					getClass().getClassLoader().getResource("br/com/sistemasupermercado/view/ContasPagar.fxml"));

			ContasAReceber = FXMLLoader.load(
					getClass().getClassLoader().getResource("br/com/sistemasupermercado/view/ContasReceber.fxml"));

			Relatorio = FXMLLoader.load(
					getClass().getClassLoader().getResource("br/com/sistemasupermercado/view/Relatorio.fxml"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro em Componentes", "Erro ao carregar componentes!", e.getMessage());
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
		
		if (tela.equalsIgnoreCase("contasPagar")) {

			AnchorPane.setBottomAnchor(ContasAPagar, 0.0);
			AnchorPane.setLeftAnchor(ContasAPagar, 0.0);
			AnchorPane.setRightAnchor(ContasAPagar, 0.0);
			AnchorPane.setTopAnchor(ContasAPagar, 0.0);
			pane.getChildren().setAll(ContasAPagar);
		}
		
		if (tela.equalsIgnoreCase("contasReceber")) {

			AnchorPane.setBottomAnchor(ContasAReceber, 0.0);
			AnchorPane.setLeftAnchor(ContasAReceber, 0.0);
			AnchorPane.setRightAnchor(ContasAReceber, 0.0);
			AnchorPane.setTopAnchor(ContasAReceber, 0.0);
			pane.getChildren().setAll(ContasAReceber);
		}
		
		if (tela.equalsIgnoreCase("Relatorio")) {

			AnchorPane.setBottomAnchor(Relatorio, 0.0);
			AnchorPane.setLeftAnchor(Relatorio, 0.0);
			AnchorPane.setRightAnchor(Relatorio, 0.0);
			AnchorPane.setTopAnchor(Relatorio, 0.0);
			pane.getChildren().setAll(Relatorio);
		}
	}


}
