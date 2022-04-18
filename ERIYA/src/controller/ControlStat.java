package controller;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import controller.home.Home;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ControlStat implements Initializable{
	
	 @FXML
	    private Pane pane;

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
				lblsell.setText("���� ���� �ȸ� ���� : "+m); // dto.food���� m ��ȣ�� ���� �̸� ȣ��
				
		//�Ϻ� ����
				XYChart.Series series = new XYChart.Series<>();
				try {
				//������ ��������
					for(int i=0; i<sp1.length; i++) {
					String[] j = sp1[i].split(","); // ������ ���� 0: ������ 1: �����ȣ 2: ���� 3: ��¥
					String[] J;
					int c = Integer.parseInt(j[2]); // ���Ⱚ �ֱ�
					for(int q=i; q>=0; q--) {
						if((i-1)>=0 && q>0) { // ���� �����̶� ��¥ ������
							J = sp1[q-1].split(","); //���� ���Ⱚ ����
							if(j[3].equals(J[3])) { //���� ���Ⱚ�̶� ��¥ ������
							c+=Integer.parseInt(J[2]); // ���� ���Ⱚ �����ֱ� �ݺ�
							}
						} //if e
					} //for2 e
					 series.setName("�׽�Ʈ");
					 series.setData(FXCollections.observableArrayList(
							 new XYChart.Data(j[3],c)));
					 System.out.println(series.getData().get(0));
						Map<String, Integer> map = new HashMap<String, Integer>();
						map.put(j[3], c);
						for(String key : map.keySet()) {
							XYChart.Data data = new XYChart.Data<>(key, map.get(key));
							series.getData().add(data);
						}
//					 XYChart.Data data = new XYChart.Data<>( j[3] , c );	//���Ⱚ �ֱ�
//						series.getData().add(data);// �迭�� ������ ��ü �߰�
			} // for e
					chartday.getData().add(series); // ������ ������Ʈ�� �߰�
				}catch(Exception e) {System.out.println(e);}
		//�ְ� ����
	} // initialize e
}
