package dto;

public class Cart {
	private int orderNum;
	private String fname;
	private int fQuan;
	private int cartPrice;
	private int mnum;
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getfQuan() {
		return fQuan;
	}
	public void setfQuan(int fQuan) {
		this.fQuan = fQuan;
	}
	public int getCartPrice() {
		return cartPrice;
	}
	public void setCartPrice(int cartPrice) {
		this.cartPrice = cartPrice;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public Cart(int orderNum, String fname, int fQuan, int cartPrice, int mnum) {
		super();
		this.orderNum = orderNum;
		this.fname = fname;
		this.fQuan = fQuan;
		this.cartPrice = cartPrice;
		this.mnum = mnum;
	}
	public Cart() {
		super();
	}
	
}
