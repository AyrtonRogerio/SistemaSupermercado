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
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	private static Pane login;
	private static Pane inicio;
	private static Pane cadastroFornecedor;
	private static Scene sceneLogin;
	private static Scene sceneMenu;
	private static Scene sceneFornecedor;
	private static Stage stage;
	
    public static void main(String[] args) {
        launch(args);
        IFachada fachada = Fachada.getInstance();
//        System.out.println("ssss");
//        Funcionario funcionario = new Funcionario();
//        funcionario.setNome("Joao");
//        funcionario.setCpf("22222552400");
//        funcionario.setCargo("Caixa");
//        funcionario.setLogin("admi2n");
//        funcionario.setSenha("adm2in");
      
//        Fornecedor fornecedor = new Fornecedor();
//        fornecedor.setNome("Pajeu");
//        fornecedor.setRazao_social("Pajeu LTDA");
//        fornecedor.setCnpj("12311678903334");
//        fornecedor.setEstado("PE");
//        fornecedor.setCidade("Serra Talhada");
//        System.out.println(fornecedor.getNome());
//		System.out.println(fornecedor.getRazao_social());
//		System.out.println(fornecedor.getCnpj());
//		System.out.println(fornecedor.getEstado());
//		System.out.println(fornecedor.getCidade());
        
//        Cliente cliente = new Cliente();
//        Endereco endereco = new Endereco();
//        Contato contato = new Contato();
//        Contato contato2 = new Contato();
//        List<Contato> contatos = new ArrayList<>();
////        
//        cliente.setNome("Maria");
//        cliente.setCpf("54566133122");
//        endereco.setCep("56460000");
//        endereco.setRua("Magalhaes Cordeiro Quirino ");
//        endereco.setNumero("1200");
//        endereco.setBairro("ISEP");
//        endereco.setCidade("Serra Talhada");
//        endereco.setEstado("PE");
//        
//        contato.setCliente(cliente);
//        contato.setTipo(TipoContato.EMAIL);
//        contato.setDescricao("ayrton.rogerio1@gmail.com");
//        
//        contato2.setCliente(cliente);
//        contato2.setTipo(TipoContato.FACEBOOK);
//        contato2.setDescricao("Ayrton Rogerio");
//
//        contatos.add(contato);
//        contatos.add(contato2);
//        
//        
//        cliente.setEndereco(endereco);
//        cliente.setContatos(contatos);
        
        try {
//			fachada.salvarEditarFuncionario(funcionario);
//			fachada.salvarEditarFornecedor(fornecedor);
//			fachada.salvarEditarCliente(cliente);
			
				        
	        
//			DaoCommum.salvarContato(contato, cliente.getId());
//			DaoCommum.salvarContato(contato2, cliente.getId());
//			System.out.println("----------------");
			
//			fachada.buscarPorIdFuncionario(1);
//			System.out.println("0-----------------------");
//			fachada.buscarPorIdFuncionario(2);
			fachada.buscarPorIdCliente(1);
//			fachada.buscarPorIdFornecedor(1);
			
//			System.out.println("2-----------------------");
//			fachada.getAllFuncionario();
//			fachada.getAllCliente();
//			System.out.println("3-----------------------");
//			fachada.getAllFornecedor();
			
//			DaoCommum.buscarContato(contato);
//			DaoCommum.buscarContato(contato2);
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
    }

    @Override
    public void start(Stage primaryStage) {
    	try {
			
    		login = FXMLLoader.load(getClass().getClassLoader().getResource
    				("br/com/sistemasupermercado/view/Login.fxml"));
    		
			inicio = FXMLLoader.load(getClass().getClassLoader().getResource
					("br/com/sistemasupermercado/view/Inicio.fxml"));
			
			cadastroFornecedor = FXMLLoader.load(getClass().getClassLoader().getResource
					("br/com/sistemasupermercado/view/CadastrarFornecedor.fxml"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	sceneLogin = new Scene(login);
    	sceneMenu = new Scene(inicio);
//    	sceneFornecedor = new Scene(cadastroFornecedor);
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
    
    public static Pane telaFornecedor() {
    	
    	return cadastroFornecedor;
    }
    
}
