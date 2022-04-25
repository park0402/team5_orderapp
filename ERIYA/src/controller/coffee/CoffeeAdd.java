package controller.coffee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import dao.FoodDao;
import dto.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class CoffeeAdd implements Initializable{
		@FXML
	    private BorderPane borderpane;

	   @FXML
	    private Button btnadd;

	    @FXML
	    private Button btncancel;
	    
	    @FXML
	    private Label lblback;
	    
	    @FXML
	    private TextField txtname;

	    @FXML
	    private TextField txtcontent;

	    @FXML
	    private TextField txtprice;

	    @FXML
	    private Button btnimgadd;

	    @FXML
	    private ImageView preview;

	    @FXML
	    void add(ActionEvent event) { // 제품 등록시
	    	String cName = txtname.getText(); String cCon=txtcontent.getText();
	    	int cPrice = Integer.parseInt(txtprice.getText()); // 입력값 가져오기
	    	//객체화(dto 작성 후)
	    	Food food = new Food(0, cPrice, pimg, cCon, cName);
	    	//DB처리(dao 작성 후)
	    	boolean result = FoodDao.foodDao.add(food);
	    	//결과처리
	    	if(result) {
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setHeaderText("제품 등록 완료");
	    		alert.showAndWait();
	    		Home.home.loadpage("/view/coffee/coffeeList.fxml");
	    	}else {
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setHeaderText("제품 등록 실패");
	    		alert.showAndWait();
	    	}
	    }
	    private String pimg=null; // 메소드 밖에서 선언
	    @FXML
	    void cancel(ActionEvent event) { // 취소(뒤로가기)
	    	Home.home.loadpage("/view/coffee/coffeeList.fxml");
	    }
	    @FXML
	    void back(MouseEvent event) {
	    	Home.home.loadpage("/view/coffee/coffeeList.fxml");
	    }
	    @FXML
	    void imgadd(ActionEvent event) { // 이미지추가시
	    	System.out.println("이미지파일 추가");
	    	FileChooser fileChooser = new FileChooser(); // 파일 선택 클래스 선언
	    	fileChooser.getExtensionFilters().add(  // 파일 필터 설정
    				new ExtensionFilter("이미지파일:image file" , "*png" , "*jpeg" , "*jpg","*gif", "*png") );
	    	File file=fileChooser.showOpenDialog(new Stage()); // 선택한 파일을 File 클래스로 객체화
	    	System.out.println("파일 객체화 성공");
	    	pimg=file.toURI().toString(); 
	    	Image img = new Image(pimg); // 경로 가져오기
	    	System.out.println("이미지파일 경로 가져오기 성공");
	    	preview.setImage(img); // 미리보기 띄우기
	    	System.out.println("미리보기 띄우기 성공");
	    	try {
	    		FileInputStream is = new FileInputStream(file); // 위의 file 객체 가져오기
	    		File copyfile = new File("C:/Users/504/git/team5_orderapp/ERIYA/src/img/"+file.getName()); // 각자 경로대로 설정
	    		FileOutputStream os = new FileOutputStream( copyfile );
	    		byte[] bytes = new byte[33554432]; // 32메가 바이트배열 선언
	    		int size;
	    		while((size=is.read(bytes))>0) { // 남은 읽어올 바이트가 있다면 반복실행
	    			os.write(bytes, 0, size); // 읽어온 바이트만큼 그대로 내보내기
	    		}
	    		is.close(); os.close(); // 인풋,아웃풋 스트림 종료
	    		pimg=copyfile.toURI().toString(); // 파일 경로 저장
	    	}catch(Exception e) {System.out.println("이미지파일 추가 오류 : "+e);}
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
