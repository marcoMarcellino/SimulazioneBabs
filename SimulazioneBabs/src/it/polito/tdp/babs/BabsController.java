package it.polito.tdp.babs;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.babs.model.CountResult;
import it.polito.tdp.babs.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

public class BabsController {

	private Model model;

	public void setModel(Model model) {
		this.model = model;
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private DatePicker pickData;

	@FXML
	private Slider sliderK;

	@FXML
	private TextArea txtResult;

	@FXML
	void doContaTrip(ActionEvent event) {
		try {
			
        txtResult.clear();
		LocalDate date = pickData.getValue();
		List<CountResult> results = model.getTripCounts(date);
		if(results==null) {
			txtResult.setText("No trip per la data selezionata");
			return;
		}
		for(CountResult cc : results) {
			txtResult.appendText(cc.toString());
		}
		} catch (Exception e) {
			txtResult.setText("Errore Connessione DB");
		}
		
	}

	@FXML
	void doSimula(ActionEvent event) {
		try {
			txtResult.clear();
			LocalDate date = pickData.getValue();
			
			if(date.getDayOfWeek().getValue()>4) {// 4= venerdi
			txtResult.setText("Selezionare una data da lunedi al venerdi");
			return;
			}
			Double k = sliderK.getValue();
			model.simula(date,k);
			
		} catch (Exception e) {
			txtResult.setText("Errore Connessione DB");

		}
	}

	@FXML
	void initialize() {
		assert pickData != null : "fx:id=\"pickData\" was not injected: check your FXML file 'Babs.fxml'.";
		assert sliderK != null : "fx:id=\"sliderK\" was not injected: check your FXML file 'Babs.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Babs.fxml'.";

		pickData.setValue(LocalDate.of(2013, 9, 1));
	}
}
