package kr.co.mlec;

import javax.swing.JLabel;

import kr.co.mlec.menu.Drink;
import kr.co.mlec.menu.Sushi;

public class Loss extends Score{
	
	JLabel lab = null;
	int loss = 0;
	int price;
	
	public int getLoss() {
		return loss;
	}

	public void setLoss(int loss) {
		this.loss = loss;
	}

	public Loss(JLabel label) {
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
		
		setLoss(getLoss()+price);
		lab.setText(getLoss()+"원");
	
		
		
		
		
	}

}
