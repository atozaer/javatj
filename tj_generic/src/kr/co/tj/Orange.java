package kr.co.tj;

public class Orange extends Fruit {

	@Override
	protected void setSugarContent(double sugarContent) {
		this.sugarContent = sugarContent;
	}

	@Override
	protected double getSugarContent() {
		return sugarContent;
	}

}
