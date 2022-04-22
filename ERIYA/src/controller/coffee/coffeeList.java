package controller.coffee;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import controller.Main;
import dao.FoodDao;
import dto.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class coffeeList implements Initializable{
	
    @FXML
    private ScrollPane scrollpane;

    @FXML
    private VBox vbox;

    @FXML
    private BorderPane borderpane;

    @FXML
    private Label lblback;

	@FXML
	 private Button btnaddlist;
	
    @FXML
    void back(MouseEvent event) {
    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
		Main.instance.loadpage("/view/home/home.fxml");
    }
    
    public static Food select; // 선택한 상품 데이터 저장
	 @FXML
	 void addlist(ActionEvent event) {
		 	System.out.println("상품추가 버튼을 눌렀습니다.");
			Main.instance.loadpage("/view/coffee/coffeeAdd.fxml");
	 }
	 
	 public void show() { // 모든 제품 출력하기
			if(vbox.getChildren().isEmpty()==false) { // vbox가 비어있지 않으면
				 vbox.getChildren().remove(0); // 0번 삭제
			 }
			ArrayList<Food> foodList = FoodDao.foodDao.list();
			//제품 여러개면
			GridPane gridPane = new GridPane();
				//여백 잡기
			gridPane.setPadding(new Insets(100));
			gridPane.setHgap(100);
			gridPane.setVgap(100);
		int i = 0; // 인덱스용 변수
		for(int row = 0; row<foodList.size()/3; row++) { // 행
			for(int col = 0; col<3; col++) { // 열
				ImageView imageView = new ImageView(new Image(foodList.get(i).getFimg()));
					imageView.setFitWidth(250);
					imageView.setFitHeight(250);
				Button button = new Button(null, imageView);
					//버튼 배경제거
					button.setStyle("-fx-background-color:transparent");
					//버튼 id값넣기[제품 식별]
					button.setId(i+"");
					button.setOnAction((e)->{
						int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
						select = foodList.get(id);
						System.out.println(id);
						//Home.home.loadpage("/view/coffee/coffeeView.fxml");
					});
			gridPane.add(new Button(), col, row);	
			i++;
				}
			}vbox.getChildren().add(gridPane);
		} // show e

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
