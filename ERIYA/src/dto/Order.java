package dto;

public class Order {
	
	private int fnum;
	private int mnum;
	private boolean opt1; // true : 온도 ice
	private boolean opt2; // true : 사이즈 extra
	private boolean esp; // 에스프레소
	private boolean choco; // 초콜릿
	private boolean syrup; // 시럽
	private int quan; // 수량
	public Order(int fnum, int mnum, boolean opt1, boolean opt2, boolean esp, boolean choco, boolean syrup, int quan) {
		super();
		this.fnum = fnum;
		this.mnum = mnum;
		this.opt1 = opt1;
		this.opt2 = opt2;
		this.esp = esp;
		this.choco = choco;
		this.syrup = syrup;
		this.quan = quan;
	}
	public Order() {
		super();
	}
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public boolean isOpt1() {
		return opt1;
	}
	public void setOpt1(boolean opt1) {
		this.opt1 = opt1;
	}
	public boolean isOpt2() {
		return opt2;
	}
	public void setOpt2(boolean opt2) {
		this.opt2 = opt2;
	}
	public boolean isEsp() {
		return esp;
	}
	public void setEsp(boolean esp) {
		this.esp = esp;
	}
	public boolean isChoco() {
		return choco;
	}
	public void setChoco(boolean choco) {
		this.choco = choco;
	}
	public boolean isSyrup() {
		return syrup;
	}
	public void setSyrup(boolean syrup) {
		this.syrup = syrup;
	}
	public int getQuan() {
		return quan;
	}
	public void setQuan(int quan) {
		this.quan = quan;
	}
}