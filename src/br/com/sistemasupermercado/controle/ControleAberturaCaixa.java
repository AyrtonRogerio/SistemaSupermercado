package br.com.sistemasupermercado.controle;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.Caixa;
import br.com.sistemasupermercado.principal.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControleAberturaCaixa {

    Caixa caixa;
    @FXML
    private TextField valor_field;

    @FXML
    private Button abrir_caixa_button;

    @FXML
    private Button cancelar_button;

    @FXML
    void action(ActionEvent event) {

        if(event.getSource() == abrir_caixa_button){

            caixa = new Caixa();
            caixa.setEntrada(Double.parseDouble(valor_field.getText()));

            try {
                Fachada.getInstance().salvarEditarCaixa(caixa);
            } catch (BusinessException e) {
                e.printStackTrace();
            }
        }

        if(event.getSource() == cancelar_button){
            Main.changeStage("Menu");
        }
    }

}
