package kr.co.tj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int no = 0;
		String addr = null;
		Statement stmt = null;
		String sql = null;
		ResultSet rs = null;
		Connection conn =null;
		final String driverName = "com.mysql.cj.jdbc.Driver";
		final String url = "jdbc:mysql://127.0.0.1:3306/tj?characterEncoding=utf8";
		final String user = "root";
		final String passwd = "1234";
		try {
			Class.forName(driverName);
			 conn = DriverManager.getConnection(url, user, passwd);
			if (conn == null) {
				System.out.println("mysql연결안됨");
			} else {
				System.out.println("mysql연결성공");
				stmt = conn.createStatement();
				sql = "select no,addr from jo"; // 번호검색해서 데이터찾기
				stmt.executeQuery(sql); // 검색은 executeQuery사용
				rs= stmt.executeQuery(sql);
				System.out.print("번호\t주소\n");
				while(rs.next()) {
					no=rs.getInt("no");
					addr=rs.getString("addr");
					System.out.print(no+"\t"+addr+"\n");
				}
				System.out.println("로그데이터작성완료");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
