package dto;

public class Food {
	String ordertime;
	int fnum;
	int fprice;
	String fimg;
	String fcontent;
	String fname;
	
	
	

	public Food() {        

	}




	public Food(String ordertime, int fnum, int fprice, String fimg, String fcontent, String fname) {
		super();
		this.ordertime = ordertime;
		this.fnum = fnum;
		this.fprice = fprice;
		this.fimg = fimg;
		this.fcontent = fcontent;
		this.fname = fname;
	}




	public String getOrdertime() {
		return ordertime;
	}




	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}




	public int getFnum() {
		return fnum;
	}




	public void setFnum(int fnum) {
		this.fnum = fnum;
	}




	public int getFprice() {
		return fprice;
	}




	public void setFprice(int fprice) {
		this.fprice = fprice;
	}




	public String getFimg() {
		return fimg;
	}




	public void setFimg(String fimg) {
		this.fimg = fimg;
	}




	public String getFcontent() {
		return fcontent;
	}




	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}




	public String getFname() {
		return fname;
	}




	public void setFname(String fname) {
		this.fname = fname;
	}
	
	
	
	
	

}
