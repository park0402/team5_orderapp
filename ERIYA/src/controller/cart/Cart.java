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
    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
		Main.instance.loadpage("/view/order/order.fxml");
    }
    
    @FXML
    void pay(ActionEvent event) {
    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
		Main.instance.loadpage("/view/pay/pay.fxml");
    }
	
    @FXML
    void backpage(ActionEvent event) {
    	Main.instance.loadpage("/view/order/order.fxml");
    }
    public static ArrayList<Order> orderList = new ArrayList<>(); // 주문목록 저장하는 배열 선언
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//마지막 주문번호 읽어와서 부여하기
		byte[] bytes=null;
		int lastOrder; // 마지막 주문
		try {
			bytes = Files.readAllBytes(Paths.get("D:/java/test.txt"));
			String[] sp1 = new String(bytes).split("\n"); // \n으로 자르기
			String[] sp2 = sp1[sp1.length-1].split(","); // 마지막 주문목록 가져오기
			lastOrder=Integer.parseInt(sp2[0]); // 마지막 주문번호 넣기
		}catch(Exception e) {e.printStackTrace();}
		//주문한 목록 전부 불러와서 출력
		for(Order temp : orderList) {
			
		}
		
		
		//금액 입력받아 비교하기
	}
}
