package kr.co.mlec;

import java.util.List;

public class SelectOrder extends BaseOrder {

	@Override
	public String execute() {
		
		List<OrderVO> orderList = service.selectOrder();
		int i=0; 
		
		for(OrderVO order : orderList) {
			order.setCnt(order.getCnt()-1);
			if(order.getCnt()==0) {
				System.out.println(order.getCnt());
				i++;
			}else {
				return order.toString();				
			}
		}
		if(i==1) {
			orderList.remove(0);
		}
		
		return null;
	}
   



   
   

}