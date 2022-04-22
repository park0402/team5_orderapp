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
    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
		Main.instance.loadpage("/view/home/home.fxml");
    }
    
    public static Food select; // ������ ��ǰ ������ ����
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
			//��ǰ ��������
			GridPane gridPane = new GridPane();
				//���� ���
			gridPane.setPadding(new Insets(100));
			gridPane.setHgap(100);
			gridPane.setVgap(100);
		int i = 0; // �ε����� ����
		for(int row = 0; row<foodList.size()/3; row++) { // ��
			for(int col = 0; col<3; col++) { // ��
				ImageView imageView = new ImageView(new Image(foodList.get(i).getFimg()));
					imageView.setFitWidth(250);
					imageView.setFitHeight(250);
				Button button = new Button(null, imageView);
					//��ư �������
					button.setStyle("-fx-background-color:transparent");
					//��ư id���ֱ�[��ǰ �ĺ�]
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
