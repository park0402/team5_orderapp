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
    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
		Home.home.loadpage("/view/home/home.fxml");
    }
    
@Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }
}

