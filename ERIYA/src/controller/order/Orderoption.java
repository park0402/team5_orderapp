package controller.order;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Orderoption implements Initializable{

	  @FXML
	    private Label lblback;

	    @FXML
	    private Button btncart;

	    @FXML
	    private Button cancel;

	    @FXML
	    private Label cart;

	    @FXML
	    void back(MouseEvent event) {
	    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
	    	Main.instance.loadpage("/view/order/order.fxml");
	    }

	    @FXML
	    void cancel(ActionEvent event) {
	    	System.out.println("��� ��ư�� �������ϴ�.");
	    	Main.instance.loadpage("/view/order/order.fxml");
	    }

	    @FXML
	    void cart(MouseEvent event) {
	    	System.out.println("��ٱ��� ��ư�� �������ϴ�.");
	    	Main.instance.loadpage("/view/cart/cart.fxml");
	    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
}
