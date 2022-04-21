package controller.pay;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Pay implements Initializable{

	    @FXML
	    private Button backpage;
	
		@FXML
	    private BorderPane borderpane;

	    @FXML
	    private Label lblback;

	    @FXML
	    void back(MouseEvent event) {
	    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
			Main.instance.loadpage("/view/home/home.fxml");
	    }
	    
	    @FXML
	    void backpage(ActionEvent event) {
	    	Main.instance.loadpage("/view/home/home.fxml");
	    }
	    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

}
