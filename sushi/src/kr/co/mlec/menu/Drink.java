package kr.co.mlec.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

public class Drink extends Menu {
		
	public Drink() {
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
				sql.append(" from t_price p , t_sub_menu s ");
				sql.append(" where p.color_id = s.color_id ");
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
