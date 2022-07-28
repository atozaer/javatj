package kr.co.tj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("번호입력");
		int no = scan.nextInt();
		System.out.println("주소입력");
		String addr = scan.next();
		
		Statement stmt = null;
		String sql = null;
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
				stmt=conn.createStatement();
				sql = "update jo set addr = '"+addr+"' where no="+no+""; // 번호에 맞는 주소 수정
				stmt.executeUpdate(sql);
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
