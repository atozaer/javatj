package kr.co.tj.member;

import java.sql.*;
import java.util.*;

public class MemberExecuter {
	public static String session = null;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		final String user = "tj01";
		final String passwd = "dkdlxl";

		String id = null, idlogin = null, pw = null, addr = null, tel = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String sqlMemberInsert = null;
		String sqlMemberIdSelect = null;

		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, passwd);
			if (conn == null) {
				System.out.println("연결실패");
			} else {
				System.out.println("연결성공");
				stmt = conn.createStatement();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		while (true) {
			System.out.println("R:회원가입 L:회원목록 S:ID찾기 D:회원탈퇴 E:회원수정 I:로그인 O:로그아웃");
			String protocol1 = scan.next();
			String protocol = protocol1.toUpperCase();
			if (protocol.equals("R")) {// 회원가입
				System.out.println("아이디입력:");
				id = scan.next();
				sqlMemberIdSelect = "select id from member where id=?";
				try {
					pstmt = conn.prepareStatement(sqlMemberIdSelect);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						idlogin = rs.getString("id");
					}
					if (idlogin.equals(id)) {
						System.out.println("아이디가중복되었습니다.");
						continue;
					} else {
						System.out.println("패스워드입력:");
						pw = scan.next();
						System.out.println("주소입력:");
						addr = scan.next();
						System.out.println("전화번호입력:");
						tel = scan.next();
						sqlMemberInsert = "insert into member(id,passwd,addr,tel) values(?,?,?,?)";
						pstmt = conn.prepareStatement(sqlMemberInsert);
						pstmt.setString(1, id);
						pstmt.setString(2, passwd);

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} // 회원가입끝
			else if (protocol.equals("L")) {// 회원목록

			} // 회원목록 끝
			else if (protocol.equals("S")) {// ID찾기

			} // ID찾기끝
			else if (protocol.equals("D")) {

			} else if (protocol.equals("E")) {

			} else if (protocol.equals("I")) {

			} else if (protocol.equals("O")) {

			}

		}
	}

}
