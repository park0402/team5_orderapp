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
		System.out.println("뒤로가기 버튼을 눌렀습니다.");
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
			lblsell.setText("가장 많이 팔린 음료 : "+m); // dto.food에서 m 번호의 음료 이름 호출
			
	//일별 매출
			XYChart.Series series = new XYChart.Series<>();
//			ObservableList<XYChart.Series<String, Integer>> list = FXCollections.observableArrayList();
			//데이터 가져오기
				for(int i=0; i<sp1.length; i++) {
				String[] j = sp1[i].split(","); // 데이터 분할 0: 구매자 1: 음료번호 2: 가격 3: 날짜
				//날짜별 매출값 구하기
				int c = Integer.parseInt(j[2]); // 매출값 넣기
				for(int q=i; q>=0; q--) {
					if((i-1)>=0 && q>0) { // i랑 q값 조건 선언(에러 안뜨게)
						String[] J;
						J = sp1[q-1].split(","); //비교할 매출값 선언
						if(j[3].equals(J[3])) { //비교할 매출값이랑 날짜 같으면
						c+=Integer.parseInt(J[2]); // 이전 매출값 더해주기 반복
						}
					} //if e
				} // 일별for e
				
				//데이터를 차트에 넣기
				 series.setName("테스트");
				 System.out.println( "테스트 날짜 : " +  j[3] +"   가격:    " + c);
				 series.getData().add(  new XYChart.Data(   j[3]    ,c));
				 System.out.println(series.getData().get(i) );
//					Map<String, Integer> map = new HashMap<String, Integer>();
//					map.put(j[3], c);
//					for(String key : map.keySet()) {
//						XYChart.Data data = new XYChart.Data<>(key, map.get(key));
//						series.getData().add(data);
//					}
//				 XYChart.Data data = new XYChart.Data<>( j[3] , c );	//매출값 넣기
//					series.getData().add(data);// 계열에 데이터 객체 추가
				//주간 매출
					//날짜 Date형식으로 변환
				ca=Calendar.getInstance(); sdf = new SimpleDateFormat("yyyy-MM-dd");
				date = sdf.parse(j[3]);
				ca.setTime(date);
				int s=Integer.parseInt(j[2]); // 매출값 넣기
				for(int q=i; q>=0; q--) { // i를 기준으로 이전것들 비교 반복
					if((i-1)>=0 && q>0) { // null 참조 안하게 조건 선언
						String[] J;
						J = sp1[q-1].split(",");
						Date d1=sdf.parse(j[3]); Date d2=sdf.parse(J[3]); // 날짜 Date형식으로 변환
						Calendar c1 = Calendar.getInstance(); c1.setTime(d1); Calendar c2 = Calendar.getInstance(); c2.setTime(d2); // 달력에 넣기
						if(c1.get(Calendar.WEEK_OF_MONTH)==c2.get(Calendar.WEEK_OF_MONTH)) { //둘이 같은 주 라면
							s+=Integer.parseInt(J[2]);
						}
					}
				} // 주간for e
				 System.out.println("주간매출 확인: "+s);
		} // for e
				//chartday.getData().add(series); // 데이터 막대차트에 추가
				//chartweek.getData().add(week);
//				list.addAll(series);
//				System.out.println("데이터 확인 : "+list.get(0).getData().get(0).getXValue());
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