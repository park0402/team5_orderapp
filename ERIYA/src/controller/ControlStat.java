package controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import controller.home.Home;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class ControlStat implements Initializable{
	
	 @FXML
	    private BorderPane borderpane;

	    @FXML
	    private Label lblloginid;

	    @FXML
	    private Label lblback;

	    @FXML
	    private BarChart chartday;

	    @FXML
	    private BarChart chartweek;

	    @FXML
	    private Label lblsell;

	    @FXML
	    void back(MouseEvent event) {
	    	Home.home.loadpage("/view/home/home.fxml");
	    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		byte[] bytes=null;
			try {
				bytes = Files.readAllBytes(Paths.get("D:/java/test.txt"));
			} catch (IOException e) {
				e.printStackTrace();
		}
		String[] sp1 = new String(bytes).split("\n");
		int[] sell = new int[sp1.length];
		for(int i=0; i<sp1.length; i++) {
			String[] j = sp1[i].split(",");
			sell[i]=Integer.parseInt(j[1]);
		}
		//���� ���� �ȸ� �� ã��
			int m=0; // �ֺ� �ʱ�ȭ
			int[] index = new int[100]; // ī����
			int max = -1;
			
			for(int i=0; i<sell.length; i++) {
				index[sell[i]]++;
			}
				for(int i=0; i<index.length; i++) {
					if(max<index[i]) {
						max=index[i];
						m=i;
					}
				}
				lblsell.setText("���� ���� �ȸ� ���� : "); // dto.food���� m ��ȣ�� ���� �̸� ȣ��
				
		//�Ϻ� ����
			XYChart.Series series = new XYChart.Series<>(); //xy�� �迭 ����
			
				//������ ��������
					for(int i=0; i<sp1.length; i++) {
					String[] j = sp1[i].split(",");
					String[] J;
					int c = Integer.parseInt(j[2]); // ���Ⱚ �ֱ�
					if(i-1>=0) {J = sp1[i-1].split(","); //���� ���Ⱚ ����
					for(int q=i; q>=0; q--) {
						if(j[3].equals(J[3]) && (i-1)>=0) { // ���� �����̶� ��¥ ������
							c+=Integer.parseInt(J[2]); // ���� ���Ⱚ �����ֱ�
						} //if2 e
					} //for2 e
				} // if e
					XYChart.Data data = new XYChart.Data<>( j[3] , c );	//���Ⱚ �ֱ�
					series.getData().add(data); // �迭�� ������ ��ü �߰�
			} // for e
			
		chartday.getData().add(series); // ������ ������Ʈ�� �߰�
		//�ְ� ����
	} // initialize e
}
