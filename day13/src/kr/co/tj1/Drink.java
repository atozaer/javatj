package kr.co.tj1;

public class Drink {
	public String name;
	public int cnt;
	public static int pkNum;
	public int pk;
	public int price;

	public Drink(String name, int cnt, int price) {
		this.name = name;
		this.cnt = cnt;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public static int getPkNum() {
		return pkNum;
	}

	public static void setPkNum(int pkNum) {
		Drink.pkNum = pkNum;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
