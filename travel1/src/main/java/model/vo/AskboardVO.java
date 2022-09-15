package model.vo;

public class AskboardVO {
	private int anum; // PK
	private String mid; // FK
	private String atitle;
	private String acontent;
	private String adate;
	private String afile;
	private int aview;
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
	public String getAtitle() {
		return atitle;
	}
	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}
	public String getAcontent() {
		return acontent;
	}
	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	public String getAfile() {
		return afile;
	}
	public void setAfile(String afile) {
		this.afile = afile;
	}
	public int getAview() {
		return aview;
	}
	public void setAview(int aview) {
		this.aview = aview;
	}
	@Override
	public String toString() {
		return "AskboardVO [anum=" + anum + ", mid=" + mid + ", atitle=" + atitle + ", acontent=" + acontent
				+ ", adate=" + adate + ", afile=" + afile + ", aview=" + aview + "]";
	}
}