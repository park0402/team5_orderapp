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
	
	public static Home home; // ��ü 

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
			System.out.println("Load ���� : " + e);
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lblloginid.setText(Login.member.getMid()+" ��");
		lblpoint.setText("������ : " + Login.member.getStamp());
		if(!Loginpane.isadmin) {
	         btnmoney.setVisible(false);
	         btnfood.setVisible(false);
	      }
	}
	
	@FXML // �α׾ƿ� �� Ŭ��
	public void logout(MouseEvent e) {
		Login.member = null;
		Main.instance.loadpage("/view/login/login.fxml");
	}
	
	 @FXML
	    public void order(ActionEvent event) {
	    	System.out.println("�ֹ� ��ư�� �������ϴ�.");
			Main.instance.loadpage("/view/coffee/coffeeList.fxml");
	    }

    @FXML
    void food(ActionEvent event) {
    	System.out.println("��ǰ������ �������ϴ�.");
		Main.instance.loadpage("/view/coffee/coffeeList.fxml");
    }

    @FXML
    void money(ActionEvent event) {
    	System.out.println("���� ��ư�� �������ϴ�.");
		Main.instance.loadpage("/view/stat/stat.fxml");
    }

   
    @FXML
    void orderlist(ActionEvent event) {
    	System.out.println("�ֹ� ���� ��ư�� �������ϴ�.");
    	Main.instance.loadpage("/view/order/orderlist.fxml");
    }

    @FXML
    void review(ActionEvent event) {
    	System.out.println("���� ��ư�� �������ϴ�.");
    	Main.instance.loadpage("/view/review/review.fxml");
    }
	
}
