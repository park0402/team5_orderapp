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
			// 1. �Է� 
			Scanner scanner = new Scanner(System.in);
			System.out.println(" *** �Ե����� ��ǰ�߰� *** ");
			String  
			int ��� 
			int ���� 
			// 2. ��ü [ ���� ���� -> �ϳ� ��ü ] 
			food cartlist = new food(��ǰ��, ���, ����);
			// 3. ����Ʈ�� ���� 
			cartlist.add(��ǰ);
			// 4. ����ó��
			try { // ����[����]�� �߻��Ұ� ���� �ڵ� ���� ( ���� ) 				//  ���� ���   , �̾��=true[�ɼ�]
				FileOutputStream outputStream = new FileOutputStream("D:/java/�Ե��������.txt" , true );
				String �������� = ��ǰ��+","+���+","+����+"\n"; // , : �ʵ� ���п�   \n : ��ǰ ���п�
				outputStream.write( ��������.getBytes() ); // ���ڿ� -> ����Ʈ��
			}catch( Exception e ) { // ����[����] ó��[���] : Exception Ŭ����
			}
			System.out.println("�˸�]] ��ǰ ���� �Ϸ� ~~~ ");
		}
}  