package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	public static Long insertLastId = 0L;
	final String DBDriverName = "com.mysql.cj.jdbc.Driver";
	final String URL = "jdbc:mysql://localhost:3356/tj?characterEncoding=utf8";
	final String USER = "root";
	final String PASSWORD = "love1004";
	
	public Connection conn;
	public Statement stmt;
	
	public Database() {
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int insert(String query) throws SQLException {
		System.out.println(query);
		int retult = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()) {
			insertLastId = (long) rs.getInt(1);
		}
		return retult;
	}
	
	public int update(String query) throws SQLException {
		System.out.println(query);
		return stmt.executeUpdate(query);
	}
	
	public ResultSet select(String query) throws SQLException {
		System.out.println(query);
		return stmt.executeQuery(query);
	}
	
	public ResultSet selectAll(String query) throws SQLException {
		System.out.println(query);
		return stmt.executeQuery(query);
	}
	
	@Override
	protected void finalize() throws Throwable {
		if (stmt != null) stmt.close();
		if (conn != null) conn.close();
	} 
}
