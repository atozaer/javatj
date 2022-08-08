package view;

import java.util.List;

import controller.MainController;
import vo.BoardVO;

public class BoardView extends View {
	BoardVO board;

	public BoardView() {
		super("번호\t제목\t내용\t작성자\t조회수\t작성일", "%d\t%s\t%s\t%s\t%d\t%s");
	}
	
	@Override
	public void menuSelector() {
		System.out.println("(c)등록, (r)검색, (l)목록, (u)수정, (d)삭제, (e)게시판 메뉴 종료");
		menuCode = MainController.sc.next().toLowerCase(); // 메뉴 코드값 입력(소문자 전환)
	}
	
	@Override
	public void menuReSelector() {
		System.out.printf("메뉴 코드를 확인해 주세요(현재 입력 코드 : %s)\n", menuCode);
	}
	
	public BoardVO write() {
		board = new BoardVO();		// VO객체 셋팅
		
		// 셋팅된 VO객체 멤버변수 값 셋팅 처리
		System.out.print("작성자명 입력 : ");
		String writer = MainController.sc.next();
		
		System.out.print("제목 입력 : ");
		String title = MainController.sc.next();
		
		System.out.print("내용 입력 : ");
		String content = MainController.sc.next();
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		
		return board;
	}
	
	public int search() {
		int searchNo = getSearchIntMessage("게시판 일련 번호");
		return searchNo;
	}
	
	public void searchResult(BoardVO board) {
		showListHeader();// 리스트 헤더 출력
		// 검색 데이터 노출
		System.out.printf(listString + "\n", 
			board.getBoardNo(),
			board.getTitle(),
			board.getContent(),
			board.getWriter(),
			board.getReadCount(),
			sdf.format(board.getRegDate())
		);
		
		showListFooter();
	}
	
	public void list(List<BoardVO> boardList) {
		showListHeader();// 리스트 헤더 출력
		// 조회 데이터 노출
		for(BoardVO boardVO: boardList) {
			System.out.printf(listString + "\n", 
				boardVO.getBoardNo(),
				boardVO.getTitle(),
				boardVO.getContent(),
				boardVO.getWriter(),
				boardVO.getReadCount(),
				sdf.format(boardVO.getRegDate())
			);
		}
		showListFooter();
	}
	
	public BoardVO modify(BoardVO board) {
		// 셋팅된 VO객체 멤버변수 값 셋팅 처리
		System.out.print("작성자명 입력 : ");
		String writer = MainController.sc.next();
		
		System.out.print("제목 입력 : ");
		String title = MainController.sc.next();
		
		System.out.print("내용 입력 : ");
		String content = MainController.sc.next();
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		
		return board;
	}
	
	public void modifyResult(int result) {
		if (result > 0) {
			System.out.println("정상 수정 되었습니다.");
		}
		else {
			System.out.printf("%d 일련번호 게시글이 수정 되지 않았습니다.\n", result);
		}
	}
	
	public void deleteResult(int result) {
		if (result > 0) {
			System.out.println("정상 삭제 되었습니다.");
		}
		else {
			System.out.printf("%d 일련번호 게시글이 삭제 되지 않았습니다.\n", result);
		}
	}
}
