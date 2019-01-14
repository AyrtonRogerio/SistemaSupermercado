package br.com.sistemasupermercado.controle;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Caixa;
import br.com.sistemasupermercado.principal.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControlePagamentoVenda {


    @FXML
    private static TextField valor_recebido_field;

    @FXML
    private static TextField qtd_pgmt_field;

    @FXML
    void action(ActionEvent event) {


    }

    public static double valorPago(){

        double valor = Double.parseDouble(valor_recebido_field.getText());

        return valor;
    }

    public static int qtdPgmt(){
        int qtd = Integer.parseInt(qtd_pgmt_field.getText());
        return qtd;
    }

}
