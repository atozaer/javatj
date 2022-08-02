package kr.co.tj.client;

import java.util.ArrayList;
import java.util.Iterator;

public class IterTest01 {

	public static void main(String[] args) {
		System.out.println("List 생성");
		ArrayList list = new ArrayList();
		list.add("일");
		list.add("월");
		list.add("수");
		
		Iterator iter = list.iterator();
		while(iter.hasNext()==true) {
			String day = (String)iter.next();
			if(day == "수") {
				iter.remove();
			}
			System.out.println("Day:"+day);
		}
		System.out.println("----------------");
		
		iter = list.iterator();
		while(iter.hasNext()==true) {
			String day = (String)iter.next();
			System.out.println("Day:"+day);
		}
		
	}

}
