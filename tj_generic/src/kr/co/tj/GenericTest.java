package kr.co.tj;

public class GenericTest {
	public static void main(String[] args) {
		Fruit appleFruit = new Apple();
		Apple apple = new Apple();
		Banana banana = new Banana();
		Orange orange = new Orange();
		
		Box<Fruit> fruitBox = new Box<>();
		Box<Banana> bananaBox = new Box<>();
		Box<Orange> orangeBox = new Box<>();
		
		apple.setSugarContent(3.2);
		appleFruit.setSugarContent(5.5);
		banana.setSugarContent(2.3);
		orange.setSugarContent(4.7);
		
		fruitBox.boxing(apple);
		bananaBox.boxing(banana);
		
		System.out.println(fruitBox.unboxing().getSugarContent());
		System.out.println(bananaBox.unboxing().getSugarContent());
	}
}
