package model.vo;

public class ReviewboardVO {
	private int rnum; //PK
	private String rtitle; //글 제목
	private String mid; //FK
	private String rcontent; //글 내용
	private String rdate; //글 작성일
	private String rfile; //첨부파일
	private int rview; //조회수
	private int rcnt; //댓글수
	private double rthumbsup;//별점
	private String raddress; //주소
	public int getRcnt() {
		return rcnt;
	}
	public void setRcnt(int rcnt) {
		this.rcnt = rcnt;
	} 
	
	public String getRaddress() {
		return raddress;
	}
	public void setRaddress(String raddress) {
		this.raddress = raddress;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getRtitle() {
		return rtitle;
	}
	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}
	@Override
	public String toString() {
		return "ReviewboardVO [rnum=" + rnum + ", rtitle=" + rtitle + ", mid=" + mid + ", rcontent=" + rcontent
				+ ", rdate=" + rdate + ", rfile=" + rfile + ", rview=" + rview + ", rcnt=" + rcnt + ", rthumbsup="
				+ rthumbsup + ", raddress=" + raddress + "]";
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getRfile() {
		return rfile;
	}
	public void setRfile(String rfile) {
		this.rfile = rfile;
	}
	public int getRview() {
		return rview;
	}
	public void setRview(int rview) {
		this.rview = rview;
	}
	public double getRthumbsup() {
		return rthumbsup;
	}
	public void setRthumbsup(double rthumbsup) {
		this.rthumbsup = rthumbsup;
	}
}
