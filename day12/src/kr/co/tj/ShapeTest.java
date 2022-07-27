package kr.co.tj;

class Shape{
	//public Shape() {}	매개변수가 있는 생성자가 있을시 디폴트생성자를 넣으면 해결됨.
	public Shape(String msg) {
		System.out.println("Shape 생성자()"+ msg);
	}
}

class Rectangle extends Shape{
	public Rectangle() {
		super("명시적호출");	
		System.out.println("Rectangle 생성자()");
	}
}

public class ShapeTest {

	public static void main(String[] args) {
		Rectangle r = new Rectangle();
	}
	
}
