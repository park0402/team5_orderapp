package controller.coffee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import controller.Main;
import controller.home.Home;
import dao.FoodDao;
import dto.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;



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
    private TextArea txtcontent;

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
    	Food food = new Food(0, cPrice, pimg, cCon, cName);
    	//DBó��(dao �ۼ� ��)
    	boolean result = FoodDao.foodDao.add(food);
    	//���ó��
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("��ǰ ��� �Ϸ�");
    		alert.showAndWait();
    		Main.instance.loadpage("/view/coffee/coffeeList.fxml");
    	}else {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("��ǰ ��� ����");
    		alert.showAndWait();
    	}
    }
    private String pimg=null; // �޼ҵ� �ۿ��� ����

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

	    @FXML
	    void back(MouseEvent event) {
	    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
			Main.instance.loadpage("/view/coffee/coffeeList.fxml");
	    }

	    @FXML
	    void cancel(ActionEvent event) {
	    	System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
	    	Main.instance.loadpage("/view/coffee/coffeeList.fxml");
	    }

	    @Override
	    public void initialize(URL arg0, ResourceBundle arg1) {
	    
	    
	    }
	   
}
