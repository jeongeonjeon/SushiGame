package kr.co.mlec;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import kr.co.mlec.menu.Beer;
import kr.co.mlec.menu.Cider;
import kr.co.mlec.menu.Coke;
import kr.co.mlec.menu.Egg;
import kr.co.mlec.menu.Juice;
import kr.co.mlec.menu.Salmon;
import kr.co.mlec.menu.Shrimp;
import kr.co.mlec.menu.Tuna;

public class Gameing extends Thread implements ActionListener {
	
	String userName;

	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	Panel p[] = new Panel[2];
	Frame f = new Frame();
	Color[] color = { Color.orange, Color.red, Color.orange, Color.green };
	String[] imgsrc = { "src/image/cider_dish.png", "src/image/coke_dish.png", "src/image/juice_dish.png",
			"src/image/beer_dish.png", "src/image/egg_dish.png", "src/image/tuna_dish.png", "src/image/shrimp_dish.png",
			"src/image/salmon_dish.png" };
	ImageIcon[] icon = { new ImageIcon(imgsrc[0]), new ImageIcon(imgsrc[1]), new ImageIcon(imgsrc[2]),
			new ImageIcon(imgsrc[3]), new ImageIcon(imgsrc[4]), new ImageIcon(imgsrc[5]), new ImageIcon(imgsrc[6]),
			new ImageIcon(imgsrc[7]) };
	ImageIcon btn_img;
	JButton sushi_btn[] = new JButton[4];
	JButton drink_btn[] = new JButton[4];
	JButton complete_btn;
	String menu_name = null;
	Image img;
	JPanel[] inner_p = new JPanel[3];
	Panel[] inner_p2 = new Panel[3];
	Panel[] cook_p = new Panel[2];
	JLabel orderList,time;
	String boolmenu1;
	String boolmenu2;
	JLabel money,losscnt;
	Timer t;
	BaseOrder o;
	int price;
	Score s,mn,ls;

