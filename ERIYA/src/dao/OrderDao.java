package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


import controller.login.Login;

public class OrderDao {
		
		@Override
		public void addToCart() {
			// 1. 입력 
			Scanner scanner = new Scanner(System.in);
			System.out.println(" *** 롯데리아 상품추가 *** ");
			String  
			int 재고 
			int 가격 
			// 2. 객체 [ 여러 변수 -> 하나 객체 ] 
			food cartlist = new food(상품명, 재고, 가격);
			// 3. 리스트에 저장 
			cartlist.add(상품);
			// 4. 파일처리
			try { // 예외[오류]가 발생할것 같은 코드 묶음 ( 예상 ) 				//  파일 경로   , 이어쓰기=true[옵션]
				FileOutputStream outputStream = new FileOutputStream("D:/java/롯데리아재고.txt" , true );
				String 내보내기 = 상품명+","+재고+","+가격+"\n"; // , : 필드 구분용   \n : 제품 구분용
				outputStream.write( 내보내기.getBytes() ); // 문자열 -> 바이트열
			}catch( Exception e ) { // 예외[오류] 처리[잡기] : Exception 클래스
			}
			System.out.println("알림]] 상품 저장 완료 ~~~ ");
		}
}  