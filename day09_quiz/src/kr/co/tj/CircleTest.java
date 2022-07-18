package kr.co.tj;

class Point{
	public int x;
	public int y;
	
	public Point() {}
	public Point(int a, int b) {
		x = a;
		y = b;
	}
}

class Circle{
	public int radius = 0;
	public Point center;//Point 참조변수가 필드로 선언되어있다. (has a) 포함관계
	
	public Circle() {
		center = new Point(0,0);
	}
	public Circle(int r) {
		center = new Point(0,0);
		radius = r;
	}
	public Circle(Point p, int r) {
		center = p;
		radius = r;
	}
	public void printCircle() {
		System.out.println("x ="+center.x);
		System.out.println("y ="+center.y);
		System.out.println("radius ="+radius);
	}
	
}

public class CircleTest {

	public static void main(String[] args) {
		//Circle 객체를 생성하고 초기화한다.
		Point p = new Point(25, 78);
		Circle c = new Circle (p, 10);
		c.printCircle();
		
	}

}
