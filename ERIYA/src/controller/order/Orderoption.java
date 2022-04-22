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
    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
    	Main.instance.loadpage("/view/order/order.fxml");
    }

    @FXML
    void cancel(ActionEvent event) {
    	System.out.println("��� ��ư�� �������ϴ�.");
    	Main.instance.loadpage("/view/order/order.fxml");
    }
    @FXML
    void cart(MouseEvent event) { //��ٱ��Ͽ� ���
    	System.out.println("��ٱ��� ��ư�� �������ϴ�.");

            // 1. ��Ʈ�ѿ� �Էµ� ������ ��������
    	Member member = Login.member;
    	Food food = coffeeList.select;
               // �µ� ī�װ�
            boolean opt1 = false;
               if( opthot.isSelected() ) { opt1 = false;}
               if( optice.isSelected() ) { opt1 = true;}
            
                
               // ������ ��
               cupnum = Integer.parseInt(Q.getText());
               
               //������ ī�װ�
            boolean opt2 = false;
               if( optreg.isSelected() ) { opt2 = false;}
               if( optext.isSelected() ) { opt2 = true;}

     
               // �߰��ɼ� ī�װ�
               boolean esp=false;
               boolean choco=false;
               boolean syrup=false;
               if( opes.isSelected() ) { esp = true;}
               if( optchoco.isSelected() ) { choco = true;}
               if( optsyrup.isSelected() ) { syrup = true;}
         
            // 2. ��üȭ
            Order order = new Order(food.getFnum(), member.getMnum(), opt1, opt2, esp, choco, syrup, cupnum);
            controller.cart.Cart.orderList.add(order); // �ֹ��� ����Ʈ�� ����
    	Main.instance.loadpage("/view/cart/cart.fxml");
    }
    int cupnum;
    @FXML
    void minus(ActionEvent event) { // ���� ����
    	if(cupnum>=1) { // ������ 1 �̻��϶��� ����
    		cupnum--;
    		Q.setText(cupnum+"");
    	}
    }

    @FXML
    void plus(ActionEvent event) { // ���� �߰�
    	cupnum++;
    	Q.setText(cupnum+"");
    }

@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	//�⺻���� hot, regular ����
	
}
}
