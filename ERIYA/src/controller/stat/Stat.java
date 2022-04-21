package controller.stat;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import controller.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Stat implements Initializable{

	@FXML
	private BorderPane borderpane;
 
	 @FXML
	    private BarChart<?, ?> chartday;

	    @FXML
	    private Label lblsell;

	    @FXML
	    private BarChart<?, ?> chartweek;
	
	@FXML
	private Label lblback;

	@FXML
	void back(MouseEvent event) {
		System.out.println("�ڷΰ��� ��ư�� �������ϴ�.");
		Main.instance.loadpage("/view/home/home.fxml");
	}
	
	Calendar ca;
    SimpleDateFormat sdf;
    Date date;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		byte[] bytes=null;
		try {
			bytes = Files.readAllBytes(Paths.get("D:/java/test.txt"));
		
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
//			ObservableList<XYChart.Series<String, Integer>> list = FXCollections.observableArrayList();
			//������ ��������
				for(int i=0; i<sp1.length; i++) {
				String[] j = sp1[i].split(","); // ������ ���� 0: ������ 1: �����ȣ 2: ���� 3: ��¥
				//��¥�� ���Ⱚ ���ϱ�
				int c = Integer.parseInt(j[2]); // ���Ⱚ �ֱ�
				for(int q=i; q>=0; q--) {
					if((i-1)>=0 && q>0) { // i�� q�� ���� ����(���� �ȶ߰�)
						String[] J;
						J = sp1[q-1].split(","); //���� ���Ⱚ ����
						if(j[3].equals(J[3])) { //���� ���Ⱚ�̶� ��¥ ������
						c+=Integer.parseInt(J[2]); // ���� ���Ⱚ �����ֱ� �ݺ�
						}
					} //if e
				} // �Ϻ�for e
				
				//�����͸� ��Ʈ�� �ֱ�
				 series.setName("�׽�Ʈ");
				 System.out.println( "�׽�Ʈ ��¥ : " +  j[3] +"   ����:    " + c);
				 series.getData().add(  new XYChart.Data(   j[3]    ,c));
				 System.out.println(series.getData().get(i) );
//					Map<String, Integer> map = new HashMap<String, Integer>();
//					map.put(j[3], c);
//					for(String key : map.keySet()) {
//						XYChart.Data data = new XYChart.Data<>(key, map.get(key));
//						series.getData().add(data);
//					}
//				 XYChart.Data data = new XYChart.Data<>( j[3] , c );	//���Ⱚ �ֱ�
//					series.getData().add(data);// �迭�� ������ ��ü �߰�
				//�ְ� ����
					//��¥ Date�������� ��ȯ
				ca=Calendar.getInstance(); sdf = new SimpleDateFormat("yyyy-MM-dd");
				date = sdf.parse(j[3]);
				ca.setTime(date);
				int s=Integer.parseInt(j[2]); // ���Ⱚ �ֱ�
				for(int q=i; q>=0; q--) { // i�� �������� �����͵� �� �ݺ�
					if((i-1)>=0 && q>0) { // null ���� ���ϰ� ���� ����
						String[] J;
						J = sp1[q-1].split(",");
						Date d1=sdf.parse(j[3]); Date d2=sdf.parse(J[3]); // ��¥ Date�������� ��ȯ
						Calendar c1 = Calendar.getInstance(); c1.setTime(d1); Calendar c2 = Calendar.getInstance(); c2.setTime(d2); // �޷¿� �ֱ�
						if(c1.get(Calendar.WEEK_OF_MONTH)==c2.get(Calendar.WEEK_OF_MONTH)) { //���� ���� �� ���
							s+=Integer.parseInt(J[2]);
						}
					}
				} // �ְ�for e
				 System.out.println("�ְ����� Ȯ��: "+s);
		} // for e
				//chartday.getData().add(series); // ������ ������Ʈ�� �߰�
				//chartweek.getData().add(week);
//				list.addAll(series);
//				System.out.println("������ Ȯ�� : "+list.get(0).getData().get(0).getXValue());
//				System.out.println("asdasdas:" +list.toString() );
//				chartday.setData(list);
//				XYChart.Series series2 = new XYChart.Series<>();
//				XYChart.Data data = new XYChart.Data<>( 1 , 2  );
//				series2.getData().add(data);
				chartday.getData().add(series);
		} catch (Exception e) {
			e.printStackTrace();
	}
	}
}