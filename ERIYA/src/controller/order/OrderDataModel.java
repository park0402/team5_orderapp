package controller.order;

public class OrderDataModel {
	private String orderDate;
	private int Price;
	private String fName;
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public OrderDataModel(String orderDate, int price, String fName) {
		this.orderDate = orderDate;
		Price = price;
		this.fName = fName;
	}
	public OrderDataModel() {
	}
}
