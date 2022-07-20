package kr.co.tj3;

import java.util.HashMap;

public class List {
	public List() {

	}

	public void listDisplay() {
		System.out.println("========================전체출력========================");
		System.out.print("제목\t내용\t작성자\t날짜\t\t조회수\n");
	}

	public void listProcess() {
		HashMap<String, String> boardHash = null;
		for (int i = 0; i < Register.boardList.size(); i++) {
			boardHash = new HashMap<String, String>();
			boardHash = Register.boardList.get(i);
			System.out.print(boardHash.get("title") + "\t");
			System.out.print(boardHash.get("content") + "\t");
			System.out.print(boardHash.get("author") + "\t");
			System.out.print(boardHash.get("nal") + "\t\t");
			System.out.print(boardHash.get("readCount") + "\n");
		}
	}

}