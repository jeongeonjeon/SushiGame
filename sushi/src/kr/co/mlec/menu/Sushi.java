package kr.co.mlec.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

public class Sushi extends Menu {
	

	public Sushi() {
		super();
	}

	@Override
	public int ImportPrice(String name) {
		Connection conn = null; 
		PreparedStatement pstmt = null; 
		setName(name);
		
		try {
			conn = new ConnectionFactory().getConnection();
			
				   
			StringBuilder sql = new StringBuilder();
				sql.append("select price ");
				sql.append(" from t_price p , t_main_menu m ");
				sql.append(" where p.color_id = m.color_id ");
				sql.append(" and menu_name = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, getName());
			
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			setPrice(rs.getInt("price"));
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCClose.close(pstmt, conn);
		}

		return getPrice();
	}
	
	
}
