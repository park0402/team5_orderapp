package controller.cart;

public class CartDataModel {
	private String fname;
	private int quan;
	private int fprice;
	public CartDataModel(String fname, int quan, int fprice) {
		super();
		this.fname = fname;
		this.quan = quan;
		this.fprice = fprice;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public int getQuan() {
		return quan;
	}
	public void setQuan(int quan) {
		this.quan = quan;
	}
	public int getFprice() {
		return fprice;
	}
	public void setFprice(int fprice) {
		this.fprice = fprice;
	}
	public CartDataModel() {
		super();
	}

}