package kr.co.mlec.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	
	
	public Connection getConnection() /*throws Exception*/{	//공용 util class로 배포할 경우 try-catch를 사용하는 것이 좋다
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
//			String url = "jdbc:oracle:thin:@192.168.0.83:1521:xe";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
