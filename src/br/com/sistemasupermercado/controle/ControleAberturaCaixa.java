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

public class ControleAberturaCaixa {

    private static Caixa caixa;
    @FXML
    private TextField valor_field;

    @FXML
    private Button abrir_caixa_button;

    @FXML
    private TextField id_caixa_field;

    @FXML
    void action(ActionEvent event) {

        if(event.getSource() == abrir_caixa_button){

            try {

                int id = Integer.parseInt(id_caixa_field.getText());
                caixa = Fachada.getInstance().buscarPorIdCaixa(id);

//                System.out.println(caixa.getEntrada());
                if(caixa == null) {
                    caixa = new Caixa();
                    caixa.setEntrada(Double.parseDouble(valor_field.getText()));
                    caixa.setSaida(0.00);
                    caixa.setSaldo(0.00);
                    Fachada.getInstance().salvarEditarCaixa(caixa);
                }
            } catch (BusinessException e) {
                e.printStackTrace();
            }
        }


    }

    public static Caixa informacaoCaixa(){
        return  caixa;
    }

}
