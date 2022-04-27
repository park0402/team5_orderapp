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
    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
    	Main.instance.loadpage("/view/coffee/coffeeList.fxml");
    }
    
    @FXML
    void pay(ActionEvent event) {
    	System.out.println("���� ��ư�� �������ϴ�.");
    	Main.instance.loadpage("/view/pay/pay.fxml");
    }
	
    @FXML
    void backpage(ActionEvent event) {
    	Main.instance.loadpage("/view/coffee/coffeeList.fxml");
    }
    
    public static ArrayList<Order> orderList = new ArrayList<>(); // �ֹ���� �����ϴ� �迭 ����
    public static File file=new File(); // ����ó���� ��ü ����
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("��ٱ��� ȭ����ȯ ����");
		//������ �ֹ���ȣ �о�ͼ� �ο��ϱ�
		
		
		int lastOrder; // ������ �ֹ�
		try {
		byte[] bytes = Files.readAllBytes(Paths.get("D:/java/test.txt"));
			String[] sp1 = new String(bytes).split("\n"); // \n���� �ڸ���
			String[] sp2 = sp1[sp1.length-1].split(","); // ������ �ֹ���� ��������
			lastOrder=Integer.parseInt(sp2[0]); // ������ �ֹ���ȣ �ֱ�
		}catch(Exception e) {System.out.println("���� �ҷ����� ���� : " + e);}
		//�ֹ��� ��� ���� �ҷ��ͼ� ���
		
		
		
			int mNum=controller.login.Login.member.getMnum();
			ObservableList<CartDataModel> orderData=FXCollections.observableArrayList();
		for(Order temp : orderList) {
			String fname=FoodDao.foodDao.fName(temp.getFnum());
			int price=FoodDao.foodDao.price(temp.getFnum()); // ���� �ֱ�
			if(temp.isOpt1()) {price+=500;} // ice�� 500���߰�
			if(temp.isOpt2()) {price+=1000;} // extra�� 1000���߰�
			if(temp.isEsp()) {price+=500;} // ���������� 500���߰�
			if(temp.isChoco()) {price+=500;} // ���ݸ� 500���߰�
			if(temp.isSyrup()) {price+=500;} // �÷� 500���߰�
			price*=temp.getQuan(); // ������ ������ŭ ���ϱ�
			final int fPrice=price;
			orderData.add(new CartDataModel(fname, temp.getQuan(), fPrice));
			try {
			TableColumn tc = tableview.getColumns().get(0);
			tc.setCellValueFactory(new PropertyValueFactory<>("fname"));
			
			tc=tableview.getColumns().get(1);
			tc.setCellValueFactory(new PropertyValueFactory<>("quan"));
			
			tc=tableview.getColumns().get(2);
			tc.setCellValueFactory(new PropertyValueFactory<>("fprice"));
			}catch(Exception e) {System.out.println("���̺� ���� ���� "+e);}
			 // ���̺�信 �ֱ�
		} // ������ �Է� ��
		tableview.setItems(orderData);
		}
	
}
