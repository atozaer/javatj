package kr.co.tj3;

import java.util.HashMap;

public class Update {
	private String updateTitle;
	private String updateYN;
	private String titleContent;
	private int indexI;
	private String title;
	private String content;
	private boolean result;

	public Update() {

	}

	public void updateTitle() {
		System.out.println("수정할 게시글 제목을 입력 : ");
		updateTitle = Register.scan.next();
	}

	public void updateBeforeContent() {
		System.out.println("수정되기전내용입니다.");
		System.out.print("제목\t내용\t작성자\t날짜\t\t조회수\n");
	}

	public void updateSelect() {
		System.out.println("수정하시겠습니까? yes/no");
		updateYN = Register.scan.next();
	}
	public void updateTitleContent() {
		System.out.println("수정할 제목|내용을 입력 : ");
		titleContent = Register.scan.next();
	}

	public void updateProcess() {
		HashMap<String, String> boardHash = null;
		for (int i = 0; i < Register.boardList.size(); i++) {
			boardHash = new HashMap<String, String>();
			boardHash = Register.boardList.get(i);
			if (boardHash.get("title").equals(updateTitle)) {
				System.out.print(boardHash.get("title") + "\t");
				System.out.print(boardHash.get("content") + "\t");
				System.out.print(boardHash.get("author") + "\t");
				System.out.print(boardHash.get("nal") + "\t\t");
				System.out.print(boardHash.get("readCount") + "\n");
				updateSelect();
				if (updateYN.equals("yes") || updateYN.equals("YES")) {
					updateTitleContent();
					indexI = titleContent.indexOf("|");
					title = titleContent.substring(0, indexI);
					content = titleContent.substring(indexI + 1);
					boardHash.put("title", title);
					boardHash.put("content", content);
					Register.boardList.set(i, boardHash);

					result = true;
				}
			}
		}
	}

	public void updateDisplay() {
		if (result == true) {
			System.out.println("게시물이수정되었습니다.");
		} else {
			System.out.println("수정할게시물이없습니다.");
		}
	}

}
