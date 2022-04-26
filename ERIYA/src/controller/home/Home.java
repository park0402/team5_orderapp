package controller.home;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import controller.Main;
import controller.login.Login;
import controller.login.Loginpane;
import dao.MemberDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Home implements Initializable{
	
	public static Home home; // 객체 

	    @FXML
	    private BorderPane borderpane;

	    @FXML
	    private Label lblloginid;

	    @FXML
	    private Label lblpoint;

	    @FXML
	    private Label lbllogout;

	    @FXML
	    private Button btnorderlist;

	    @FXML
	    private Button brnreview;

	    @FXML
	    private Button btnorder;

	    @FXML
	    private Button btnmoney;

	    @FXML
	    private Button btnfood;

	
	
	public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderpane.setCenter(parent);
		} catch (Exception e) {
			System.out.println("Load 오류 : " + e);
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblloginid.setText(Login.member.getMid()+" 님");
		lblpoint.setText("스탬프 : " + Login.member.getStamp());
		if(!Loginpane.isadmin) {
	         btnmoney.setVisible(false);
	         btnfood.setVisible(false);
	      }
	}
	
	@FXML // 로그아웃 라벨 클릭
	public void logout(MouseEvent e) {
		Login.member = null;
		Main.instance.loadpage("/view/login/login.fxml");
	}
	
	 @FXML
	    public void order(ActionEvent event) {
	    	System.out.println("주문 버튼을 눌렀습니다.");
			Main.instance.loadpage("/view/coffee/coffeeList.fxml");
	    }

    @FXML
    void food(ActionEvent event) {
    	System.out.println("제품관리를 눌렀습니다.");
		Main.instance.loadpage("/view/coffee/coffeeList.fxml");
    }

    @FXML
    void money(ActionEvent event) {
    	System.out.println("매출 버튼을 눌렀습니다.");
		Main.instance.loadpage("/view/stat/stat.fxml");
    }

   
    @FXML
    void orderlist(ActionEvent event) {
    	System.out.println("주문 내역 버튼을 눌렀습니다.");
    	Main.instance.loadpage("/view/order/orderlist.fxml");
    }

    @FXML
    void review(ActionEvent event) {
    	System.out.println("리뷰 버튼을 눌렀습니다.");
    	Main.instance.loadpage("/view/review/review.fxml");
    }
	
}
