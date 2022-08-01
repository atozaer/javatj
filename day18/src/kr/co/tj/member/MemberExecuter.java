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
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		String id = null, idlogin = null, pwlogin = null, pw = null, addr = null, tel = null, idSearch = null,
				select = null;
		String updateId=null, updatepasswd=null, updateaddr=null, updatetel=null, passwd1=null;
		String sqlMemberInsert = null;
		String sqlMemberIdSelect = null;
		String sqlMemberList = null;
		String sqlMemberSearch = null;
		String sqlMemberDelete = null;
		String sqlMemberLogin = null;
		String sqlMemberUpdate = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, passwd);
			if (conn == null) {
				System.out.println("연결실패");
			} else {
				System.out.println("연결성공");
				// stmt = conn.createStatement();
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		while (true) {// 반복문시작
			System.out.println("R:회원가입 L:회원목록 S:ID찾기 D:회원탈퇴 E:회원수정 I:로그인 O:로그아웃");
			String protocol1 = scan.next();
			String protocol = protocol1.toUpperCase();
			if (protocol.equals("R")) {// 회원가입
				if(session!=null) {
					System.out.println("로그인중입니다.");
					continue;
				}
				System.out.println("아이디입력:");
				id = scan.next();
				sqlMemberIdSelect = "select id from member where id=?";
				try {
					pstmt = conn.prepareStatement(sqlMemberIdSelect);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						System.out.println("아이디가중복되었습니다.");
						continue;
					} else {
						System.out.println("패스워드입력:");
						pw = scan.next();
						System.out.println("주소입력:");
						addr = scan.next();
						System.out.println("전화번호입력:");
						tel = scan.next();
						sqlMemberInsert = "insert into member(id,passwd,address,tel) values(?,?,?,?)";
						pstmt = conn.prepareStatement(sqlMemberInsert);
						pstmt.setString(1, id);
						pstmt.setString(2, pw);
						pstmt.setString(3, addr);
						pstmt.setString(4, tel);
						pstmt.executeUpdate();
						System.out.println("회원등록되었습니다.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // 회원가입
			else if (protocol.equals("L")) {// 회원목록
				try {
					System.out.print("회원아이디\t회원패스워드\t회원주소\t회원전화번호\n");
					sqlMemberList = "select id,passwd,address,tel from member";
					pstmt = conn.prepareStatement(sqlMemberList);
					rs = pstmt.executeQuery();
					while (rs.next()) {
						id = rs.getString("id");
						pw = rs.getString("passwd");
						addr = rs.getString("address");
						tel = rs.getString("tel");
						System.out.print(id + "\t" + pw + "\t" + addr + "\t" + tel + "\n");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // 회원목록
			else if (protocol.equals("S")) {// ID찾기
				try {
					System.out.println("찾는 ID입력:");
					id = scan.next();
					sqlMemberSearch = "select id from member where id=?";
					pstmt = conn.prepareStatement(sqlMemberSearch);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						idSearch = rs.getString("id");
						System.out.println("찾는아이디는" + idSearch);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // ID찾기
			else if (protocol.equals("D")) {// 회원탈퇴
				try {
					System.out.println("탈퇴할아이디입력:");
					id = scan.next();
					System.out.println("탈퇴할패스워드입력:");
					pw = scan.next();
					sqlMemberDelete = "delete from member where id=? and passwd=?";
					pstmt = conn.prepareStatement(sqlMemberDelete);
					pstmt.setString(1, id);
					pstmt.setString(2, pw);
					System.out.println("정말로회원탈퇴하실래요y/n");
					select = scan.next();
					if (select.equals("y")) {
						pstmt.executeUpdate();
						System.out.println("회원탈퇴하셨습니다.");
					} else {
						continue;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} // 회원탈퇴
			else if (protocol.equals("E")) {// 회원수정
				System.out.println("수정할아이디입력:");
				updateId=scan.next();
				System.out.println("수정할패스워드입력:");
				updatepasswd=scan.next();
				System.out.println("수정할주소입력:");
				updateaddr=scan.next();
				System.out.println("수정할전화번호입력");
				updatetel=scan.next();
				System.out.println("찾는아이디:");
				id = scan.next();
				System.out.println("찾는패스워드:");
				passwd1=scan.next();
				
				sqlMemberUpdate = "update member set id=?,passwd=?,address=?,tel=? where=id=? and passwd=?";
				try {
					pstmt = conn.prepareStatement(sqlMemberUpdate);
					pstmt.setString(1, updateId);
					pstmt.setString(2, updatepasswd);
					pstmt.setString(3, updateaddr);
					pstmt.setString(4, updatetel);
					pstmt.setString(5, id);
					pstmt.setString(6, passwd1);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("멤버가수정되었습니다.");
				
			} // 회원수정
			else if (protocol.equals("I")) {// 로그인
				try {
					System.out.println("아이디입력:");
					idlogin = scan.next();
					System.out.println("패스워드입력:");
					pwlogin = scan.next();
					sqlMemberLogin = "select id from member where id=? and passwd=?";
					pstmt = conn.prepareStatement(sqlMemberLogin);
					pstmt.setString(1, idlogin);
					pstmt.setString(2, pwlogin);
					rs = pstmt.executeQuery();
					if (rs.next()) {
						id = rs.getString("id");
						session = id;
						System.out.println("로그인되었습니다.");
					} else {
						System.out.println("로그인에 실패했습니다.");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // 로그인
			else if (protocol.equals("O")) {// 로그아웃
				session=null;
				System.out.println("로그아웃되었습니다.");

			} // 로그아웃
		} // 반복문끝
	}

}
