package controller.order;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import controller.coffee.coffeeList;
import controller.login.Login;
import dto.Food;
import dto.Member;
import dto.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;

public class Orderoption implements Initializable{

	@FXML
    private Label lblback;

    @FXML
    private Label Q;

    @FXML
    private Button btnplus;

    @FXML
    private RadioButton opthot;

    @FXML
    private RadioButton optice;

    @FXML
    private RadioButton optext;

    @FXML
    private RadioButton optreg;
    
    @FXML
    private RadioButton opes;

    @FXML
    private RadioButton optchoco;

    @FXML
    private RadioButton optsyrup;

    @FXML
    private Button btncart;

    @FXML
    private Button cancel;

    @FXML
    private Label cart;

    @FXML
    void back(MouseEvent event) {
    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
    	Main.instance.loadpage("/view/order/order.fxml");
    }

    @FXML
    void cancel(ActionEvent event) {
    	System.out.println("취소 버튼을 눌렀습니다.");
    	Main.instance.loadpage("/view/order/order.fxml");
    }
    @FXML
    void cart(MouseEvent event) { //장바구니에 담기
    	System.out.println("장바구니 버튼을 눌렀습니다.");

            // 1. 컨트롤에 입력된 데이터 가져오기
    	Member member = Login.member;
    	Food food = coffeeList.select;
               // 온도 카테고리
            boolean opt1 = false;
               if( opthot.isSelected() ) { opt1 = false;}
               if( optice.isSelected() ) { opt1 = true;}
            
                
               // 음료잔 수
               cupnum = Integer.parseInt(Q.getText());
               
               //사이즈 카테고리
            boolean opt2 = false;
               if( optreg.isSelected() ) { opt2 = false;}
               if( optext.isSelected() ) { opt2 = true;}

     
               // 추가옵션 카테고리
               boolean esp=false;
               boolean choco=false;
               boolean syrup=false;
               if( opes.isSelected() ) { esp = true;}
               if( optchoco.isSelected() ) { choco = true;}
               if( optsyrup.isSelected() ) { syrup = true;}
         
            // 2. 객체화
            Order order = new Order(food.getFnum(), member.getMnum(), opt1, opt2, esp, choco, syrup, cupnum);
            controller.cart.Cart.orderList.add(order); // 주문을 리스트에 저장
    	Main.instance.loadpage("/view/cart/cart.fxml");
    }
    int cupnum;
    @FXML
    void minus(ActionEvent event) { // 수량 감소
    	if(cupnum>=1) { // 수량이 1 이상일때만 동작
    		cupnum--;
    		Q.setText(cupnum+"");
    	}
    }

    @FXML
    void plus(ActionEvent event) { // 수량 추가
    	cupnum++;
    	Q.setText(cupnum+"");
    }

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	//기본으로 hot, regular 설정
	
}
}
