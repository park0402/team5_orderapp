package controller.pay;

import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import dto.File;
import controller.Main;
import controller.cart.CartControl;
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
	    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
			Main.instance.loadpage("/view/home/home.fxml");
	    }
	    
	    @FXML
	    void backpage(ActionEvent event) {
	    	Main.instance.loadpage("/view/home/home.fxml");
	    }
	    ArrayList<Order>orderList= controller.cart.CartControl.orderList; // 주문리스트 불러오기

		int cartPrice=0;
		
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//총 계산해야할 값 계산해서 출력
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
				lblprice.setText("총 계산해야할 값 : "+cartPrice);
	}
	@FXML
    void pay(ActionEvent event) { // 결제하기를 눌렀을 때
		System.out.println("결제 시작");
		if(cartPrice>Integer.parseInt(txtprice.getText())) {
			Alert alert=new Alert(Alert.AlertType.ERROR);
			alert.setTitle("경고");
			alert.setHeaderText("금액이 부족합니다");
			alert.showAndWait();
		}else {
			Date today=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			File file=CartControl.file;
			String output = file.getOrderNum()+","+file.getfNum()+","+cartPrice+","+sdf.format(today);
			try {
				FileOutputStream fos = new FileOutputStream("D:/java/test.txt",true);
				fos.write(output.getBytes());
				fos.close();
			} catch (Exception e) { System.out.println("메모장 아웃풋 오류 ");
				e.printStackTrace();
			}
			Alert alert=new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("안내");
			alert.setHeaderText("결제 완료");
			alert.showAndWait();
			Home.home.loadpage("/view/home/home.fxml");
		}
    }
	public void fileInput() { // 메모장에 적기
		
	}
}
