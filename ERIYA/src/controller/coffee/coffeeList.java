package controller.coffee;

import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class coffeeList implements Initializable{
	 @FXML
	 private Button btnadd;

	 @FXML
	 void add(ActionEvent event) {
		 Home.home.loadpage("/view/coffeeAdd.fxml");
	 }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
