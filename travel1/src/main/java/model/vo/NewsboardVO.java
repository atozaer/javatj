package model.vo;

public class NewsboardVO {
	@Override
	public String toString() {
		return "NewsboardVO [nnum=" + nnum + ", ntitle=" + ntitle + ", ncontent=" + ncontent + ", ndate=" + ndate
				+ ", nphoto=" + nphoto + "]";
	}
	private int nnum; //PK
	private String ntitle; //�� ����
	private String ncontent; //�� ����
	private String ndate; //�� �ۼ���
	private String nphoto; //�̹��� ���
	public int getNnum() {
		return nnum;
	}
	public void setNnum(int nnum) {
		this.nnum = nnum;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	public String getNphoto() {
		return nphoto;
	}
	public void setNphoto(String nphoto) {
		this.nphoto = nphoto;
	}
}
