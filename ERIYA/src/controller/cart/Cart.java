package controller.cart;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public static ArrayList<Order> orderList = new ArrayList<>(); // �ֹ���� �����ϴ� �迭 ����
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//������ �ֹ���ȣ �о�ͼ� �ο��ϱ�
		byte[] bytes=null;
		int lastOrder; // ������ �ֹ�
		try {
			bytes = Files.readAllBytes(Paths.get("D:/java/test.txt"));
			String[] sp1 = new String(bytes).split("\n"); // \n���� �ڸ���
			String[] sp2 = sp1[sp1.length-1].split(","); // ������ �ֹ���� ��������
			lastOrder=Integer.parseInt(sp2[0]); // ������ �ֹ���ȣ �ֱ�
		}catch(Exception e) {e.printStackTrace();}
		//�ֹ��� ��� ���� �ҷ��ͼ� ���
		for(Order temp : orderList) {
			
		}
		
		
		//�ݾ� �Է¹޾� ���ϱ�
	}
}
