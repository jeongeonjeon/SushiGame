package kr.co.mlec;

public class OrderVO {

	private String menu;
	private int cnt;
	public OrderVO() {
		super();
	}
	public OrderVO(String menu, int cnt) {
		super();
		this.menu = menu;
		this.cnt = cnt;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return menu + " " + cnt + "개";
	}


}
