package kr.co.mlec;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartGame extends Frame {

	JPanel[] p = new JPanel[3];
	JTextField txt1;
	JButton b1;
	JPanel p0,p1;

	public StartGame() {

		super("스시게임");

		p0 = new JPanel() {

			protected void paintComponent(Graphics g) {

				ImageIcon img = new ImageIcon("src/image/SGBackground.jpg");
				Image image = img.getImage();
				g.drawImage(image, 0, 0, 1000, 650, null);
				
			}
		};


		// 패널 생성
		for (int i = 0; i < p.length; i++) {
			p[i] = new JPanel();
		}
		// 레이아웃
		p0.setLayout(null);
		p1 =new JPanel();
		p1.setLayout(new GridLayout(3,1));
		
		// 레이블 생성
		JLabel lbl1 = new JLabel("아이디 : ");
		lbl1.setFont(new Font("Malgun Gothic", Font.BOLD, 40));
		lbl1.setForeground(new Color(000, 030, 030));

		// 아이디 텍스트필드 생성
		txt1 = new JTextField(10);
		txt1.setFont(new Font("Malgun Gothic", Font.BOLD, 30));

		p[1].add(lbl1);
		p[1].add(txt1);

		// 버튼 생성
		ImageIcon image = new ImageIcon("src/image/start.png");
		Image img = image.getImage();
		img = img.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH);
		image = new ImageIcon(img);
		b1 = new JButton(image);

		// 마우스 핸들러 생성
		MouseHandle mouse = new MouseHandle();
		
		b1.setBorderPainted(false);
		b1.setContentAreaFilled(false);
		b1.setFocusPainted(false);
		b1.addMouseListener(mouse);

		p[2].add(b1);

		p1.add(p[1]);
		p1.add(p[0]); // 빈공간
		p1.add(p[2]);
		for(int i = 0;i<3;i++) {
			p[i].setBackground(new Color(255, 0, 0, 0));
		}

		p0.add(p1);
		p0.setBackground(new Color(255, 0, 0, 0));

		add(p0);
		p1.setBounds(250, 150, 500, 300);
		p1.setBackground(new Color(255, 0, 0, 0));
		
		// 1000 * 650크기로 화면 생성
		setSize(1000, 650);
		setLocationRelativeTo(null);
		setVisible(true);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

		});
	}

	// inner Class
	public class MouseHandle extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			// Reload 코드
			b1.invalidate();
			b1.validate();
			b1.repaint();
			for(int i=0;i<3;i++) {
				p[i].invalidate();
				p[i].validate();
				p[i].repaint();
			}
			p0.invalidate();
			p0.validate();
			p0.repaint();
			p1.invalidate();
			p1.validate();
			p1.repaint();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			this.mouseEntered(e);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			this.mouseEntered(e);
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			this.mouseEntered(e);
		}
		public void mouseClicked(MouseEvent e) {
			this.mouseEntered(e);
			
			if (txt1.getText().length() <= 1) {
				JOptionPane.showMessageDialog(null, "아이디는 두글자 이상 입력해주세요");
			} else {
				Gameing g = new Gameing();
				g.setUserName(txt1.getText());
				g.getOrder();
				setVisible(false);
			}
		}
	}

}