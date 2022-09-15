package model.vo;

public class NewsboardVO {
	@Override
	public String toString() {
		return "NewsboardVO [nnum=" + nnum + ", ntitle=" + ntitle + ", ncontent=" + ncontent + ", ndate=" + ndate
				+ ", nphoto=" + nphoto + "]";
	}
	private int nnum; //PK
	private String ntitle; //글 제목
	private String ncontent; //글 내용
	private String ndate; //글 작성일
	private String nphoto; //이미지 경로
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
