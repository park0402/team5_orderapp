package controller.coffee;

import java.net.URL;
import java.util.ResourceBundle;
import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class coffeeList implements Initializable{
	
    @FXML
    private BorderPane borderpane;

    @FXML
    private Label lblback;

	@FXML
	 private Button btnaddlist;
	
    @FXML
    void back(MouseEvent event) {
    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
		Main.instance.loadpage("/view/home/home.fxml");
    }

	 @FXML
	 void addlist(ActionEvent event) {
		 	System.out.println("��ǰ�߰� ��ư�� �������ϴ�.");
			Main.instance.loadpage("/view/coffee/coffeeAdd.fxml");
	 }
	 

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
