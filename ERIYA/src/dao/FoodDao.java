package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Food;

public class FoodDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public static FoodDao foodDao = new FoodDao();
	public FoodDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafe?serverTimezone=UTC", "root", "1234");
		}catch(Exception e) {System.out.println("DB�������� "+e);}
	}
	
	//�޴� �߰�
	public boolean add(Food food) {
		try {
			String sql="insert into food(fnum,fname,fcontent,fprice,fimg) values(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1, food.getFnum());
			ps.setString(2, food.getFname());
			ps.setString(3, food.getFcontent());
			ps.setInt(4, food.getFprice());
			ps.setString(5, food.getFimg());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("�޴��߰����� "); e.printStackTrace();}
		return false;
	}
	//��� ��ǰ ��½�Ű��
	public ArrayList<Food> list(){
		try {
			ArrayList<Food> foodList = new ArrayList<>();
			String sql="select*from food";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Food food = new Food(
						rs.getInt(1),
						rs.getInt(4),
						rs.getString(5),
						rs.getString(3),
						rs.getString(2)
						);
				foodList.add(food);
			}return foodList;
		}catch(Exception e) {System.out.println("��ǰ��¿��� "); e.printStackTrace();}
		return null;
	}
	
	//��ǰ �����ϱ�
	public boolean delete(int fnum) {
		String sql = "delete from food where fnum=?";
		try {
		ps = con.prepareStatement(sql);
		ps.setInt(1, fnum);
		ps.executeUpdate();
		return true;
		}catch(Exception e) {System.out.println("��ǰ�������� "); e.printStackTrace();}
		return false;
	}
	//��ǰ ����
	public boolean update(Food food) {
		try {
			String sql="update food set fname=?,fcontent=?,fprice=?,fimg=? where fnum=?";
			ps=con.prepareStatement(sql);
			ps.setString(1, food.getFname());
			ps.setString(2, food.getFcontent());
			ps.setInt(3, food.getFprice());
			ps.setString(4, food.getFimg());
			ps.setInt(5, food.getFnum());
			ps.executeUpdate();
			return true;
		}catch(Exception e) {System.out.println("�޴��߰����� "); e.printStackTrace();}
		return false;
	}
	//��ǰ ���� ��ȸ
	public int price(int fnum) {
		try {
			String sql="select fprice=? from food where fnum=?";
			ps=con.prepareStatement(sql);
			ps.setInt(2, fnum);
			rs=ps.executeQuery();
			int price = rs.getInt(1);
			return price;
		}catch(Exception e) {System.out.println("��ǰ������ȸ���� "); e.printStackTrace();}
		return 0;
	}
}
