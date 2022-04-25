package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.Member;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.ArcType;

public class MemberDao {
	
	private Connection con; // DB연동시 사용되는 클래스 : DB연동 클래
	private PreparedStatement ps; // 연결된 DB내 SQL 조직 할 때 사용되는 인터페이스 : DB조작 인터페이스
	private ResultSet rs; // 결과물을 조작하는 인터페이스
	

	public static MemberDao memberDao = new MemberDao(); // DB연동객체
	
	public MemberDao() {

		try {
		// DB연동
			Class.forName("com.mysql.cj.jdbc.Driver");	// 1. DB 드라이버 가져오기
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe?serverTimezone=UTC",
					"root", "1234"); // 2. DB 주소 연결		
		}catch (Exception e) {
			System.out.println("DB 연동 오류" + e);
		}
	}

	public boolean idcheck(String id) { // 아이디 중복 확인
		try {
			String sql = "select *from cafe.member where mid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) { // 다음 결과물이 존재하면 -> 해당 아이디 존재
				return true; // 해당 아이디 중복
			}
		} catch (Exception e) {
			System.out.println("memberdao idcheck 오류 "+e);
		}
		return false;
	}
	
	public boolean signup(Member member) { // 회원가입
		try {
			String sql = "insert into cafe.member(mid, mpw, mname, mphone, memail) values(?,?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getMid());
			ps.setString(2, member.getMpw());
			ps.setString(3, member.getMname());
			ps.setString(4, member.getMphone());
			ps.setString(5, member.getMemail());
			
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("memberdao signup 오류 "+e);
		}
		return false;
	}
	
	public boolean login(String id, String pw) { // 로그인
		try {
			// sql 작성
			String sql = "select *from cafe.member where mid=? and mpw=?";			
			// sql 조작
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);		
			// sql 실행
			rs = ps.executeQuery();
			// sql 결과
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("memberdao login 오류 " + e);
		}
		return false;
	}
	
	public String findid(String email) { // 아이디 찾기
		try {
			String sql = "select *From cafe.member where memail=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(2);
				return id;
			}
			
		}catch (Exception e) {
			System.out.println("memberdao findid 오류 " + e);
		}
		return null;
	}
	
	public String findpw(String id, String email) { // 비밀번호 찾기
		try {
			String sql = "select *From cafe.member where mid=? and memail=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, email);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String password = rs.getString(3);
				return password;
			}
		} catch (Exception e) {
			System.out.println("memberdao findpw " + e);
		}
		return null;
	}
	
	public Member getmember(String id) {
		try {
			String sql = "select *from cafe.member where mid=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Member member = new Member(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getInt(7));
				return member;
			}
		} catch (Exception e) {
			System.out.println("memberdao getmember 오류 " + e);
		}return null;
	}
	
	public boolean delete(int mnum) {
		try {
			String sql = "delete from cafe.member where mnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, mnum);
			ps.executeLargeUpdate(); // insert, update, delete 실행
			return true;
		} catch (Exception e) {
			System.out.println("SQL 오류 " + e);
		}
		return false;
	}
	
}
