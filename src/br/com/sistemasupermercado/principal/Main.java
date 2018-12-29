package br.com.sistemasupermercado.principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemasupermercado.dao.DaoCommum;
import br.com.sistemasupermercado.enuns.TipoContato;
import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.fachada.IFachada;
import br.com.sistemasupermercado.model.Cliente;
import br.com.sistemasupermercado.model.Contato;
import br.com.sistemasupermercado.model.Endereco;
import br.com.sistemasupermercado.model.Fornecedor;
import br.com.sistemasupermercado.model.Funcionario;
import br.com.sistemasupermercado.model.Item_Produto;
import br.com.sistemasupermercado.model.Produto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	private static Pane login;
	private static Pane inicio;
	private static Pane cadastroFornecedor;
	private static Pane venda;
	private static Scene sceneLogin;
	private static Scene sceneMenu;
	private static Scene sceneVenda;
	private static Stage stage;
	private static Stage stage2;
	
    public static void main(String[] args) {
        launch(args);
        IFachada fachada = Fachada.getInstance();

       

    }

    @Override
    public void start(Stage primaryStage) {
    	try {
			
    		login = FXMLLoader.load(getClass().getClassLoader().getResource
    				("br/com/sistemasupermercado/view/Login.fxml"));
    		
			inicio = FXMLLoader.load(getClass().getClassLoader().getResource
					("br/com/sistemasupermercado/view/Inicio.fxml"));
			
			cadastroFornecedor = FXMLLoader.load(getClass().getClassLoader().getResource
					("br/com/sistemasupermercado/view/Fornecedor.fxml"));

			venda = FXMLLoader.load(getClass().getClassLoader().getResource
					("br/com/sistemasupermercado/view/Venda.fxml"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	sceneLogin = new Scene(login);
    	sceneMenu = new Scene(inicio);
    	primaryStage.setScene(sceneLogin);
    	primaryStage.centerOnScreen();
    	primaryStage.show();
    	stage = primaryStage;

    	
    }
    
    public static void changeStage(String nomeTela) {
    	
    	if(nomeTela.equals("Menu")) {
    		stage.setScene(sceneMenu);
    		
    	}
    	
    }

    public static Pane telaVenda(){

		return venda;
	}

    public static Pane telaFornecedor() {
    	
    	return cadastroFornecedor;
    }
    
}
