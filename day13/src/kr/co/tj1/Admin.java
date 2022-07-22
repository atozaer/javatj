package kr.co.tj1;

public class Admin {
	public int pw;

	public Admin(int pw) {
		this.pw = pw;
	}

	public int getPw() {
		return pw;
	}

	public void setPw(int pw) {
		this.pw = pw;
	}

	public boolean checkPW(int pw) {
		if (this.pw == pw) {
			return true;
		} else {
			return false;
		}
	}

	public void plusCnt(Drink drink, int cnt) {

	}

}
