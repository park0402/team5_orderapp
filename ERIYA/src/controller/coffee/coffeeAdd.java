package controller.coffee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;



public class coffeeAdd implements Initializable{
	
	@FXML
    private BorderPane borderpane;

    @FXML
    private Label lblback;

    @FXML
    private Button btnadd;

    @FXML
    private Button btncancel;

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
	    void add(ActionEvent event) {
	    	String cName = txtname.getText(); String cCon=txtcontent.getText();
	    	int cPrice = Integer.parseInt(txtprice.getText()); // 입력값 가져오기
	    	//객체화(dto 작성 후)
	    	
	    	//DB처리(dao 작성 후)
	    }
	    
	    private String pimg=null;

	    @FXML
	    void imgadd(ActionEvent event) {
	    	FileChooser fileChooser = new FileChooser(); // 파일 선택 클래스 선언
	    	fileChooser.getExtensionFilters().add(  // 파일 필터 설정
    				new ExtensionFilter("이미지파일:image file" , "*png" , "*jpeg" , "*jpg","*gif", "*png") );
	    	File file=fileChooser.showOpenDialog(new Stage()); // 선택한 파일을 File 클래스로 객체화
	    	pimg=file.toURI().toString(); 
	    	Image img = new Image(pimg); // 경로 가져오기
	    	preview.setImage(img); // 미리보기 띄우기
	    	
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

	    @FXML
	    void back(MouseEvent event) {
	    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
			Main.instance.loadpage("/view/coffee/coffeeList.fxml");
	    }

	    @FXML
	    void cancel(ActionEvent event) {
	    	System.out.println("뒤로가기 버튼을 눌렀습니다.");
	    	Main.instance.loadpage("/view/coffee/coffeeList.fxml");
	    }

	    @Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
	    
	    
	    }
}
