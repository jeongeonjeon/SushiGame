package kr.co.mlec;


public class OrderServiceFactory {
	public static final OrderService instance = new OrderService();
	
	public static OrderService getInstance() {
		
		return instance;
	}
}
