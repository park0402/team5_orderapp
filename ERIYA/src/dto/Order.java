package dto;

public class Order {
	
	private int ordernum;
	private String ordertime;
	private int orderprice;
	private int mnum;
	public Order(int ordernum, String ordertime, int orderprice, int mnum) {
		super();
		this.ordernum = ordernum;
		this.ordertime = ordertime;
		this.orderprice = orderprice;
		this.mnum = mnum;
	}
	public Order() {}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;   
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public int getOrderprice() {
		return orderprice;
	}
	public void setOrderprice(int orderprice) {
		this.orderprice = orderprice;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	
	
	
	
	
	

}