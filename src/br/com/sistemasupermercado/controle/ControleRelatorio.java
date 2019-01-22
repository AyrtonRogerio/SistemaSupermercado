/**
 * 
 */
package br.com.sistemasupermercado.controle;

import java.io.FileNotFoundException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.com.sistemasupermercado.exception.BusinessException;
import br.com.sistemasupermercado.fachada.Fachada;
import br.com.sistemasupermercado.model.RelatorioFinanceiro;
import br.com.sistemasupermercado.view.RelatorioGeral;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import net.sf.jasperreports.engine.JRException;

/**
 * @author ayrton
 *
 */
public class ControleRelatorio implements Initializable{

	private List<RelatorioFinanceiro> relatorioFinanceiros;

	private Date inicio, fim;
	
    @FXML
    private DatePicker dataInicio;

    @FXML
    private DatePicker dataFim;

    @FXML
    private Button relatorioButton;

    @FXML
    void action(ActionEvent event) {

    	if(event.getSource() == relatorioButton) {
    		
    		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    		
    		try {
				inicio = format.parse(dataInicio.getEditor().getText().trim());
				fim = format.parse(dataFim.getEditor().getText().trim());
				
				relatorioFinanceiros = Fachada.getInstance().getRelatorio(inicio, fim);
				
				RelatorioGeral relatorioGeral = new RelatorioGeral();
				
				relatorioGeral.gerarDocumento(relatorioFinanceiros, "RelatorioFinanceiro.jrxml");
				System.out.println(relatorioFinanceiros);
			} catch (ParseException | BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    	}
    	
    	
    }

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

	
}
