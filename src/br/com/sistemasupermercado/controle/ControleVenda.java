package br.com.sistemasupermercado.controle;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ControleVenda implements Initializable {

    int cont = 1;
    Caixa caixa;
    Funcionario funcionario;
    Venda venda;
    VendaTabAdapter item_produtoVenda;
    Item_Venda item_venda;
    List<Item_Venda> item_vendas;
    Pagamento pagamento;
    Cliente cliente;

    List<EstoqueTabAdapter> estoqueTabAdapters;

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


        if(event.getSource() == nova_ven_button){

            venda = new Venda();

//            venda.setCaixa_id();


            info_cx_ven_field.setText("Caixa em uso!");
            oper_vend_field.setText(ControleLogin.nomeOp());
            funcionario = ControleLogin.getFuncionario();
            item_vendas = new ArrayList<Item_Venda>();



        }

        if(event.getSource() == adic_prod_ven_button){

            try {

                EstoqueTabAdapter prod = prod_tab.getSelectionModel().getSelectedItem();
                item_produtoVenda = Fachada.getInstance().buscarPorIdVendaAdapterProduto(prod.getId());

                item_produtoVenda.setItem(cont);
                cont++;
                vend_tab.getItems().addAll(item_produtoVenda);
//                item_vendas.add(Fachada.getInstance().)
            } catch (BusinessException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {



        prod_cod_col.setCellValueFactory(new PropertyValueFactory<>("cod_barras"));
        prod_desc_col.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        prod_qtd_col.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        prod_prec_col.setCellValueFactory(new PropertyValueFactory<>("preco_unidade"));

        try {
            estoqueTabAdapters = Fachada.getInstance().getAllEstoqueAdapterProduto();
            prod_tab.getItems().addAll(estoqueTabAdapters);
        } catch (BusinessException e) {
            e.printStackTrace();
        }



        vend_item_col.setCellValueFactory(new PropertyValueFactory<>("item"));
        vend_cod_col.setCellValueFactory(new PropertyValueFactory<>("venda_cod_barras"));
        vend_desc_col.setCellValueFactory(new PropertyValueFactory<>("venda_descricao"));
        vend_qtd_col.setCellValueFactory(new PropertyValueFactory<>("venda_quantidade"));
        vend_prec_col.setCellValueFactory(new PropertyValueFactory<>("venda_preco_unidade"));

    }


}
