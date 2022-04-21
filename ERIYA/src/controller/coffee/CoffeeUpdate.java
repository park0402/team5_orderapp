package controller.coffee;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import controller.home.Home;
import dao.FoodDao;
import dto.Food;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class CoffeeUpdate implements Initializable{
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
	    void update(ActionEvent event) { // ��ǰ ���� ��Ͻ�
	    	if(fimg==null) {fimg=coffeeList.select.getFimg();}
	    	String cName = txtname.getText(); String cCon=txtcontent.getText();
	    	int cPrice = Integer.parseInt(txtprice.getText()); // �Է°� ��������
	    	//��üȭ(dto �ۼ� ��)
	    	Food food = new Food(0, cPrice, fimg, cCon, cName);
	    	//DBó��(dao �ۼ� ��)
	    	boolean result = FoodDao.foodDao.update(food);
	    	//���ó��
	    	if(result) {
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setHeaderText("��ǰ ��� �Ϸ�");
	    		alert.showAndWait();
	    		Home.home.loadpage("/view/coffee/coffeeList.fxml");
	    	}else {
	    		Alert alert = new Alert(AlertType.INFORMATION);
	    		alert.setHeaderText("��ǰ ��� ����");
	    		alert.showAndWait();
	    	}
	    }
	    private String fimg=null;
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
	    	fimg=file.toURI().toString(); 
	    	Image img = new Image(fimg); // ��� ��������
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
	    		fimg=copyfile.toURI().toString(); // ���� ��� ����
	    	}catch(Exception e) {System.out.println("�̹������� �߰� ���� : "+e);}
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Food food = coffeeList.select;
	    txtname.setText(food.getFname());
	    txtcontent.setText(food.getFcontent());
	    txtprice.setText(food.getFprice()+"");
	}
}
