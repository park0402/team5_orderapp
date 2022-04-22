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
      // 1. 장바구니에 저장된 주문 불러오기
      

      // 2. 장바구니 저장된 주문 저장
//      int i = 0; // 인덱스 위치 변수;
//      for( Order temp  : orderlist ) { 
//         // * orderlist 배열내 order 객체 하나씩 꺼내와서 temp 저장 반복 
//         // 2. 공백에 인덱스에 객체 저장 
//         if( temp == null ) { // 만약에 해당 객체가 공백이면 
//            orderlist[i] = Order;  // 해당 인덱스에 새로 만들어진 객체 저장 
//            System.err.println(" 알림)) 주문 성공 ");
//            break; // for 나가기 [ 안나가면 모든 공백에 동일한 객체 저장되기때문에 ]
//         }
//         i++; // 인덱스 증가
//      // 2. 객체 [ 여러 변수 -> 하나 객체 ] 
//      Order orderlist = new Order(ordernum, ordertime, orderprice,mnum);
//      // 3. 리스트에 저장 
//      orderlist.add(Order);

//      }catch( Exception e ) { // 예외[오류] 처리[잡기] : Exception 클래스
//      }
//      System.out.println("알림]]주문 완료 ");
  }
}  