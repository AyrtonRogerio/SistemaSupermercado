/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Fornecedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author ayrton
 *
 */
public class ControleFornecedor implements Initializable{

		private Fachada fachada = Fachada.getInstance();
		private Fornecedor fornecedor;
	
	  @FXML
	    private Button cadastrar_forn_button;

	    @FXML
	    private TextField nome_forn_field;

	    @FXML
	    private TextField razao_social_forn_field;

	    @FXML
	    private TextField cnpj_forn_field;

	    @FXML
	    private TextField cidade_forn_field;

	    @FXML
	    private TextField estado_forn_field;

	    @FXML
	    void action(ActionEvent event) {

	    	cadastrarFornecedor();
	    	if(event.getSource() == cadastrar_forn_button) {
	    		
	    		try {
					fachada.salvarEditarFornecedor(fornecedor);
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	    		nome_forn_field.clear();
	    		razao_social_forn_field.clear();
	    		cnpj_forn_field.clear();
	    		cidade_forn_field.clear();
	    		estado_forn_field.clear();

	    	}
	    	
	    }
	
	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	public void cadastrarFornecedor() {
		
		fornecedor = new Fornecedor();
		
		fornecedor.setNome(nome_forn_field.getText());
		fornecedor.setRazao_social(razao_social_forn_field.getText());
		fornecedor.setCnpj(cnpj_forn_field.getText());
		fornecedor.setCidade(cidade_forn_field.getText());
		fornecedor.setEstado(estado_forn_field.getText());
		
		
		
		
	}
	
}
