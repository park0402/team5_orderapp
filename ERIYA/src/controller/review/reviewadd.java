package controller.review;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;

public class reviewadd implements Initializable{
		
	 @FXML
	    private Label lblback;

	    @FXML
	    private TextField txtrname;

	    @FXML
	    private TextArea txtrcontent;

	    @FXML
	    private Button addreview;

	    @FXML
	    private Button cancel;

	    @FXML
	    void addreview(ActionEvent event) {

	    }


	    @FXML
	    void back(MouseEvent event) {
	    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
			Main.instance.loadpage("/view/review/review.fxml");
	    }

	    @FXML
	    void cancel(ActionEvent event) {
	    	System.out.println("취소 버튼을 눌렀습니다.");
			Main.instance.loadpage("/view/review/review.fxml");
	    }
	    
	    @Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
	   
	    
	    }
	    

}
