package kr.co.mlec;

public abstract class BaseOrder {
	
	protected OrderService service;

	public BaseOrder() {
		service = OrderServiceFactory.getInstance();
	}
	
	abstract public String execute();
	

}
