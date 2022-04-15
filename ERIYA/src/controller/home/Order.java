package controller.home;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Order implements Initializable{

    @FXML
    private Label lblback;

    @FXML
    void back(MouseEvent event) {
    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
		Home.home.loadpage("/view/home/home.fxml");
    }
    
@Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }
}

