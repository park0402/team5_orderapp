package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import dto.Member;
import controller.home.Home;
import controller.login.Login;
import dto.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OrderDao {
   
   private ArrayList<Order> orderList = new ArrayList<>();
      
   public void addToCart() {
      // 1. ��ٱ��Ͽ� ����� �ֹ� �ҷ�����
      

      // 2. ��ٱ��� ����� �ֹ� ����
//      int i = 0; // �ε��� ��ġ ����;
//      for( Order temp  : orderlist ) { 
//         // * orderlist �迭�� order ��ü �ϳ��� �����ͼ� temp ���� �ݺ� 
//         // 2. ���鿡 �ε����� ��ü ���� 
//         if( temp == null ) { // ���࿡ �ش� ��ü�� �����̸� 
//            orderlist[i] = Order;  // �ش� �ε����� ���� ������� ��ü ���� 
//            System.err.println(" �˸�)) �ֹ� ���� ");
//            break; // for ������ [ �ȳ����� ��� ���鿡 ������ ��ü ����Ǳ⶧���� ]
//         }
//         i++; // �ε��� ����
//      // 2. ��ü [ ���� ���� -> �ϳ� ��ü ] 
//      Order orderlist = new Order(ordernum, ordertime, orderprice,mnum);
//      // 3. ����Ʈ�� ���� 
//      orderlist.add(Order);

//      }catch( Exception e ) { // ����[����] ó��[���] : Exception Ŭ����
//      }
//      System.out.println("�˸�]]�ֹ� �Ϸ� ");
  }
}  