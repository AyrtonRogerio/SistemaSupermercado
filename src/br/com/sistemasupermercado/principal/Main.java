package br.com.sistemasupermercado.principal;

import java.io.IOException;

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
