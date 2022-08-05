package kr.co.tj;

public class Box<T> {
	private T fruit;
	
	public void boxing (T fruit) {
		this.fruit = fruit;
	}
	
	public T unboxing() {
		return fruit;
	}
}
