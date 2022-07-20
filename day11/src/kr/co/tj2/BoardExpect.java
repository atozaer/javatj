package kr.co.tj2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class BoardExpect {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<HashMap<String, String>> boardList = new ArrayList<HashMap<String, String>>();
		String titleContent = null;
		int indexI = 0;
		String title = null;
		String content = null;
		String author = null;
		String nal = null;
		String readCount = null;
		String searchTitle = null;
		String deleteTitle = null;
		String updateTitle = null;
		String updateYN = null;
		BoardFuntion boardObj = new BoardFuntion();

		while (true) {// 반복문시작
			System.out.println("=======================게시판작성=======================");
			System.out.println("R:등록");
			System.out.println("S:검색");
			System.out.println("D:삭제");
			System.out.println("U:수정");
			System.out.println("L:목록");
			System.out.println("EXIT:종료");
			System.out.println("R S D U L 중에 입력하세요...");

			String protocol = scan.next();

			if (protocol.equals("r") || protocol.equals("R")) {// R : 등록 시작
				boardObj.register(titleContent, scan, indexI, updateTitle, content, author, nal, readCount, boardList);
			} // R : 등록 끝
			else if (protocol.equals("s") || protocol.equals("S")) {// 검색 시작
				boardObj.search(searchTitle, scan, boardList);
			} // 검색 끝
			else if (protocol.equals("d") || protocol.equals("D")) {// 삭제 시작
				boardObj.delete(deleteTitle, scan, boardList);
			} // 삭제 끝
			else if (protocol.equals("u") || protocol.equals("U")) {// 수정 시작
				boardObj.update(updateTitle, scan, boardList, updateYN, titleContent, indexI, updateTitle, content);
			} // 수정 끝
			else if (protocol.equals("l") || protocol.equals("L")) {// 목록 시작
				boardObj.list(boardList);
			} // 목록 끝
			else {
				if(protocol.equals("EXIT") || protocol.equals("exit")){
					System.out.println("프로그램을 종료합니다.");
					break;
				}
			}
		} // 반복문끝

	}

}
