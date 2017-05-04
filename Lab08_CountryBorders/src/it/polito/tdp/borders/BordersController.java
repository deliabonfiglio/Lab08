/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BordersController {

	Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtAnno"
	private TextField txtAnno; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	void doCalcolaConfini(ActionEvent event) {
		txtResult.clear();
		
		try {
			String string_anno = txtAnno.getText();			
			if(!string_anno.matches("[0-9]+")){
				txtResult.appendText("Inserire solo valori numerici\n");
				return;
			}
			int anno = Integer.parseInt(string_anno);
				if(anno <1816 || anno >2016){
					txtResult.appendText("Inserire solo anni compresi tra 1816 e 2016\n");
					return;
				}
		model.setAnno(anno);	
		txtResult.setText("Confini stabiliti fino all'anno "+ anno+ ": \n");
		for(Country ctemp:model.creaGrafo()){
			txtResult.appendText(ctemp.getStateName()+" : "+Integer.toString(model.numNeighbours(ctemp))+"\n");
					
		}
		txtResult.appendText("Numero di componenti connesse: "+Integer.toString(model.getNumberOfConnectedComponents()));
				
		} catch (RuntimeException re) {
			txtResult.setText(re.getMessage());
		}		
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";
	}

	public void setModel(Model model2) {
		this.model = model2;
		
	}
}
