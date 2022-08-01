package kr.co.tj.model;

import java.util.Date;

public class BoardVO {
	private int no;
	private String title;
	private String content;
	private String author;
	private Date nal;
	private int readcount;
	
	public BoardVO() {
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
		return "BoardVO [no=" + no + ", title=" + title + ", content=" + content + ", author=" + author + ", nal=" + nal
				+ ", readcount=" + readcount + "]";
	}
}
