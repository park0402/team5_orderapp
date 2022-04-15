package dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Member {

	private int mnum;
	private String mid;
	private String mpw;
	private String mname;
	private String memail;
	private String mphone;
	private int stamp;
	
	public Member() {	
	}
	
	public Member(int mnum, String mid, String mpw, String mname, String memail, String mphone, int stamp) {
		super();
		this.mnum = mnum;
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.memail = memail;
		this.mphone = mphone;
		this.stamp = stamp;
	}

	public int getMnum() {
		return mnum;
	}

	public void setMnum(int mnum) {
		this.mnum = mnum;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public int getStamp() {
		return stamp;
	}

	public void setStamp(int stamp) {
		this.stamp = stamp;
	}

	public static void sendmail( String �޴»���̸��� , String ���� ) {
		//1. ������ ��� ����
		String �����»���̸��� = ""; 
		String �����»���̸��Ϻ�й�ȣ = ""; 
		//2. ȣ��Ʈ ���� [ ���̹����� = ���� ]
		Properties properties = new Properties(); // �÷��������ӿ�ũ [ map�÷��� ]
		properties.put("mail.smtp.host","smtp.naver.com"); // ȣ��Ʈ �ּ� 
		properties.put("mail.smtp.port", 587);	// ȣ��Ʈ ��Ʈ��ȣ
		properties.put("mail.smtp.auth", "true"); // �����»���̸��� ����
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); // *���� ���� ���� ����
		
		// 3. ����ó�� [ Session : javax.mail ��Ű�� ] 
			// Session.getDefaultInstance( ������ü , ������ü ) 
		Session session = Session.getDefaultInstance( properties , new Authenticator() {
			@Override // �������̵� // �����»���� �̸����ּ�,��й�ȣ ���� ���ִ� �޼ҵ� ����
			protected PasswordAuthentication getPasswordAuthentication() { 
				return new PasswordAuthentication(�����»���̸���, �����»���̸��Ϻ�й�ȣ);
			}
		});
		// 4. ���� ������ 
		try {
			MimeMessage message = new MimeMessage(session);		// Mime �������� : ���ڿ��� ǥ�� ����[����]
			message.setFrom( new InternetAddress(�����»���̸���) ); // �����»�� 
			message.addRecipient( Message.RecipientType.TO , new InternetAddress(�޴»���̸���) ); // �޴»���̸���
			// ���� 
			message.setSubject("ȸ������ �н����� ã��"); // ���� ���� 
			message.setText("ȸ������ ��й�ȣ : " + ���� );
			// ����
			Transport.send(message);
		}catch (Exception e) { System.out.println("�������۽��� "  +e);}
	}

	
}
