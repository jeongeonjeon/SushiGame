package kr.co.mlec;

public abstract class Score {
	
	private int profit = 0;
	private int loss = 0;
	
	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public int getLoss() {
		return loss;
	}

	public void setLoss(int loss) {
		this.loss = loss;
	}

	abstract void calculate(String name);

}
