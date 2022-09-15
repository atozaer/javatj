package model.vo;

public class AskcommentVO {

	private int acnum; // PK
	private int anum; // FK
	private String mid; // FK
	private String acdate;
	private String accontent;
	
	public int getAcnum() {
		return acnum;
	}
	public void setAcnum(int acnum) {
		this.acnum = acnum;
	}
	public int getAnum() {
		return anum;
	}
	public void setAnum(int anum) {
		this.anum = anum;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getAcdate() {
		return acdate;
	}
	public void setAcdate(String acdate) {
		this.acdate = acdate;
	}
	public String getAccontent() {
		return accontent;
	}
	public void setAccontent(String accontent) {
		this.accontent = accontent;
	}
	
	@Override
	public String toString() {
		return "AsckcommentVO [acnum=" + acnum + ", anum=" + anum + ", mid=" + mid + ", acdate=" + acdate
				+ ", accontent=" + accontent + "]";
	}
	
}