package model.vo;

public class MemberVO {
	private String mid; //PK
	private String mpw; //비밀번호
	private String mname; //이름
	private String mbirth; //생년월일
	private String mphone; //핸드폰
	private String mgender; //성별
	private String mmail; //이메일
	private String mregdate; //가입일
	private String mlastaccessdate; //최근접속일
	private String mphoto; //이미지 경로
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMbirth() {
		return mbirth;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMgender() {
		return mgender;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public String getMmail() {
		return mmail;
	}
	public void setMmail(String mmail) {
		this.mmail = mmail;
	}
	public String getMregdate() {
		return mregdate;
	}
	public void setMregdate(String mredate) {
		this.mregdate = mredate;
	}
	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mbirth=" + mbirth + ", mphone="
				+ mphone + ", mgender=" + mgender + ", mmail=" + mmail + ", mregdate=" + mregdate + ", mlastaccessdate="
				+ mlastaccessdate + ", mphoto=" + mphoto + "]";
	}
	public String getMlastaccessdate() {
		return mlastaccessdate;
	}
	public void setMlastaccessdate(String mlastaccessdate) {
		this.mlastaccessdate = mlastaccessdate;
	}
	public String getMphoto() {
		return mphoto;
	}
	public void setMphoto(String mphoto) {
		this.mphoto = mphoto;
	}
}
