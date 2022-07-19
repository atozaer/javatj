package kr.co.tj;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListTest01 {

	public static void main(String[] args) {
		ArrayList array1 = new ArrayList();
		array1.add("A");
		array1.add("B");
		array1.add("C");
		array1.add("D");
		array1.add("E");
		array1.remove(2);
//		System.out.println(array1.get(2));
		array1.add(2,"C");
//		System.out.println(array1.get(2));
		array1.add(2,"G");
//		System.out.println(array1.get(2));
//		System.out.println(array1.get(3));
//		System.out.println(array1.size());
//		for(int i = 0; i<array1.size(); i++) {
//			System.out.print(array1.get(i));
//		}
//		for(String str : array1) {
//			System.out.print(str);
//		}
		
	}

}
