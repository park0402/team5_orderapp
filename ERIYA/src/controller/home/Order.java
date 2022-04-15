package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Order implements Initializable{

	 @FXML
	   private BorderPane borderpane;

    @FXML
    private Label lblback;

    @FXML
    void back(MouseEvent event) {
    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
		Main.instance.loadpage("/view/home/home.fxml");
    }
    
    public void loadpage(String page) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource(page));
			borderpane.setCenter(parent);
		} catch (Exception e) {
			System.out.println("Load 오류 : " + e);
		}
	}
@Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }
}




