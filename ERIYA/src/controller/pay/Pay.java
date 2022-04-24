package controller.pay;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Main;
import controller.home.Home;
import dao.FoodDao;
import dto.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Pay implements Initializable{

	    @FXML
	    private Button backpage;

	    @FXML
	    private Button btnpay;
	    
		@FXML
	    private BorderPane borderpane;

	    @FXML
	    private Label lblprice;
	    
	    @FXML
	    private Label lblback;
	    
	    @FXML
	    private TextField txtprice;
	    @FXML
	    void back(MouseEvent event) {
	    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
			Main.instance.loadpage("/view/home/home.fxml");
	    }
	    
	    @FXML
	    void backpage(ActionEvent event) {
	    	Main.instance.loadpage("/view/home/home.fxml");
	    }
	    ArrayList<Order>orderList= controller.cart.CartControl.orderList; // �ֹ�����Ʈ �ҷ�����

		int cartPrice=0;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//�� ����ؾ��� �� ����ؼ� ���
				for(Order temp : orderList) {
					int fnum=temp.getFnum();
					cartPrice+=FoodDao.foodDao.price(fnum); // ���� ��� �����ֱ�
					if(temp.isOpt1()) {cartPrice+=500;} // ice�� 500���߰�
					if(temp.isOpt2()) {cartPrice+=1000;} // extra�� 1000���߰�
					if(temp.isEsp()) {cartPrice+=500;} // ���������� 500���߰�
					if(temp.isChoco()) {cartPrice+=500;} // ���ݸ� 500���߰�
					if(temp.isSyrup()) {cartPrice+=500;} // �÷� 500���߰�
					cartPrice*=temp.getQuan(); // ������ ������ŭ ���ϱ�
				}
				System.out.println("�� ����ؾ��� �� : "+cartPrice);
				lblprice.setText("�� ����ؾ��� �� : "+cartPrice);
	}   
	@FXML
    void pay(ActionEvent event) {
		if(cartPrice>Integer.parseInt(txtprice.getText())) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.setTitle("���");
			alert.setHeaderText("�ݾ��� �����մϴ�");
			alert.showAndWait();
		}else {
			Alert alert=new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("�ȳ�");
			alert.setHeaderText("���� �Ϸ�");
			alert.showAndWait();
			Home.home.loadpage("/view/home/home.fxml");
		}
    }
}
