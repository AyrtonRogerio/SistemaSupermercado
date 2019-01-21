package br.com.sistemasupermercado.controle;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.*;
import br.com.sistemasupermercado.principal.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class ControleVenda implements Initializable {

    private int cont = 1;
    private int venda_id = 0;
    private double valor_total = 0.00, valorTemp = 0.00;
    private int qt;

    private Caixa caixa;
    private Funcionario funcionario;
    private Venda venda;
    private VendaTabAdapter item_produtoVendaTabela;
    private Item_Produto item_produto;
    private Item_Venda item_venda;
    private List<Item_Venda> item_vendas;
    private Pagamento pagamento;
    private Cliente cliente;
    private Contas_a_receber contas_a_receber;

    List<EstoqueTabAdapter> estoqueTabAdapters;

    @FXML
    private TextField qtd_prod_ven_field;

    @FXML
    private TextField pr_un_prod_ven_field;

    @FXML
    private TextField pr_total_vend_field;

    @FXML
    private TextField valor_pago_field;

    @FXML
    private TextField qtd_pgmt_field;
    
    @FXML
    private DatePicker dataPag;
    
    @FXML
    private DatePicker dataVenc;

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
                caixa = ControleLogin.getCaixa();
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
                venda.setValor_recebido(0.00);
                venda.setItem_vendas(item_vendas);
                System.out.println(venda);
                System.out.println(cliente.getId());
                System.out.println(funcionario.getId());
                System.out.println(caixa.getId());
                venda_id = Fachada.getInstance().salvarVenda(venda, cliente.getId(), funcionario.getId(), caixa.getId());

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

                item_produto.setVendidos(item_produto.getVendidos() + Integer.parseInt(qtd_prod_ven_field.getText()));

                Fachada.getInstance().atualizarVendidos_Item_Produto(item_produto);

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

                for(int i = 0; i < item_venda.getQuantidade(); i++) {
                    Fachada.getInstance().salvar_Item_Venda(item_venda, venda_id, item_produto.getId());
                    item_vendas.add(item_venda);
                }
              

                valor_total += item_venda.getValor_item() * item_venda.getQuantidade();
                pr_total_vend_field.setText(String.valueOf(valor_total));
                venda.setValor_total(valor_total);
                venda.setItem_vendas(item_vendas);
                qtd_prod_ven_field.setText("1");
                pr_un_prod_ven_field.clear();
                
            } catch (BusinessException e) {
                e.printStackTrace();
            }
        }

        if(event.getSource() == fin_ven_button){

            contas_a_receber = new Contas_a_receber();

            qt = Integer.parseInt(qtd_pgmt_field.getText());

            venda.setValor_recebido(Double.parseDouble(valor_pago_field.getText()));


            if(venda.getValor_recebido() >= venda.getValor_total() && qt == 1) {

                venda.setValor_troco(venda.getValor_recebido() - venda.getValor_total());
                contas_a_receber.setValor_total(venda.getValor_total());
                contas_a_receber.setValor_pago(venda.getValor_total());
                contas_a_receber.setQtd_pagmt(qt);
                contas_a_receber.setQtd_pag(qt);
              
//                contas_a_receber.setData_pag(new Date());
//                contas_a_receber.setData_venc(new Date());
                contas_a_receber.setSaldo(contas_a_receber.getValor_pago());
                contas_a_receber.setAtivo(false);

            } else if(venda.getValor_recebido() < venda.getValor_total() && qt > 1){

                venda.setValor_troco(0.00);

                valorTemp = venda.getValor_total() / qt;

                contas_a_receber.setQtd_pagmt(qt);
                contas_a_receber.setQtd_pag(1);
                contas_a_receber.setValor_total(venda.getValor_total());
                contas_a_receber.setValor_pago(valorTemp);
                contas_a_receber.setSaldo(contas_a_receber.getValor_pago());
                contas_a_receber.setAtivo(true);

            }

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            try {
            	contas_a_receber.setData_pag(format.parse(dataPag.getEditor().getText().trim()));
				contas_a_receber.setData_venc(format.parse(dataVenc.getEditor().getText().trim()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            contas_a_receber.setId_venda(venda);
            contas_a_receber.setId_caixa(caixa);
            contas_a_receber.setDesc("Conta a receber do cliente em relação a venda" );

            System.out.println(contas_a_receber);
            System.out.println(caixa);
            System.out.println(cliente);
            System.out.println(venda_id);
            System.out.println(contas_a_receber.getData_pag());
            System.out.println(contas_a_receber.getData_venc());
            

            try {

                Fachada.getInstance().editar_Venda(venda);
                venda = Fachada.getInstance().buscarPorIdVenda(venda_id);
                Fachada.getInstance().salvarConta_a_Receber(contas_a_receber,caixa.getId(),venda.getId());
                caixa.setEntrada(caixa.getEntrada() + contas_a_receber.getValor_pago());
                
                Fachada.getInstance().editarCaixa(caixa);
                limparCampos();
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



    public void limparCampos() {
    	
    	cont = 0; 
    	
    	qtd_prod_ven_field.setText("1");

    	info_cx_ven_field.setText("Caixa Livre!");
    	 
        pr_un_prod_ven_field.clear();

        pr_total_vend_field.clear();

        valor_pago_field.clear();
         
        vend_tab.getItems().clear();

        qtd_pgmt_field.setText("1");
    	
    	
    }





}
