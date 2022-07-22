package kr.co.tj;

abstract class Shape {
	protected int x, y;
	
	public void move(int x, int y) {
		System.out.println("Shape Draw");
	}
	
	public abstract void draw();
}

class Rectangle extends Shape {
	protected int width, height;
	
	@Override
	public void draw() {
		System.out.println("사각형그리기");
	}

}

class Trangle extends Shape {

	@Override
	public void draw() {
		System.out.println("삼각형그리기");
	}

}

class Circle extends Shape {
	protected int radius;
	@Override
	public void draw() {
		System.out.println("원그리기");
	}

}

public class ShapeTest {

	public static void main(String[] args) {
		Rectangle rShape = new Rectangle();
		rShape.draw();
		
	}

}
