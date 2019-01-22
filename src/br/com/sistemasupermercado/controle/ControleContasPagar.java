/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.io.FileNotFoundException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.crypto.CipherInputStream;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Contas_a_Pagar_Adapter;
import br.com.sistemasupermercado.model.ProdutoTabAdapter;
import br.com.sistemasupermercado.view.Mensagem;
import br.com.sistemasupermercado.view.Relatorio_Contas_Pagar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import net.sf.jasperreports.engine.JRException;

/**
 * @author ayrton
 *
 */
public class ControleContasPagar implements Initializable {

	private List<Contas_a_Pagar_Adapter> contas_a_Pagar_All = new ArrayList<>();
	private List<Contas_a_Pagar_Adapter> contas_a_Pagar_List = new ArrayList<>();
	private List<Contas_a_Pagar_Adapter> contas_a_Pagar_Paga = new ArrayList<>();
	

    @FXML
    private Tab hist_tab;

    @FXML
    private TextField busc_hist_field;

    @FXML
    private Button busc_hist_button;

    @FXML
    private TableView<Contas_a_Pagar_Adapter> hist_tabview;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, String> hist_desc_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Double> hist_val_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Double> hist_val_pg_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Integer> hist_qt_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Integer> hist_qt_pg_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Date> hist_data_venc_col;

    @FXML
    private Tab cont_a_pagar_tab;

    @FXML
    private TextField busc_cont_a_pagar_field;

    @FXML
    private Button busc_cont_a_pagar_button;
    
    @FXML
    private Button gerar_rel_button;

    @FXML
    private TableView<Contas_a_Pagar_Adapter> cont_a_pagar_tabview;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, String> cont_a_pagar_desc_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Double> cont_a_pagar_val_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Double> cont_a_pagar_val_pg_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Integer> cont_a_pagar_qt_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Integer> cont_a_pagar_qt_pg_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Date> cont_a_pagar_data_ven_col;

    @FXML
    private Tab conta_paga_tab;

    @FXML
    private TableView<Contas_a_Pagar_Adapter> cont_paga_tabview;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, String> cont_paga_desc_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Double> cont_paga_val_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Double> cont_paga_val_pg_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Integer> cont_paga_qtd_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Integer> cont_paga_qtd_pg_col;

    @FXML
    private TableColumn<Contas_a_Pagar_Adapter, Date> cont_paga_data_venc_col;

    @FXML
    void action(ActionEvent event) {

    	
    	if(event.getSource() == busc_hist_field) {
    		
    		
    		
    		
    	}
    	
    	
    	
    	if(event.getSource() == gerar_rel_button) {
    		
    		Relatorio_Contas_Pagar contas_Pagar = new Relatorio_Contas_Pagar();
    		
    		try {
				contas_Pagar.gerarDocumento(contas_a_Pagar_List, "Contas_a_pagar.jrxml");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Mensagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Gerar relatório", "Erro ao gerar relatório","Arquivo não encontrado " + e.getMessage());
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	
    	
    }

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		hist_desc_col.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		hist_val_col.setCellValueFactory(new PropertyValueFactory<>("valor"));
		hist_val_pg_col.setCellValueFactory(new PropertyValueFactory<>("valor_quitado"));
		hist_qt_col.setCellValueFactory(new PropertyValueFactory<>("qtd_pgmt"));
		hist_qt_pg_col.setCellValueFactory(new PropertyValueFactory<>("qtd_paga"));
		hist_data_venc_col.setCellValueFactory(new PropertyValueFactory<>("data_vencimento"));

		hist_data_venc_col.setCellFactory(coluna -> {

			return new TableCell<Contas_a_Pagar_Adapter, Date>() {
				protected void updateItem(Date item, boolean empty) {

					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(new SimpleDateFormat("dd/MM/yyyy").format(item));
					}
				}
			};
		});

		try {
			contas_a_Pagar_All = Fachada.getInstance().getAllConta_a_Pagar();
			hist_tabview.getItems().setAll(contas_a_Pagar_All);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		cont_a_pagar_desc_col.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		cont_a_pagar_val_col.setCellValueFactory(new PropertyValueFactory<>("valor"));
		cont_a_pagar_val_pg_col.setCellValueFactory(new PropertyValueFactory<>("valor_quitado"));
		cont_a_pagar_qt_col.setCellValueFactory(new PropertyValueFactory<>("qtd_pgmt"));
		cont_a_pagar_qt_pg_col.setCellValueFactory(new PropertyValueFactory<>("qtd_paga"));
		cont_a_pagar_data_ven_col.setCellValueFactory(new PropertyValueFactory<>("data_vencimento"));
		

		cont_a_pagar_data_ven_col.setCellFactory(coluna -> {

			return new TableCell<Contas_a_Pagar_Adapter, Date>() {
				protected void updateItem(Date item, boolean empty) {

					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(new SimpleDateFormat("dd/MM/yyyy").format(item));
					}
				}
			};
		});

		try {
			contas_a_Pagar_List = Fachada.getInstance().getAll_A_PagarConta_a_Pagar();
			cont_a_pagar_tabview.getItems().setAll(contas_a_Pagar_List);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		cont_paga_desc_col.setCellValueFactory(new PropertyValueFactory<>("descricao"));
		cont_paga_val_col.setCellValueFactory(new PropertyValueFactory<>("valor"));
		cont_paga_val_pg_col.setCellValueFactory(new PropertyValueFactory<>("valor_quitado"));
		cont_paga_qtd_col.setCellValueFactory(new PropertyValueFactory<>("qtd_pgmt"));
		cont_paga_qtd_pg_col.setCellValueFactory(new PropertyValueFactory<>("qtd_paga"));
		cont_paga_data_venc_col.setCellValueFactory(new PropertyValueFactory<>("data_vencimento"));
		

		cont_paga_data_venc_col.setCellFactory(coluna -> {

			return new TableCell<Contas_a_Pagar_Adapter, Date>() {
				protected void updateItem(Date item, boolean empty) {

					super.updateItem(item, empty);

					if (item == null || empty) {
						setText(null);
					} else {
						setText(new SimpleDateFormat("dd/MM/yyyy").format(item));
					}
				}
			};
		});

		try {
			contas_a_Pagar_Paga = Fachada.getInstance().getAll_PagaConta_a_Pagar();
			cont_paga_tabview.getItems().setAll(contas_a_Pagar_Paga);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
	}
	
}
