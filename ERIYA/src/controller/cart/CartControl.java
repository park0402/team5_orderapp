package controller.cart;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;
import controller.Main;
import dao.FoodDao;
import dto.File;
import dto.Order;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class CartControl implements Initializable{


    @FXML
    private Button btnback;

	@FXML
	private BorderPane borderpane;
	
    @FXML
    private TableView<CartDataModel> tableview;

    @FXML
    private TableColumn<?, ?> tblname;

    @FXML
    private TableColumn<?, ?> tblQuan;

    @FXML
    private TableColumn<?, ?> tblprice;

    @FXML
    private Label lblback;
    
    @FXML
    private Button btnpay;
    
    @FXML
    private Button btndelete;
    
    @FXML
    void delete(ActionEvent event) {

    }

    @FXML
    void back(MouseEvent event) {
    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
    	Main.instance.loadpage("/view/coffee/coffeeList.fxml");
    }
    
    @FXML
    void pay(ActionEvent event) {
    	System.out.println("지불 버튼을 눌렀습니다.");
    	Main.instance.loadpage("/view/pay/pay.fxml");
    }
	
    @FXML
    void backpage(ActionEvent event) {
    	Main.instance.loadpage("/view/coffee/coffeeList.fxml");
    }
    
    public static ArrayList<Order> orderList = new ArrayList<>(); // 주문목록 저장하는 배열 선언
    public static File file=new File(); // 파일처리할 객체 선언
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("장바구니 화면전환 성공");
		//마지막 주문번호 읽어와서 부여하기
		
		
		int lastOrder; // 마지막 주문
		try {
		byte[] bytes = Files.readAllBytes(Paths.get("D:/java/test.txt"));
			String[] sp1 = new String(bytes).split("\n"); // \n으로 자르기
			String[] sp2 = sp1[sp1.length-1].split(","); // 마지막 주문목록 가져오기
			lastOrder=Integer.parseInt(sp2[0]); // 마지막 주문번호 넣기
		}catch(Exception e) {System.out.println("파일 불러오기 오류 : " + e);}
		//주문한 목록 전부 불러와서 출력
		
		
		
			int mNum=controller.login.Login.member.getMnum();
			ObservableList<CartDataModel> orderData=FXCollections.observableArrayList();
		for(Order temp : orderList) {
			String fname=FoodDao.foodDao.fName(temp.getFnum());
			int price=FoodDao.foodDao.price(temp.getFnum()); // 가격 넣기
			if(temp.isOpt1()) {price+=500;} // ice면 500원추가
			if(temp.isOpt2()) {price+=1000;} // extra면 1000원추가
			if(temp.isEsp()) {price+=500;} // 에스프레소 500원추가
			if(temp.isChoco()) {price+=500;} // 초콜릿 500원추가
			if(temp.isSyrup()) {price+=500;} // 시럽 500원추가
			price*=temp.getQuan(); // 선택한 갯수만큼 곱하기
			final int fPrice=price;
			orderData.add(new CartDataModel(fname, temp.getQuan(), fPrice));
			try {
			TableColumn tc = tableview.getColumns().get(0);
			tc.setCellValueFactory(new PropertyValueFactory<>("fname"));
			
			tc=tableview.getColumns().get(1);
			tc.setCellValueFactory(new PropertyValueFactory<>("quan"));
			
			tc=tableview.getColumns().get(2);
			tc.setCellValueFactory(new PropertyValueFactory<>("fprice"));
			}catch(Exception e) {System.out.println("테이블 세팅 오류 "+e);}
			 // 테이블뷰에 넣기
		} // 데이터 입력 끝
		tableview.setItems(orderData);
		}
	
}
