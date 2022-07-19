package kr.co.tj;

import java.util.ArrayList;
import java.util.HashMap;


public class ArrayListHashMapTest {

	public static void main(String[] args) {
		ArrayList<HashMap<String,String>> boardList = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> boardHash = new HashMap<String,String>();
		boardHash.put("title", "제목1");
		boardHash.put("content", "내용1");
		boardList.add(boardHash);
		System.out.println("등록되었습니다...");
		for(int i = 0; i<boardList.size(); i++) {
			HashMap<String, String> boardHash1 = boardList.get(i);
			System.out.println(boardHash1.get("title"));
			System.out.println(boardHash1.get("content"));
		}
		
	}

}
