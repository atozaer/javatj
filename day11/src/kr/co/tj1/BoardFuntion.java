package kr.co.tj1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BoardFuntion {

	public static void register(String titleContent, Scanner scan, int indexI, String title, String content, String author,String nal, String readCount, ArrayList<HashMap<String,String>> boardList) {
		HashMap<String, String> boardHash = new HashMap<String, String>();
		System.out.println("제목|내용 입력하세요:");
		titleContent = scan.next();
		indexI = titleContent.indexOf("|");
		title = titleContent.substring(0, indexI);
		content = titleContent.substring(indexI + 1);
		// System.out.println("제목:"+title);
		// System.out.println("내용:"+content);
		System.out.println("작성자입력:");
		author = scan.next();
		System.out.println("날짜입력:");
		nal = scan.next();
		System.out.println("조회수입력:");
		readCount = scan.next();
		boardHash.put("title", title);
		boardHash.put("content", content);
		boardHash.put("author", author);
		boardHash.put("nal", nal);
		boardHash.put("readCount", readCount);
		boardList.add(boardHash);
		System.out.println("게시글이 등록되었습니다.");
	}
	public static void search(String searchTitle, Scanner scan, ArrayList<HashMap<String,String>> boardList) {
		boolean result = false;

		HashMap<String, String> boardHash = null;
		System.out.println("찾는 게시물 제목을 입력 : ");
		searchTitle = scan.next();

		for (int i = 0; i < boardList.size(); i++) {
			boardHash = new HashMap<String, String>();
			boardHash = boardList.get(i);
			if (boardHash.get("title").equals(searchTitle)) {
				System.out.print("제목\t내용\n");
				System.out.print(boardHash.get("title") + "\t");
				System.out.print(boardHash.get("content") + "\n");
				result = true;
			}
		}
		if (result == true) {
			System.out.println("찾는게시글이검색되었습니다.");
		} else {
			System.out.println("찾는게시글이없습니다.");
		}
	}
	public static void delete(String deleteTitle, Scanner scan, ArrayList<HashMap<String,String>> boardList) {
		boolean result = false;
		HashMap<String, String> boardHash = null;
		System.out.println("삭제할 게시물 제목을 입력 : ");

		deleteTitle = scan.next();

		for (int i = 0; i < boardList.size(); i++) {
			boardHash = new HashMap<String, String>();
			boardHash = boardList.get(i);
			if (boardHash.get("title").equals(deleteTitle)) {
				boardList.remove(i);
				result = true;
			}
		}
		if (result == true) {
			System.out.println("게시물이삭제되었습니다.");
		} else {
			System.out.println("삭제할게시물이없습니다.");
		}
	}
	public static void update(String updateTitle, Scanner scan, ArrayList<HashMap<String,String>> boardList, String updateYN, String titleContent, int indexI, String title, String content) {
		boolean result = false;
		HashMap<String, String> boardHash = null;
		System.out.println("수정할 게시글 제목을 입력 : ");
		updateTitle = scan.next();

		for (int i = 0; i < boardList.size(); i++) {
			boardHash = new HashMap<String, String>();
			boardHash = boardList.get(i);
			if (boardHash.get("title").equals(updateTitle)) {
				System.out.println("수정되기전내용입니다.");
				System.out.print("제목\t내용\t작성자\t날짜\t\t조회수\n");
				System.out.print(boardHash.get("title") + "\t");
				System.out.print(boardHash.get("content") + "\t");
				System.out.print(boardHash.get("author") + "\t");
				System.out.print(boardHash.get("nal") + "\t\t");
				System.out.print(boardHash.get("readCount") + "\n");
				System.out.println("수정하시겠습니까? yes/no");
				updateYN = scan.next();
				if (updateYN.equals("yes") || updateYN.equals("YES")) {
					System.out.println("수정할 제목|내용을 입력 : ");
					titleContent = scan.next();
					indexI = titleContent.indexOf("|");
					title = titleContent.substring(0, indexI);
					content = titleContent.substring(indexI + 1);
					boardHash.put("title", title);
					boardHash.put("content", content);
					boardList.set(i, boardHash);

					result = true;
				}

				if (result == true) {
					System.out.println("게시물이수정되었습니다.");
				} else {
					System.out.println("수정할게시물이없습니다.");
				}
			}

		}

	}
	public static void list(ArrayList<HashMap<String,String>> boardList) {
		System.out.println("========================전체출력========================");
		System.out.print("제목\t내용\t작성자\t날짜\t\t조회수\n");
		HashMap<String, String> boardHash = null;
		for (int i = 0; i < boardList.size(); i++) {
			boardHash = new HashMap<String, String>();
			boardHash = boardList.get(i);
			System.out.print(boardHash.get("title") + "\t");
			System.out.print(boardHash.get("content") + "\t");
			System.out.print(boardHash.get("author") + "\t");
			System.out.print(boardHash.get("nal") + "\t\t");
			System.out.print(boardHash.get("readCount") + "\n");
		}
	}

}
