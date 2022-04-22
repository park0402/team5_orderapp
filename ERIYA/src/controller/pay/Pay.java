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
	    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
			Main.instance.loadpage("/view/home/home.fxml");
	    }
	    
	    @FXML
	    void backpage(ActionEvent event) {
	    	Main.instance.loadpage("/view/home/home.fxml");
	    }
	    ArrayList<Order>orderList= controller.cart.Cart.orderList; // 주문리스트 불러오기
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//총 계산해야할 값 계산해서 출력
				int cartPrice=0;
				for(Order temp : orderList) {
					int fnum=temp.getFnum();
					cartPrice+=FoodDao.foodDao.price(fnum); // 가격 계속 더해주기
					if(temp.isOpt1()) {cartPrice+=500;} // ice면 500원추가
					if(temp.isOpt2()) {cartPrice+=1000;} // extra면 1000원추가
					if(temp.isEsp()) {cartPrice+=500;} // 에스프레소 500원추가
					if(temp.isChoco()) {cartPrice+=500;} // 초콜릿 500원추가
					if(temp.isSyrup()) {cartPrice+=500;} // 시럽 500원추가
					cartPrice*=temp.getQuan(); // 선택한 갯수만큼 곱하기
				}
				System.out.println("총 계산해야할 값 : "+cartPrice);
	}

}
