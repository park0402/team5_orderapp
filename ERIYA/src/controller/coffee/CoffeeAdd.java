package controller.coffee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import controller.login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class CoffeeAdd implements Initializable{
	
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
	    void add(ActionEvent event) { // ��ǰ ��Ͻ�
	    	String cName = txtname.getText(); String cCon=txtcontent.getText();
	    	int cPrice = Integer.parseInt(txtprice.getText()); // �Է°� ��������
	    	//��üȭ(dto �ۼ� ��)
	    	
	    	//DBó��(dao �ۼ� ��)
	    	
	    }
	    private String pimg=null;
	    @FXML
	    void cancel(ActionEvent event) { // ���(�ڷΰ���)
	    	Home.home.loadpage("/view/coffee/coffeeList.fxml");
	    }

	    @FXML
	    void imgadd(ActionEvent event) { // �̹����߰���
	    	FileChooser fileChooser = new FileChooser(); // ���� ���� Ŭ���� ����
	    	fileChooser.getExtensionFilters().add(  // ���� ���� ����
    				new ExtensionFilter("�̹�������:image file" , "*png" , "*jpeg" , "*jpg","*gif", "*png") );
	    	File file=fileChooser.showOpenDialog(new Stage()); // ������ ������ File Ŭ������ ��üȭ
	    	pimg=file.toURI().toString(); 
	    	Image img = new Image(pimg); // ��� ��������
	    	preview.setImage(img); // �̸����� ����
	    	
	    	try {
	    		FileInputStream is = new FileInputStream(file); // ���� file ��ü ��������
	    		File copyfile = new File("C:/Users/504/git/team5_orderapp/ERIYA/src/img/"+file.getName()); // ���� ��δ�� ����
	    		FileOutputStream os = new FileOutputStream( copyfile );
	    		byte[] bytes = new byte[33554432]; // 32�ް� ����Ʈ�迭 ����
	    		int size;
	    		while((size=is.read(bytes))>0) { // ���� �о�� ����Ʈ�� �ִٸ� �ݺ�����
	    			os.write(bytes, 0, size); // �о�� ����Ʈ��ŭ �״�� ��������
	    		}
	    		is.close(); os.close(); // ��ǲ,�ƿ�ǲ ��Ʈ�� ����
	    		pimg=copyfile.toURI().toString(); // ���� ��� ����
	    	}catch(Exception e) {System.out.println("�̹������� �߰� ���� : "+e);}
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
