package model.vo;

public class CommentsVO {
	private int cnum; // PK ��� �ѹ�
	private int rnum; // FK �� �ѹ�
	private String mid; // FK �α��� ���̵�
	private String cdate;
	private String ccontent;
	private float cthumbsup;
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public float getCthumbsup() {
		return cthumbsup;
	}
	public void setCthumbsup(float cthumbsup) {
		this.cthumbsup = cthumbsup;
	}
	@Override
	public String toString() {
		return "CommentsVO [cnum=" + cnum + ", rnum=" + rnum + ", mid=" + mid + ", cdate=" + cdate + ", ccontent="
				+ ccontent + ", cthumbsup=" + cthumbsup + "]";
	}
}