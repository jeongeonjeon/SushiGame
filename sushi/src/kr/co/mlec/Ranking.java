package kr.co.mlec;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

public class Ranking extends JFrame {
	
	private String user;
	private int  profit;
	private int loss;

	public Ranking(String user, String profit, String loss) {
		
		this.user = user;
		this.profit = Integer.parseInt(profit.substring(0, profit.length()-1));
		this.loss = Integer.parseInt(loss.substring(0, loss.length()-1));
		
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
	
	public void RankingEx() {
		
 		int score = profit-loss;
		System.out.println(user+", "+ profit+", "+loss+", "+score);
		
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		PreparedStatement pstmt2 = null; 
		PreparedStatement pstmt3 = null;
		
//		JPanel pan = new JPanel();
		int count, i = 1;
		
		try {
			conn = new ConnectionFactory().getConnection();
				   
			StringBuilder sql = new StringBuilder();
			sql.append("insert into t_user ");
			sql.append("values (temp_seq.nextval,?,?,?,?)");
				
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, user);
			pstmt.setInt(2, profit);
			pstmt.setInt(3, loss);
			pstmt.setInt(4, score);
			
			pstmt.executeUpdate();

			StringBuilder sql2 = new StringBuilder();
			sql2.append("select count(*) as c from t_user");
		
			pstmt2 = conn.prepareStatement(sql2.toString());
		
			ResultSet rs = pstmt2.executeQuery();
			rs.next();
			count = rs.getInt("c");
			System.out.println(count);
			
			StringBuilder sql3 = new StringBuilder();
			sql3.append("select ROWNUM as Ranking, e.*");
			sql3.append("from (");
			sql3.append("	select *");
			sql3.append("	from t_user");
			sql3.append("    order by score desc");
			sql3.append(") e");
			
			pstmt3 = conn.prepareStatement(sql3.toString());
			
			ResultSet rs2 = pstmt3.executeQuery();
			
			String header[] = {"랭킹","아이디","매출액","손실액","최종 스코어"};
			String[][] contents = new String[count][5];
			for(int j=0;j<count;j++) {
				rs2.next();
				for(int k = 0;k<5;k++) {
					switch(k) {
					case 0: 
						contents[j][k] = toString().valueOf(rs2.getInt("Ranking"));
						break;
					case 1: 
						contents[j][k] = rs2.getString("name");
						break;
					case 2: 
						contents[j][k] = toString().valueOf(rs2.getInt("profit"));
						break;
					case 3: 
						contents[j][k] = toString().valueOf(rs2.getInt("loss"));
						break;
					case 4: 
						contents[j][k] = toString().valueOf(rs2.getInt("score"));
						break;
					}
				}
			}

			JTable table = new JTable(contents,header);
			JScrollPane pane = new JScrollPane(table);

			add(pane);
			table.setRowHeight(30);
			table.setFont(new Font("Malgun Gothic", Font.PLAIN, 20));
//			table.setGridColor(new Color(238, 200, 17));	//border 색깔
			table.setForeground(new Color(0, 70, 140));
			DefaultTableCellRenderer tScheduleCellRenderer = new DefaultTableCellRenderer();
			tScheduleCellRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			TableColumnModel tcmSchedule = table.getColumnModel();
			
			for (int j = 0; j < tcmSchedule.getColumnCount(); j++) {
				tcmSchedule.getColumn(j).setCellRenderer(tScheduleCellRenderer);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(pstmt, conn);
		}
		// Reload 코드
		invalidate();
		validate();
		repaint();
		
		
	}
	

}














