package controller.review;

import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class reviewinfo implements Initializable{

	@FXML
	private BorderPane borderpane;

	@FXML
	private Label lblback;
	
    @FXML
    private Button btnreviewadd;


	@FXML
	void back(MouseEvent event) {
		System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
		Main.instance.loadpage("/view/home/home.fxml");
	}
	
	@FXML
	void reviewadd(MouseEvent event) {
		System.out.println("���侲�� ��ư�� �������ϴ�.");
	Main.instance.loadpage("/view/review/reviewadd.fxml");

	 }
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
}