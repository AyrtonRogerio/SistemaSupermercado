package br.com.sistemasupermercado.controle;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.*;
import br.com.sistemasupermercado.principal.Main;
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
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControleVenda implements Initializable {

    int cont = 1;
    int venda_id = 0;

    Caixa caixa;
    Funcionario funcionario;
    Venda venda;
    VendaTabAdapter item_produtoVendaTabela;
    Item_Produto item_produto;
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

            try {
                caixa = ControleAberturaCaixa.informacaoCaixa();
                venda = new Venda();
                funcionario = ControleLogin.getFuncionario();
                item_vendas = new ArrayList<Item_Venda>();

                cliente = Fachada.getInstance().buscarPorIdCliente(1);

                java.util.Date date = new Date();
                venda.setData_venda(date);
                System.out.println(venda.getData_venda());
                venda.setCaixa_id(caixa);
                venda.setFuncionario_id(funcionario);
                venda.setCliente_id(cliente);
                venda.setValor_total(0.00);
                venda.setValor_troco(0.00);
                venda.setDesc_geral(0.00);
                venda.setItem_vendas(item_vendas);
                venda_id = Fachada.getInstance().salvarEditarVenda(venda, cliente.getId(), funcionario.getId(), caixa.getId());

            } catch (BusinessException e) {
                e.printStackTrace();
            }


            info_cx_ven_field.setText("Caixa em uso!");
            oper_vend_field.setText(ControleLogin.nomeOp());




        }

        if(event.getSource() == adic_prod_ven_button){

            try {

                item_venda = new Item_Venda();
                EstoqueTabAdapter prod = prod_tab.getSelectionModel().getSelectedItem();

                item_produto = Fachada.getInstance().buscarPorIdItemProduto(prod.getId());

                item_produtoVendaTabela = Fachada.getInstance().buscarPorIdVendaAdapterProduto(prod.getId());
                item_produtoVendaTabela.setItem(cont);
                cont++;
                vend_tab.getItems().addAll(item_produtoVendaTabela);


                item_venda.setDesconto(false);
                item_venda.setProc_promoc(0.00);
                item_venda.setPromocao(false);
                item_venda.setQuantidade(Integer.parseInt(qtd_prod_ven_field.getText()));
                item_venda.setTipo("n sei");
                item_venda.setValor_desc(0.00);
                item_venda.setValor_item(item_produto.getPorc_varejo());
                item_venda.setItem_produto_id(item_produto);

                item_venda.setVenda_id(venda);


                Fachada.getInstance().salvarEditar_Item_Venda(item_venda, venda_id, item_produto.getId());
                item_vendas.add(item_venda);

                pr_un_prod_ven_field.setText(String.valueOf(item_venda.getValor_item()));
                pr_total_vend_field.setText(String.valueOf(item_venda.getValor_item() * item_venda.getQuantidade()));


            } catch (BusinessException e) {
                e.printStackTrace();
            }
        }

        if(event.getSource() == fin_ven_button){





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
            prod_tab.getItems().setAll(estoqueTabAdapters);
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
