package kr.co.tj;

class Shape {
	protected int x, y;

	public void draw() {
		System.out.println("모양그리기");
	}
}

class Rectangle extends Shape {
	private int width, height;

	public void setWidth(int w) {
		width = w;
	}

	public void setHeight(int h) {
		height = h;
	}

	public void draw() {
		System.out.println("사각형그리기");
	}
}

class Triangle extends Shape {
	private int base, height;

	public void draw() {
		System.out.println("삼각형그리기");
	}
}

class Circle extends Shape{
	private int radius;
	public void draw() {
		System.out.println("원그리기");
	}
}

public class ShapeTest {
	
	private static Shape arrayOfShapes[];
	
	public static void main(String[] args) {
		init();
		drawAll();
	}
	
	public static void init() {
		arrayOfShapes = new Shape[3];
		arrayOfShapes[0] = new Rectangle();
		arrayOfShapes[1] = new Triangle();
		arrayOfShapes[2] = new Circle();
	}
	
	public static void drawAll() {
		for(int i = 0; i<arrayOfShapes.length; i++) {
			arrayOfShapes[i].draw();
		}
	}
	
	
}
