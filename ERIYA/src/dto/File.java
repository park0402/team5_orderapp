package dto;

public class File {
	private int orderNum;
	private int fNum;
	public File(int orderNum, int fNum) {
		super();
		this.orderNum = orderNum;
		this.fNum = fNum;
	}
	public File() {
		super();
	}
	public int getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}
	public int getfNum() {
		return fNum;
	}
	public void setfNum(int fNum) {
		this.fNum = fNum;
	}
}