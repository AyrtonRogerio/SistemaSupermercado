/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.sistemasupermercado.enuns.TipoContato;
import br.com.sistemasupermercado.model.Contato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author ayrton
 *
 */
public class ControleContatos implements Initializable{

    @FXML
    private TableView<Contato> tabela_contato;

    @FXML
    private TableColumn<Contato, TipoContato> tipo_col;

    @FXML
    private TableColumn<Contato, String> contato_col;

    @FXML
    private Button editar_button;

    @FXML
    void action(ActionEvent event) {

    	
    	if(event.getSource() == editar_button) {
    		
    		
    		
    	}
    	
    }

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		tipo_col.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		contato_col.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		
	}

}
