package kr.co.tj;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayListTest02 {

	public static void main(String[] args) {
		ArrayList<String> array1 = new ArrayList<String>();
		array1.add("한국");
		array1.add("미국");
		array1.add("중국");
		
		for(int i = 0; i<array1.size(); i++) {
			System.out.print(array1.get(i));
		}
		System.out.println();
		array1.remove(0);
		for(String str : array1) {
			System.out.print(str);
		}
		System.out.println();
		array1.remove("중국");
		for(String str : array1) {
			System.out.print(str);
		}
		
	}

}
