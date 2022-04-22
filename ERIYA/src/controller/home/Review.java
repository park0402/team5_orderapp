package controller.home;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Review implements Initializable{

	@FXML
	private BorderPane borderpane;

	@FXML
	private Label lblback;
	
	   @FXML
	    private Label lblreview;

	    @FXML
	    void review(MouseEvent event) {
	    	System.out.println("�����ۼ� ��ư�� �������ϴ�.");
			Main.instance.loadpage("/view/review/reviewadd.fxml");
	    }
	
	@FXML
	void back(MouseEvent event) {
		System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
		Main.instance.loadpage("/view/home/home.fxml");
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
}
