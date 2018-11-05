package kr.co.mlec;

import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
	
	private List <OrderVO> orderList;

	public OrderDAO() {
		orderList = new ArrayList<>();
	}
	
	public List<OrderVO> selectOrder(){
		return orderList;
	}
	public void insertOrder(OrderVO order) {
		orderList.add(order);
	}

	public List<OrderVO> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderVO> orderList) {
		this.orderList = orderList;
	}
	
	public void deleteOrder() {
		this.orderList.remove(0);
	}
	
	

}