	public Gameing() {
		
		f.setLayout(new GridLayout(2, 1, 10, 10));

		for (int i = 0; i < p.length; i++) {
			p[i] = new Panel();
			f.add(p[i]);
			p[i].setLayout(new GridLayout(1, 3, 10, 10));
		}

		// 상단
		for (int i = 0; i < inner_p.length; i++) {
			// 상단중앙 말풍선 그림 추가
			if (i == 1) {
				inner_p[i] = new JPanel() {

					protected void paintComponent(Graphics g) {

						ImageIcon img = new ImageIcon("src/image/board.png");
						Image image = img.getImage();
						g.drawImage(image, -12, 0, 340, 300, null);

					}
				};
				inner_p[i].setLayout(null);

			} else {
				inner_p[i] = new JPanel();
			}
			p[0].add(inner_p[i]);
		}
		// 상단 왼쪽 : 타이머
		inner_p[0].setLayout(new GridLayout(4, 1));
		Panel[] second = new Panel[4];
		
		for(int i = 0; i<4;i++) {
			second[i] = new Panel();
			second[i].setBackground(Color.white);
		}

		

		JLabel timer = new JLabel("Timer");
		timer.setFont(new Font("Malgun Gothic", Font.BOLD, 35));
		time = new JLabel("");
		time.setFont(new Font("Malgun Gothic", Font.BOLD, 35));
		start();

		

		inner_p[0].add(second[0]);
		inner_p[0].add(second[1]);
		inner_p[0].add(second[2]);
		inner_p[0].add(second[3]);
		
		

		second[1].add(timer);
		second[2].add(time);

		// 상단 중앙 : 주문
//		getOrder();

		// 상단 오른쪽 : 점수
		inner_p[2].setLayout(new GridLayout(4, 1));
		Panel[] score = new Panel[4];
		for(int i = 0; i<4;i++) {
			score[i] = new Panel();
			score[i].setBackground(Color.white);
		}
		
		JLabel profit = new JLabel("매출액");
		profit.setFont(new Font("Malgun Gothic", Font.BOLD, 35));

		money = new JLabel("0원");/* new Profit() */
		money.setFont(new Font("Malgun Gothic", Font.BOLD, 35));

		JLabel loss = new JLabel("손실액");
		loss.setFont(new Font("Malgun Gothic", Font.BOLD, 35));
		loss.setForeground(Color.red);

		losscnt = new JLabel("0원");
		losscnt.setFont(new Font("Malgun Gothic", Font.BOLD, 35));
		losscnt.setForeground(Color.red);

		inner_p[2].add(score[0]);
		inner_p[2].add(score[1]);
		inner_p[2].add(score[2]);
		inner_p[2].add(score[3]);
		
		
		score[1].add(profit);
		score[1].add(money);
		score[2].add(loss);
		score[2].add(losscnt);
		
		mn = new Profit(money);
		ls = new Loss(losscnt);

		// 하단 : 조리대
		for (int i = 0; i < inner_p2.length; i++) {
			inner_p2[i] = new Panel();
			p[1].add(inner_p2[i]);
		}

		// 하단 왼쪽 : 초밥
		inner_p2[0].setLayout(new GridLayout(2, 2, 10, 10));
		Panel[] sushi_p = new Panel[4];
		for (int i = 0; i < sushi_p.length; i++) {
			sushi_p[i] = new Panel();
			sushi_p[i].setLayout(null);
			switch (i) {
			case 0:
				menu_name = new Egg().getName();
				btn_img = icon[4];
				break;
			case 1:
				menu_name = new Tuna().getName();
				btn_img = icon[5];
				break;
			case 2:
				menu_name = new Shrimp().getName();
				btn_img = icon[6];
				break;
			case 3:
				menu_name = new Salmon().getName();
				btn_img = icon[7];
				break;
			}

			Image imgbtn = btn_img.getImage();
			imgbtn = imgbtn.getScaledInstance(160, 180, java.awt.Image.SCALE_SMOOTH);
			btn_img = new ImageIcon(imgbtn);
			menu_name = String.format("%6s",menu_name);
			sushi_btn[i] = new JButton(menu_name, btn_img);
			sushi_btn[i].setBounds(0, -10, 180, 200);
			sushi_btn[i].setBorderPainted(false);
			sushi_btn[i].setContentAreaFilled(false);
			sushi_btn[i].setFocusPainted(false);

			sushi_p[i].add(sushi_btn[i]);
			sushi_btn[i].addActionListener(this);
			inner_p2[0].add(sushi_p[i]);
		}
		s = new Profit(money);

		// 하단 오른쪽 : 음료
		inner_p2[2].setLayout(new GridLayout(2, 2, 10, 10));
		Panel[] drink_p = new Panel[4];
		for (int i = 0; i < drink_p.length; i++) {
			drink_p[i] = new Panel();
			drink_p[i].setLayout(null);
			switch (i) {
			case 0:
				menu_name = new Cider().getName();
				btn_img = icon[0];
				break;
			case 1:
				menu_name = new Coke().getName();
				btn_img = icon[1];
				break;
			case 2:
				menu_name = new Juice().getName();
				btn_img = icon[2];
				break;
			case 3:
				menu_name = new Beer().getName();
				btn_img = icon[3];
				break;
			}

			Image imgbtn = btn_img.getImage();
			imgbtn = imgbtn.getScaledInstance(140, 140, java.awt.Image.SCALE_SMOOTH);
			btn_img = new ImageIcon(imgbtn);
			menu_name = String.format("%6s",menu_name);
			drink_btn[i] = new JButton(menu_name, btn_img);
			drink_btn[i].setBounds(-3, -20, 190, 190);
			drink_btn[i].setBorderPainted(false);
			drink_btn[i].setContentAreaFilled(false);
			drink_btn[i].setFocusPainted(false);

			drink_p[i].add(drink_btn[i]);
			drink_btn[i].addActionListener(this);
			inner_p2[2].add(drink_p[i]);
		}

		f.setSize(1000, 650);
		f.setLocationRelativeTo(null);
		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});

	}
	
	
	@Override
	public void run() {
		Timer t = new Timer(time);
		t.start();
		
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Ranking(getUserName(),money.getText(),losscnt.getText()).RankingEx();
		
		
		f.setVisible(false);
		
	}

	public void getOrder() {
		String order;

		inner_p[1].removeAll();
		
		if (orderList == null) {
			o = new InsertOrder();
			order = o.execute();
		} else {
			o = new SelectOrder();
			order = o.execute();
			if (order == null) {
				orderList.setText(null);
				o = new InsertOrder();
				order = o.execute();
			}
		}
		orderList = new JLabel(String.format("%6s", order));

		inner_p[1].add(orderList);
		orderList.setFont(new Font("Malgun Gothic", Font.BOLD, 40));
		orderList.setBounds(50, 30, 250, 250);
		boolmenu1 = orderList.getText().substring(0, orderList.getText().length() - 3);
		System.out.println(boolmenu1);

		p[0].revalidate();
		p[0].repaint();

	}

	public Component setBackGround(int i) {
		return new JPanel() {
			protected void paintComponent(Graphics g) {
				ImageIcon img = new ImageIcon(imgsrc[i]);
				Image image = img.getImage();
				g.drawImage(image, 50, 10, 230, 230, null);

			}
		};
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		String str = e.getActionCommand();

		if (str.equals("완성")) {
			
			if (boolmenu1.equals(boolmenu2)) {
				getOrder();
				mn.calculate(boolmenu2);
				
			} else {
				ls.calculate(boolmenu2);
			}
			complete_btn.removeActionListener(this);
			for (int i = 0; i < sushi_btn.length; i++) {
				sushi_btn[i].addActionListener(this);
			}
			for (int i = 0; i < sushi_btn.length; i++) {
				drink_btn[i].addActionListener(this);
			}
			inner_p2[1].removeAll();

		} else {
			inner_p2[1].setLayout(new BorderLayout());

			boolmenu2 = str;

			for (int i = 0; i < cook_p.length; i++) {
				cook_p[i] = new Panel();
			}
			cook_p[0].setLayout(new CardLayout());
			
			//완성버튼 
			complete_btn = new JButton("완성");
			complete_btn.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
			complete_btn.setForeground(new Color(000, 051, 051));
			complete_btn.setBorderPainted(false);
			complete_btn.setFocusPainted(false);

			if (str.equals(String.format("%6s","egg"))) {
				cook_p[0].add(setBackGround(4));
			} else if (str.equals(String.format("%6s","tuna"))) {
				cook_p[0].add(setBackGround(5));
			} else if (str.equals(String.format("%6s","shrimp"))) {
				cook_p[0].add(setBackGround(6));
			} else if (str.equals(String.format("%6s","salmon"))) {
				cook_p[0].add(setBackGround(7));
			}

			if (str.equals(String.format("%6s","cider"))) {
				cook_p[0].add(setBackGround(0));
			} else if (str.equals(String.format("%6s","coke"))) {
				cook_p[0].add(setBackGround(1));
			} else if (str.equals(String.format("%6s","juice"))) {
				cook_p[0].add(setBackGround(2));
			} else if (str.equals(String.format("%6s","beer"))) {
				cook_p[0].add(setBackGround(3));
			}

			// 완성 버튼 출력
			cook_p[1].add(complete_btn);
			inner_p2[1].add(cook_p[0]);
			inner_p2[1].add(cook_p[1], BorderLayout.SOUTH);
			complete_btn.addActionListener(this);

			for (int i = 0; i < sushi_btn.length; i++) {
				sushi_btn[i].removeActionListener(this);
			}
			for (int i = 0; i < sushi_btn.length; i++) {
				drink_btn[i].removeActionListener(this);
			}
		}

		// Reload 코드
		f.invalidate();
		f.validate();
		f.repaint();

	}
}
