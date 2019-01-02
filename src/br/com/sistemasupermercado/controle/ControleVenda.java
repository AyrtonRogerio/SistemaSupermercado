package br.com.sistemasupermercado.controle;

import br.com.sistemasupermercado.model.EstoqueTabAdapter;
import br.com.sistemasupermercado.model.VendaTabAdapter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class ControleVenda implements Initializable {

    @FXML
    private TextField qtd_prod_ven_field;

    @FXML
    private TextField pr_un_prod_ven_field;

    @FXML
    private TextField pr_total_vend_field;

    @FXML
    private Button nova_ven_button;

    @FXML
    private Button canc_ven_button;

    @FXML
    private Button fin_ven_button;

    @FXML
    private TableView<EstoqueTabAdapter> prod_tab;

    @FXML
    private TableColumn<EstoqueTabAdapter, Integer> prod_cod_col;

    @FXML
    private TableColumn<EstoqueTabAdapter, String> prod_desc_col;

    @FXML
    private TableColumn<EstoqueTabAdapter, Integer> prod_qtd_col;

    @FXML
    private TableColumn<EstoqueTabAdapter, Double> prod_prec_col;

    @FXML
    private TableView<VendaTabAdapter> vend_tab;

    @FXML
    private TableColumn<VendaTabAdapter, Integer> vend_item_col;

    @FXML
    private TableColumn<VendaTabAdapter, Integer> vend_cod_col;

    @FXML
    private TableColumn<VendaTabAdapter, String> vend_desc_col;

    @FXML
    private TableColumn<VendaTabAdapter, Integer> vend_qtd_col;

    @FXML
    private TableColumn<VendaTabAdapter, Double> vend_prec_col;

    @FXML
    private Button rem_prod_ven_button;

    @FXML
    private TextField busc_prod_ven_field;

    @FXML
    private Button busc_prod_ven_button;

    @FXML
    private Button adic_prod_ven_button;

    @FXML
    private TextField info_cx_ven_field;

    @FXML
    private TextField oper_vend_field;

    @FXML
    void action(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
