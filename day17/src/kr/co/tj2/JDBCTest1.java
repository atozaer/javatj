package kr.co.tj2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
	private String addr;
	private int no;

	public Student() {
		super();
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	@Override
	public String toString() {
		return "Student [addr=" + addr + ", no=" + no + "]";
	}

}

public class JDBCTest1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int no = 0;
		String addr = null;
		String protocol = null;
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;

		final String driverName = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		final String user = "tj01";
		final String passwd = "dkdlxl";
		final String sql_insert = "insert into student(no,addr) values((select nvl(max(no),0)+1 from student),'";
		final String sql_selectAll = "select no,addr from student";
		final String sql_delete = "delete from student where no =";
		final String sql_update1 = "update student set addr ='";
		final String sql_update2 = "' where no =";
		final String sql_selectOne = "select no,addr from student where no=";
		
		ArrayList<Student> datas = new ArrayList<Student>();
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, passwd);
			if (conn == null) {
				System.out.println("오라클연결안됨");
			} else {
				System.out.println("오라클연결성공");
				stmt = conn.createStatement();
				while (true) {// while문 시작
					System.out.println("C:등록 R:검색 L:목록 U:수정 D:삭제");
					protocol = scan.next();
					if (protocol.equals("C") || protocol.equals("c")) {// 등록시작
						System.out.print("주소 : ");
						addr = scan.next();
						stmt.executeUpdate(sql_insert + addr + "')");
						System.out.println("등록 성공!");
					} // 등록끝
					else if (protocol.equals("R") || protocol.equals("r")) {// 검색시작
						System.out.print("검색할번호를입력하세요 : ");
						no = scan.nextInt();
						System.out.print("번호\t주소\n");
						rs = stmt.executeQuery(sql_selectOne+no);
						if(rs.next()) {
							System.out.print(rs.getInt("no")+"\t");
							System.out.print(rs.getString("addr")+"\n");
						}
						System.out.println("검색되었습니다.");
					} // 검색끝
					else if (protocol.equals("L") || protocol.equals("l")) {// 목록시작
						rs =stmt.executeQuery(sql_selectAll);
						System.out.print("번호\t주소\n");
						while(rs.next()) {
							Student data = new Student();
							data.setNo(rs.getInt("no"));
							data.setAddr(rs.getString("addr"));
							System.out.print(data.getNo()+"\t");
							System.out.print(data.getAddr()+"\n");
							datas.add(data);
						}
						System.out.println("전체출력되었습니다.");
						rs.close();
					} // 목록끝
					else if (protocol.equals("U") || protocol.equals("u")) {// 수정시작
						System.out.println("수정할번호를입력하세요 : ");
						no = scan.nextInt();
						System.out.println("수정할주소를입력하세요 : ");
						addr = scan.next();
						stmt.executeUpdate(sql_update1+addr+sql_update2+no);
						
					} // 수정끝
					else if (protocol.equals("D") || protocol.equals("d")) {// 삭제시작
						System.out.println("삭제할번호입력하세요 : ");
						no = scan.nextInt();
						stmt.executeUpdate(sql_delete+no);
						System.out.println(no+"번이 삭제 되었습니다.");
					} // 삭제끝
				} // while문 끝
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// 메인끝

}// 클래스 끝
