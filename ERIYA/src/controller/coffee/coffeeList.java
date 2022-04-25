package controller.coffee;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import controller.Main;
import controller.home.Home;
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
    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
		Main.instance.loadpage("/view/home/home.fxml");
    }
    
    public static Food select; // ������ ��ǰ ������ ����
    public static int id;
	 @FXML
	 void addlist(ActionEvent event) {
		 	System.out.println("��ǰ�߰� ��ư�� �������ϴ�.");
			Main.instance.loadpage("/view/coffee/coffeeAdd.fxml");
	 }
	 
	 public void show() { // ��� ��ǰ ����ϱ�

			if(vbox.getChildren().isEmpty()==false) { // vbox�� ������� ������
				 vbox.getChildren().remove(0); // 0�� ����
			 }
			ArrayList<Food> foodList = FoodDao.foodDao.list();
			GridPane gridPane = new GridPane();
				//���� ���
			gridPane.setPadding(new Insets(10));
			gridPane.setHgap(10);
			gridPane.setVgap(10);
		int i = 0; // �ε����� ����
		for(int row = 0; row<foodList.size()/3; row++) { // ��
			for(int col = 0; col<3; col++) { // ��
				ImageView imageView = new ImageView(new Image(foodList.get(i).getFimg()));
					imageView.setFitWidth(100);
					imageView.setFitHeight(100);
				Button button = new Button(null, imageView);
					//��ư �������
					button.setStyle("-fx-background-color:transparent");
					//��ư id���ֱ�(��ǰ �ĺ���)
					button.setId(i+"");
					button.setOnAction((e)->{ // Ŭ���� �̺�Ʈ
						int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
						select = foodList.get(id);
						Home.home.loadpage("/view/order/orderoption.fxml");
					});
			gridPane.add(new Button(), col, row);	
			i++;
				}
			}vbox.getChildren().add(gridPane);
			int row = foodList.size() / 3;
			int remain = foodList.size()%3;
			if(remain!=0) {
			for(int col = 0; col<remain; col++) { // ��
				ImageView imageView = new ImageView(new Image(foodList.get(i).getFimg()));
					imageView.setFitWidth(100);
					imageView.setFitHeight(100);
				Button button = new Button(null, imageView);
					//��ư �������
					button.setStyle("-fx-background-color:transparent");
					//��ư id���ֱ�(��ǰ �ĺ���)
					button.setId(i+"");
					button.setOnAction((e)->{ // Ŭ���� �̺�Ʈ
						int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2]);
						select=foodList.get(id);
						System.out.println(id+"�� ���� ��ȸ");
						Main.instance.loadpage("/view/order/orderoption.fxml");
					});
			gridPane.add(button, col, row+1);	
			i++;
				}
			}

		} // show e

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		show();
	}
}
