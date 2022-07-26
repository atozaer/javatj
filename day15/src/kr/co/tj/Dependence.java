package kr.co.tj;

class DependenceBean{
	
	public void call(String name) {
		System.out.println("의존이"+name);
	}
}

public class Dependence {

	public static void main(String[] args) {
		DependenceBean bean = new DependenceBean();
		bean.call("너무강하다");
	}

}
