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
		//가장 많이 팔린 것 찾기
			int m=0; // 최빈값 초기화
			int[] index = new int[100]; // 카운팅
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
				lblsell.setText("가장 많이 팔린 음료 : "); // dto.food에서 m 번호의 음료 이름 호출
				
		//일별 매출
			XYChart.Series series = new XYChart.Series<>(); //xy축 계열 생성
			
				//데이터 가져오기
					for(int i=0; i<sp1.length; i++) {
					String[] j = sp1[i].split(",");
					String[] J;
					int c = Integer.parseInt(j[2]); // 매출값 넣기
					if(i-1>=0) {J = sp1[i-1].split(","); //이전 매출값 선언
					for(int q=i; q>=0; q--) {
						if(j[3].equals(J[3]) && (i-1)>=0) { // 이전 매출이랑 날짜 같으면
							c+=Integer.parseInt(J[2]); // 다음 매출값 더해주기
						} //if2 e
					} //for2 e
				} // if e
					XYChart.Data data = new XYChart.Data<>( j[3] , c );	//매출값 넣기
					series.getData().add(data); // 계열에 데이터 객체 추가
			} // for e
			
		chartday.getData().add(series); // 데이터 막대차트에 추가
		//주간 매출
	} // initialize e
}
