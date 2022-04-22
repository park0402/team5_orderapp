package controller.pay;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Main;
import dao.FoodDao;
import dto.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Pay implements Initializable{

	    @FXML
	    private Button backpage;
	
		@FXML
	    private BorderPane borderpane;

	    @FXML
	    private Label lblback;

	    @FXML
	    void back(MouseEvent event) {
	    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
			Main.instance.loadpage("/view/home/home.fxml");
	    }
	    
	    @FXML
	    void backpage(ActionEvent event) {
	    	Main.instance.loadpage("/view/home/home.fxml");
	    }
	    ArrayList<Order>orderList= controller.cart.Cart.orderList; // �ֹ�����Ʈ �ҷ�����
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//�� ����ؾ��� �� ����ؼ� ���
				int cartPrice=0;
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
	}

}
