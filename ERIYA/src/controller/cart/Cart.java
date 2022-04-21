package controller.cart;

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

public class Cart implements Initializable{


    @FXML
    private Button btnback;

	 @FXML
	 private BorderPane borderpane;
	
    @FXML
    private Label lblback;
    
    @FXML
    private Button btnpay;

    @FXML
    void back(MouseEvent event) {
    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
		Main.instance.loadpage("/view/order/order.fxml");
    }
    
    @FXML
    void pay(ActionEvent event) {
    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
		Main.instance.loadpage("/view/pay/pay.fxml");
    }
	
    @FXML
    void backpage(ActionEvent event) {
    	Main.instance.loadpage("/view/order/order.fxml");
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
}
