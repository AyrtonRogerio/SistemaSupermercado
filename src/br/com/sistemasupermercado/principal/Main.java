package br.com.sistemasupermercado.principal;

import java.io.IOException;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.fachada.IFachada;
import br.com.sistemasupermercado.model.Funcionario;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	private Pane teste;
	private Scene sceneTeste;
	
    public static void main(String[] args) {
        launch(args);
        IFachada fachada = Fachada.getInstance();
        
        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Ayrton");
        funcionario.setCpf("11111111111");
        funcionario.setCargo("aafadf");
      
        
        
        try {
			fachada.salvarEditarFuncionario(funcionario);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
    }

    @Override
    public void start(Stage primaryStage) {
    	try {
			teste = FXMLLoader.load(getClass().getClassLoader().getResource("br/com/sistemasupermercado/view/Teste.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	sceneTeste = new Scene(teste);
    	primaryStage.setScene(sceneTeste);
    	primaryStage.centerOnScreen();
    	primaryStage.show();
    	
    }
}
