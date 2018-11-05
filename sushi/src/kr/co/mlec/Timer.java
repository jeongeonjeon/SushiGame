package kr.co.mlec;

import javax.swing.JLabel;

public class Timer extends Thread{
	private int min=1;
	private int sec=0; 
	JLabel timeLabel = null;
	private String time = timeFormat(min,sec);
	
	Timer(){
		start();
	}
		
	public Timer(JLabel timeLabel) {
		super();
		this.timeLabel = timeLabel;
	}

	@Override
	public void run() {
		do {
			timeLabel.setText(timeFormat(min, sec));
			try {
				Thread.sleep(1000);
				if(sec == 0) {
					min-=1;
					sec = 59;
				}
				else {
					--sec;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(min!=0 || sec!=0);
		timeLabel.setText(timeFormat(min, sec));
		System.out.println(timeLabel.getText());
		System.out.println("end");

	}
	private String timeFormat(int minute,int second) {
		return String.format("%02d",minute)+":"+String.format("%02d", second);
	}
	
	

}
