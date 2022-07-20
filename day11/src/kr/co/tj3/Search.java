package kr.co.tj3;

import java.util.HashMap;

public class Search {
	private String searchTitle;
	private boolean result;

	public Search() {

	}

	public void searchTitle() {
		System.out.println("찾는 게시물 제목을 입력 : ");
		searchTitle = Register.scan.next();
	}

	public void searchDisplay() {
		System.out.print("제목\t내용\n");
	}

	public void searchProcess() {
		for (int i = 0; i < Register.boardList.size(); i++) {
			HashMap<String, String> boardHash = null;
			boardHash = new HashMap<String, String>();
			boardHash = Register.boardList.get(i);
			if (boardHash.get("title").equals(searchTitle)) {
				System.out.print(boardHash.get("title") + "\t");
				System.out.print(boardHash.get("content") + "\n");
				result = true;
			}
		}
	}

	public void searchResult() {
		if (result == true) {
			System.out.println("찾는게시글이검색되었습니다.");
		} else {
			System.out.println("찾는게시글이없습니다.");
		}
	}

}
