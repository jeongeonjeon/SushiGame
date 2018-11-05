package kr.co.mlec;

import java.util.Random;


public class InsertOrder extends BaseOrder {


	@Override
	public String execute(){
		
		Random ran = new Random();
		int num1 = ran.nextInt(8);
		int num2 = ran.nextInt(3)+1;
		
		//DB에 저장되어 있는 menu_id
		String[] menuList = {"   egg","  tuna","shrimp","salmon"," cider","  coke"," juice","  beer"};
		String menu = null;
		OrderVO order = null;
			for(int i=0;i<8;i++) {
				if(num1==i) {
					menu = menuList[i];
				}
			}
			
			order = new OrderVO();
			order.setMenu(menu);
			order.setCnt(num2);
			
			service.insertOrder(order);
		
		return order.toString();
		
		
	}
	

}
