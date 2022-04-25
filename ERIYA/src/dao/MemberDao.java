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
	
	private Connection con; // DB������ ���Ǵ� Ŭ���� : DB���� Ŭ��
	private PreparedStatement ps; // ����� DB�� SQL ���� �� �� ���Ǵ� �������̽� : DB���� �������̽�
	private ResultSet rs; // ������� �����ϴ� �������̽�
	

	public static MemberDao memberDao = new MemberDao(); // DB������ü
	
	public MemberDao() {

		try {
		// DB����
			Class.forName("com.mysql.cj.jdbc.Driver");	// 1. DB ����̹� ��������
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe?serverTimezone=UTC",
					"root", "1234"); // 2. DB �ּ� ����		
		}catch (Exception e) {
			System.out.println("DB ���� ����" + e);
		}
	}

	public boolean idcheck(String id) { // ���̵� �ߺ� Ȯ��
		try {
			String sql = "select *from cafe.member where mid=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) { // ���� ������� �����ϸ� -> �ش� ���̵� ����
				return true; // �ش� ���̵� �ߺ�
			}
		} catch (Exception e) {
			System.out.println("memberdao idcheck ���� "+e);
		}
		return false;
	}
	
	public boolean signup(Member member) { // ȸ������
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
			System.out.println("memberdao signup ���� "+e);
		}
		return false;
	}
	
	public boolean login(String id, String pw) { // �α���
		try {
			// sql �ۼ�
			String sql = "select *from cafe.member where mid=? and mpw=?";			
			// sql ����
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);		
			// sql ����
			rs = ps.executeQuery();
			// sql ���
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("memberdao login ���� " + e);
		}
		return false;
	}
	
	public String findid(String email) { // ���̵� ã��
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
			System.out.println("memberdao findid ���� " + e);
		}
		return null;
	}
	
	public String findpw(String id, String email) { // ��й�ȣ ã��
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
			System.out.println("memberdao getmember ���� " + e);
		}return null;
	}
	
	public boolean delete(int mnum) {
		try {
			String sql = "delete from cafe.member where mnum=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, mnum);
			ps.executeLargeUpdate(); // insert, update, delete ����
			return true;
		} catch (Exception e) {
			System.out.println("SQL ���� " + e);
		}
		return false;
	}
	
}
