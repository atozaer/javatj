package kr.co.tj3.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class BoardExcuter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String titleContent = null, title = null, content = null, author = null;
		int readcount = 0;
		String nal = null;
		Resultset rs = null;
		Connection conn = null;
		Statement stmt = null;
		
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		final String user = "tj01";
		final String passwd = "dkdlxl";
	
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, passwd);
			if (conn == null) {
				System.out.println("오라클연결안됨");
			} else {
				System.out.println("오라클연결성공");
				stmt = conn.createStatement();
				while (true) {
					System.out.println("C:등록 R:검색 U:수정 D:삭제 L:목록");
					String protocol1 = scan.next();
					String protocol = protocol1.toUpperCase();
					if (protocol.equals("C")) {// 등록
						

					} // 등록끝
					else if (protocol.equals("R")) {// 검색

					} // 검색끝
					else if (protocol.equals("U")) {// 수정

					} // 수정끝
					else if (protocol.equals("D")) {// 삭제

					} // 삭제끝
					else if (protocol.equals("L")) {// 목록

					} // 목록끝
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String LocalDateTime() {
		// TODO Auto-generated method stub
		return null;
	}

}
