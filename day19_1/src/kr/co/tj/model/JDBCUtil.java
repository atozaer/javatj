package kr.co.tj.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
	static final String driverName = "oracle.jdbc.driver.OracleDriver";
	static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	static final String user = "tj01";
	static final String passwd = "dkdlxl";
	
	public static Connection connect() {
		Connection conn = null;
			try {
				Class.forName(driverName);
				conn = DriverManager.getConnection(url, user, passwd);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
	}
	public static void disconnect(PreparedStatement pstmt,Connection conn) {
		try {
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
