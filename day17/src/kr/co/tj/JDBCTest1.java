package kr.co.tj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCTest1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("번호입력");
		int no = scan.nextInt();
		System.out.println("주소입력");
		String addr = scan.next();
		
		Statement stmt = null;
		String sql = null;
		Connection conn = null;
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
				sql = "insert into jo(no,addr) values(" + no + ",'" + addr + "')"; // 번호 주소 입력
				stmt.executeUpdate(sql);
				System.out.println("로그데이터작성완료");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 1.로드(적재)가져온다. 자바에게 데이터베이스(오라클)를 인식시킨다.
		// 2.연결(Connection)
		// 3.준비
		// 3-1.문장준비(쿼리준비)
		// 3-2.공간준빈(메모리공간을확보한다.)
		// 4.실행(excute) 등록,삭제,수정 excuteUpdate(); Create(등록) seaRch(등록,목록) Update(수정)
		// Delete(삭제)
		// 4.실행(excute) 검색,목록 excuteQuery();
		// 5.자원반납,종료(finally)
	}

}
