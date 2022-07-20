package kr.co.tj3;

import java.util.HashMap;

public class Delete {
	private String deleteTitle;
	private boolean result;

	public Delete() {

	}

	public void deleteTitle() {
		System.out.println("삭제할 게시물 제목을 입력 : ");
		deleteTitle = Register.scan.next();
	}

	public void deleteProcess() {
		HashMap<String, String> boardHash = null;
		for (int i = 0; i < Register.boardList.size(); i++) {
			boardHash = new HashMap<String, String>();
			boardHash = Register.boardList.get(i);
			if (boardHash.get("title").equals(deleteTitle)) {
				Register.boardList.remove(i);
				result = true;
			}
		}
	}

	public void deleteResult() {
		if (result == true) {
			System.out.println("게시물이삭제되었습니다.");
		} else {
			System.out.println("삭제할게시물이없습니다.");
		}
	}

}
