package kr.co.mlec;

import javax.swing.JLabel;

import kr.co.mlec.menu.Drink;
import kr.co.mlec.menu.Sushi;

public class Profit extends Score {
	
	JLabel lab = null;
	int profit = 0;
	int price;
	
	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public Profit(JLabel label) {
		this.lab = label;
	}

	@Override
	void calculate(String name) {
		name=name.trim();
		
		if(name.equals("egg")||name.equals("shrimp")||name.equals("salmon")||name.equals("tuna")) {
			
			price = new Sushi().ImportPrice(name);
		}else {
			
			price = new Drink().ImportPrice(name);
		}
		System.out.println("profit class"+getProfit());
		
		setProfit(getProfit()+price);
		lab.setText(getProfit()+"원");
	
		
		
		
		
	}

}
