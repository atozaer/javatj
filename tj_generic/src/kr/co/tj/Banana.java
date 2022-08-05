package kr.co.tj;

public class Banana extends Fruit {

	@Override
	protected void setSugarContent(double sugarContent) {
		this.sugarContent = sugarContent;
	}

	@Override
	protected double getSugarContent() {
		
		return sugarContent;
	}

}
