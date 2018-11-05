package kr.co.mlec;

import java.util.List;

public class OrderService {
	private OrderDAO dao;
	
	
	public OrderService() {
		dao = new OrderDAO();
	}


	public synchronized void insertOrder(OrderVO order) {
		
		dao.insertOrder(order);
	}
	public List<OrderVO> selectOrder(){
		List<OrderVO> orderList = dao.selectOrder();
		return orderList;
	}
	
	public void deleteOrder() {
		dao.deleteOrder();
	}
	

}
