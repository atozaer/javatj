package vo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class BoardVO {
	public final static String TABLENAME = "board";
	public final static String INDEXNAME = "boardNo";
	private Long boardNo;
	private String writer;
	private String title;
	private String content;
	private int readCount;
	private Date regDate;
	/*
	 create table board (
	 	board_no int auto_increment primary key,
	 	writer varchar(20),
	 	title varchar(100),
	 	content text,
	 	read_count int not null default 0,
	 	reg_date datetime not null default now()
	 );
	 */
	
	public Long getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(Long boardNo) {
		this.boardNo = boardNo;
	}
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public BoardVO() {
		
	}
}
