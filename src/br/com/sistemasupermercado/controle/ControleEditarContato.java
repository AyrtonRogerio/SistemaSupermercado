/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.sistemasupermercado.dao.DaoCommum;
import br.com.sistemasupermercado.enuns.TipoContato;
import br.com.sistemasupermercado.exception.DaoException;
import br.com.sistemasupermercado.model.Contato;
import br.com.sistemasupermercado.model.MaskFieldUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * @author ayrton
 *
 */
public class ControleEditarContato implements Initializable {

	public static ControleEditarContato controleEditarContato;

	Contato contato;

	@FXML
	private TextField descri_field;

	@FXML
	private TextField tipo_field;

	@FXML
	private Button salvar_button;

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == salvar_button) {

			contato.setTipo(TipoContato.getTipoContato(tipo_field.getText()));
			contato.setDescricao(descri_field.getText());
			
			try {
				DaoCommum.editarContato(contato);
			} catch (DaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

	/**
	 * @param contatos the contatos to set
	 */
	public void setContato(Contato contato) {
		this.contato = contato;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		

		controleEditarContato = this;
	}

}
