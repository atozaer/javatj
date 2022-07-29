package kr.co.tj.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Board {
	private int no;
	private String title;
	private String content;
	private String author;
	private Date nal;
	private int readcount;

	public Board() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setNal(Date nal) {
		this.nal = nal;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getNo() {
		return no;
	}

	public Date getNal() {
		return nal;
	}

	@Override
	public String toString() {
		return "Board [no=" + no + ", title=" + title + ", content=" + content + ", author=" + author + ", nal=" + nal
				+ ", readcount=" + readcount + "]";
	}

}

public class BoardExcuter {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String titleContent = null, title = null, content = null, author = null, updateTitle = null,
				updateContent = null;
		int readcount = 0, indexI = 0, no = 0;
		Date nal = null;
		final String driverName = "oracle.jdbc.driver.OracleDriver";
		final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		final String user = "tj01";
		final String passwd = "dkdlxl";
		Connection conn = null;
		ResultSet rs = null;
		final String sqlInsert = "insert into board(no,title,content,author,readcount) values((select nvl(max(no),0)+1 from board),'";
		final String sqlSearch = "select no,title,content,author,nal,readcount from board where title='";
		final String sqlSelect = "select no,title,content,author,nal,readcount from board";
		final String sqlDelete = "delete from board where title=";
		final String sqlUpdate1 = "update board set title='";
		final String sqlUpdate2 = "',content='";
		final String sqlUpdate3 = "'where title='";
		final String sqlReadCount1 = "update board set readcount=";
		final String sqlReadCount2 = "readcount+1";
		final String sqlReadCount3 = "where title='";
		Statement stmt = null;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		ArrayList<Board> datas = new ArrayList<Board>();
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, user, passwd);
			if (conn == null) {
				System.out.println("연결실패");
			} else {
				System.out.println("연결성공");
				stmt = conn.createStatement();
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		while (true) {// 반복문시작
			System.out.println("C:등록R:검색U:수정D:삭제L:전체출력");
			String protocol1 = scan.next();
			String protocol = protocol1.toUpperCase();
			if (protocol.equals("C")) {// 등록
				System.out.println("제목|내용 입력:");
				titleContent = scan.next();
				indexI = titleContent.indexOf("|");
				title = titleContent.substring(0, indexI);
				content = titleContent.substring(indexI + 1);
				System.out.println("작성자입력:");
				author = scan.next();
				System.out.println("조회수입력:");
				readcount = scan.nextInt();
				try {
					stmt.executeUpdate(sqlInsert + title + "','" + content + "','" + author + "'," + readcount + ")");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("게시글이등록되었습니다.");
			} // 등록
			else if (protocol.equals("R")) {// 검색
				System.out.println("제목을 입력하세요:");
				title = scan.next();
				try {
					rs = stmt.executeQuery(sqlSearch + title + "'");
					System.out.print("no\t title\t cotnent\t author\t nal\t\t\t readcount\n");
					if (rs.next()) {
						no = rs.getInt("no");
						title = rs.getString("title");
						content = rs.getString("content");
						author = rs.getString("author");
						nal = rs.getTimestamp("nal");
						readcount = rs.getInt("readcount");
					}
					// sqlReadCount = "update board set readcount=readcount+1 where
					// title='"+title+"'";
					stmt.executeUpdate(sqlReadCount1 + sqlReadCount2 + sqlReadCount3 + title + "'");
					System.out.print(no + "\t" + title + "\t" + content + "\t\t" + author + "\t" + sdf1.format(nal)
							+ "\t" + readcount + "\n");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // 검색
			else if (protocol.equals("U")) {// 수정
				System.out.println("수정할게시글제목입력:");
				title = scan.next();
				try {
					rs = stmt.executeQuery(sqlSearch + title + "'");
					if (rs.next()) {
						title = rs.getString("title");
						content = rs.getString("content");
						System.out.println(title + "\t" + content + "\n");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				System.out.println("수정하기 전내용입니다.");
				System.out.println("수정할게시글제목|내용입력:");
				titleContent = scan.next();
				indexI = titleContent.indexOf("|");
				updateTitle = titleContent.substring(0, indexI);
				updateContent = titleContent.substring(indexI + 1);
				System.out.println("정말로수정하시겠습니까y/n");
				String select = scan.next();
				if (select.equals("y") || select.equals("Y")) {
					try {
						stmt.executeUpdate(
								sqlUpdate1 + updateTitle + sqlUpdate2 + updateContent + sqlUpdate3 + title + "'");
					} catch (SQLException e) {
						e.printStackTrace();
					}
					System.out.println("게시글이수정되었습니다.");
				} else {
					System.out.println("수정취소");
				}

			} // 수정
			else if (protocol.equals("D")) {// 삭제
				System.out.println("삭제할제목입력:");
				title = scan.next();
				try {
					stmt.executeUpdate(sqlDelete + title);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("게시글이 삭제되었습니다.");
			} // 삭제
			else if (protocol.equals("L")) {// 전체출력
				System.out.println("전체출력");
				System.out.print("no\t title\t cotnent\t author\t nal\t\t\t readcount\n");
				try {
					rs = stmt.executeQuery(sqlSelect);
					while (rs.next()) {
						Board data = new Board();
						data.setNo(rs.getInt("no"));
						data.setTitle(rs.getString("title"));
						data.setContent(rs.getString("content"));
						data.setAuthor(rs.getString("author"));
						data.setNal(rs.getTimestamp("nal"));
						data.setReadcount(rs.getInt("readcount"));
						datas.add(data);
						System.out.print(data.getNo() + "\t" + data.getTitle() + "\t" + data.getContent() + "\t\t"
								+ data.getAuthor() + "\t" + sdf1.format(data.getNal()) + "\t" + data.getReadcount()
								+ "\n");
					}
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} // 전체출력
		} // 반복문끝
	}

}
