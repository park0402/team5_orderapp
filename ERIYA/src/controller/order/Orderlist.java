package controller.order;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.Main;
import dao.FoodDao;
import dto.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Orderlist implements Initializable{

    @FXML
    private Label lblback;

    @FXML
    private TableView<OrderDataModel> tableview;

    @FXML
    private TableColumn<?, ?> tbldate;

    @FXML
    private TableColumn<?, ?> tblprice;

    @FXML
    private TableColumn<?, ?> tblfname;

	@FXML
	void back(MouseEvent event) {
		System.out.println("뒤로가기 버튼을 눌렀습니다.");
		Main.instance.loadpage("/view/home/home.fxml");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			byte[] bytes = Files.readAllBytes(Paths.get("D:/java/test.txt"));
				String[] sp1 = new String(bytes).split("\n"); // \n으로 자르기
				ArrayList<OrderDataModel> orderList = new ArrayList<>();
				for(int i=0; i<sp1.length-1; i++) {
					String[] sp2=new String(sp1[i]).split(",");
					String fname=FoodDao.foodDao.fName(Integer.parseInt(sp2[1]));
					System.out.println(fname);
					OrderDataModel t = new OrderDataModel(sp2[3],Integer.parseInt(sp2[2]),fname);
					System.out.println(sp2[3]+sp2[2]);
					orderList.add(t);
				}
			//주문한 목록 전부 불러와서 출력
				ObservableList<OrderDataModel> orderData=FXCollections.observableArrayList();
			for(OrderDataModel temp : orderList) {
				
				orderData.add(new OrderDataModel(temp.getOrderDate(), temp.getPrice(), temp.getfName()));
				try {
				TableColumn tc = tableview.getColumns().get(0);
				tc.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
				
				tc=tableview.getColumns().get(1);
				tc.setCellValueFactory(new PropertyValueFactory<>("Price"));
				
				tc=tableview.getColumns().get(2);
				tc.setCellValueFactory(new PropertyValueFactory<>("fName"));
				}catch(Exception e) {System.out.println("테이블 세팅 오류 "+e);}
				 // 테이블뷰에 넣기
			} // 데이터 입력 끝
			tableview.setItems(orderData);
			}catch(Exception e) {System.out.println("주문목록 출력 오류 : " + e);}
		}
}