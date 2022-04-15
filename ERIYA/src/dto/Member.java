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

	public static void sendmail( String 받는사람이메일 , String 내용 ) {
		//1. 보내는 사람 정보
		String 보내는사람이메일 = ""; 
		String 보내는사람이메일비밀번호 = ""; 
		//2. 호스트 설정 [ 네이버기준 = 고정 ]
		Properties properties = new Properties(); // 컬렉션프레임워크 [ map컬렉션 ]
		properties.put("mail.smtp.host","smtp.naver.com"); // 호스트 주소 
		properties.put("mail.smtp.port", 587);	// 호스트 포트번호
		properties.put("mail.smtp.auth", "true"); // 보내는사람이메일 인증
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); // *보안 연결 버전 설정
		
		// 3. 인증처리 [ Session : javax.mail 패키지 ] 
			// Session.getDefaultInstance( 설정객체 , 인증객체 ) 
		Session session = Session.getDefaultInstance( properties , new Authenticator() {
			@Override // 오버라이딩 // 보내는사람의 이메일주소,비밀번호 인증 해주는 메소드 구현
			protected PasswordAuthentication getPasswordAuthentication() { 
				return new PasswordAuthentication(보내는사람이메일, 보내는사람이메일비밀번호);
			}
		});
		// 4. 메일 보내기 
		try {
			MimeMessage message = new MimeMessage(session);		// Mime 프로토콜 : 전자우편 표준 포멧[형식]
			message.setFrom( new InternetAddress(보내는사람이메일) ); // 보내는사람 
			message.addRecipient( Message.RecipientType.TO , new InternetAddress(받는사람이메일) ); // 받는사람이메일
			// 내용 
			message.setSubject("회원님의 패스워드 찾기"); // 메일 전송 
			message.setText("회원님의 비밀번호 : " + 내용 );
			// 전송
			Transport.send(message);
		}catch (Exception e) { System.out.println("메일전송실패 "  +e);}
	}

	
}
