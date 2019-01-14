/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.sistemasupermercado.model.Contas_a_Receber_Adapter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * @author ayrton
 *
 */
public class ControleContasReceber implements Initializable {

	@FXML
    private Tab hist_tab;

    @FXML
    private TextField busc_hist_field;

    @FXML
    private Button busc_hist_button;

    @FXML
    private TableView<Contas_a_Receber_Adapter> hist_tabview;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter, String> hist_desc_col;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter, Double> hist_val_col;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter,Double> hist_val_pg_col;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter, Integer> hist_qt_col;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter, Integer> hist_qt_pg_col;

    @FXML
    private Tab cont_a_receb_tab;

    @FXML
    private TextField busc_cont_a_receb_field;

    @FXML
    private Button busc_cont_a_receb_button;

    @FXML
    private TableView<Contas_a_Receber_Adapter> cont_a_receb_tabview;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter, String> cont_a_receb_desc_col;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter, Double> cont_a_receb_val_col;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter, Double> cont_a_receb_val_pg_col;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter, Integer> cont_a_receb_qt_col;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter, Integer> cont_a_receb_qt_pg_col;

    @FXML
    private Tab conta_receb_tab;

    @FXML
    private TableView<Contas_a_Receber_Adapter> cont_receb_tabview;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter, String> cont_receb_desc_col;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter, Double> cont_receb_val_col;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter, Double> cont_receb_val_pg_col;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter, Integer> cont_receb_qtd_col;

    @FXML
    private TableColumn<Contas_a_Receber_Adapter, Integer> cont_receb_qtd_pg_col;


    @FXML
    void action(ActionEvent event) {

    }


	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
}
