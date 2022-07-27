package kr.co.tj;

class Parent{
	int data = 100;
	public void print() {
		System.out.println("슈퍼클래스의 print()메소드");
	}
}
class Child extends Parent{
	int data = 200;
	
	public void print() {
		super.print();
		System.out.println("서브클래스의 print()메소드");
		System.out.println(data);
		System.out.println(this.data);
		System.out.println(super.data);
		System.out.println(this.data);
	}
}

public class ParentTest {

	public static void main(String[] args) {
		Child c	= new Child();
		c.print();
	
	}

}
