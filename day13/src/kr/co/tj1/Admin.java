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
		boolean result = false;
		if (this.pw == pw) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	public void plusCnt(Drink drink, int cnt) {
		drink.setCnt(drink.getCnt()+cnt);
	}

}
