package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import repository.BoardRepository;
import view.BoardView;
import vo.BoardVO;

public class BoardController extends Controller {
	BoardRepository boardRepository;
	BoardView boardView;
	List<BoardVO> boardList;
	
	public BoardController() {
		// super 클래스쪽 인자 전달을 통한 리스트 조회에 필요한 타이틀, 내용 출력 포멧 셋
		super("번호\t제목\t내용\t작성자\t조회수\t작성일", "%d\t%s\t%s\t%s\t%d\t%s");
		// 레포지토리(DB 통신을 위한 객체) 셋팅
		boardRepository = new BoardRepository(); 
		boardView = new BoardView();
	}

	@Override
	void selectMenu() {
		/*
		 * VO 객체 및 Repository 객체의 동작을 세세히 알필요 없이 repository의 메소드 역할만 인지 하고 있으면 됨!!
		 * 절대!! BoardController 외 타 클래스 확인 금지!!(머리 복잡...)
		 * vo.BoardVO 내 멤버 변수 및 setter, getter 메소드와 같이 DB와 동일한 필드만 셋팅하면
		 * Repository(DAO 와 동일)에서 자동으로 데이터 추출, 등록, 수정, 삭제 처리 가능
		 * Repository 설명
		 * save(VO) VO 객체에서 셋팅 된 데이터 저장
		 * update(VO) VO 객체에서 수정 셋팅 된 데이터 저장
		 * deleteById(일련번호) 일련번호 기준의 데이터 삭제
		 * selectFindById(일련번호) 일련번호 기준의 데이터 검색
		 * selectAll() 각 Repository 내 has a 관계로 셋팅되어인는 각 VO 객체를 활용한 전체 데이터 추출
		 */
		controllerResult = true;		// 컨트롤러 흐름제어 flag 해당 메뉴 종료시만 false 대입 Controller.run() 메소드 내 흐름 종료 
		boardList = null;				// 리스트 형태 데이터 객체
		BoardVO board = null;			// 단일 형태 데이터 객체
		int searchNo = 0;				// 검색, 수정, 삭제 사용 데이터 일련번호
		
		
		boardView.menuSelector();
		switch (boardView.menuCode) {
			case "c":
				board = boardView.write();
				// repository.save 메소드 boardVO 객체 전달로 DB 저장
				boardRepository.save(board);
				break;
			case "r":
				// 검색 일련번호 수집
				searchNo = boardView.search();
				
				// 검색 일련번호 데이터를 조회 후 리스트 형태 단일 데이터 추출
				boardList = boardRepository.selectFindById(searchNo);
				
				board = boardList.get(0);
				board.setReadCount(board.getReadCount() + 1);
				// 증가 된 조회수 업데이트
				boardRepository.update(board);
				
				boardView.searchResult(board);
				break;
			case "l":	
				// 전체 데이터 조회
				boardList = boardRepository.selectAll();
			
				boardView.list(boardList);
				break;
			case "u":
				// 수정 게시글 일련번호 수집
				searchNo = boardView.search();
				
				// 수정 게시글 조회 VO 객체 생성
				boardList = boardRepository.selectFindById(searchNo);
				BoardVO boardVO = boardView.modify(boardList.get(0));
				
				
				// 수정된 데이터 업데이트 처리
				boardView.modifyResult(boardRepository.update(boardVO));
				
				break;
			case "d":
				// 삭제 대상 일련번호 수집
				searchNo = boardView.search();
				// 수집 된 일련번호 삭제
				boardView.deleteResult(boardRepository.deleteById(searchNo));
				break;
			case "e":
				controllerResult = false;
				break;
			default:
				boardView.menuReSelector();
				break;
		}
	}
}
