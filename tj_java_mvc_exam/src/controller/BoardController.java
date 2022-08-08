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
		
		/**
		 * C(Create : 글 작성, insert) 실행 방법
		 * =====================================
		 */
		board = new BoardVO();
		board.setTitle("제목 입니다.");
		board.setContent("내용 입니다.");
		board.setWriter("작성자");
		
		// BoardVO 클래스를 객체화 하여 각 필드(멤버변수)에 setter를 활용하여 값 셋팅
		// boardRepository.save() 메소드내 boardVO를 전달함으로써 insert 문 생성 및 실행
		// boardRepository.save() return 값은 int형으로 정상 등록시 1로 리턴됨
		int boardInsertResult = boardRepository.save(board);
		if (boardInsertResult > 0) {
			System.out.println("글 등록 완료");
			System.out.println("등록 된 글 번호 : " + boardInsertResult);
		}
		else {
			System.out.println("글 등록 실패");
		}
		
		/**
		 * C(Create : 글 작성, insert) 실행 종료
		 * =====================================
		 */
		
		board = new BoardVO(); // 등록에 사용된 VO 객체 초기화
		/**
		 * 특정 일련번호 데이터 검색 방법
		 * =====================================
		 */
		
		// VO 클래스내 INDEXNAME 멤버변수는 일련번호를 가르키는 필드명 멤버변수명과 동일시하여 작성
		// ex) BoardVO.boardId 멤버변수가 DB board.board_id(primary key) 필드를 가르킬 경우
		//     INDEXNAME = "boardId" 로 설정 boardRepository.selectFindById(1) = select * from board where board_id = 1;
		// selectAll() 또는 selectFindById() 와 같이 값을 조회하는 메소드는 ArrayList<VO> 형태로 값 반환
		// 반환 된 VO 객체들은 조회 된 데이터를 담고 있어 getter 메소드를 통해 값 활용 가능
		List<BoardVO> boardSelect = boardRepository.selectFindById(1);
		
		System.out.println("게시글 일련번호 조회 결과 : ======================");
		if (boardSelect.size() > 0) {
			board = boardSelect.get(0);
			board.setReadCount(board.getReadCount() + 1); // 조회 된 게시글 조회 수 수정
			
			boardRepository.update(board); // 수정된 조회수 데이터 업데이트(데이터 업데이트 사용)
			
			System.out.println(String.format("일련번호 : %d\n제목 : %s\n내용 : %s\n작성자 : %s\n조회수 : %d\n등록일 : %s", 
					board.getBoardNo(),				// 조회 된 일련번호 값 추출
					board.getTitle(),				// 조회 된 제목 출력
					board.getContent(),				// 조회 된 내용 출력
					board.getWriter(),				// 조회 된 작성자 출력
					board.getReadCount(),			// 조회 된 조회수 출력
					board.getRegDate()				// 조회 된 등록일 출력
				)
			);
		}
		else {
			System.out.println("조회 결과 없음");
		}
		
		System.out.println("게시글 일련번호 조회 종료 : ======================");
		
		/**
		 * 특정 일련번호 데이터 검색 종료
		 * =====================================
		 */
		
		/**
		 * 전체 데이터 검색 방법
		 * =====================================
		 */
		// selectAll() 메소드는 특별한 조건 없이 전체 데이터를 조회 함으로 특정한 매개변수 전달 없음
		// selectAll() 또는 selectFindById() 와 같이 값을 조회하는 메소드는 ArrayList<VO> 형태로 값 반환
		List<BoardVO> boardList = boardRepository.selectAll();
		System.out.println("게시글 전체 조회 결과 : ======================");
		if (boardSelect.size() > 0) {
			for (BoardVO boardRow : boardList) {
				System.out.println(String.format("일련번호 : %d\n제목 : %s\n내용 : %s\n작성자 : %s\n조회수 : %d\n등록일 : %s", 
						boardRow.getBoardNo(),				// 조회 된 일련번호 값 추출
						boardRow.getTitle(),				// 조회 된 제목 출력
						boardRow.getContent(),				// 조회 된 내용 출력
						boardRow.getWriter(),				// 조회 된 작성자 출력
						boardRow.getReadCount(),			// 조회 된 조회수 출력
						boardRow.getRegDate()				// 조회 된 등록일 출력
					)
				);
			}
		}
		else {
			System.out.println("조회 결과 없음");
		}
		System.out.println("게시글 전체 조회 종료 : ======================");
		/**
		 * 전체 데이터 검색 종료
		 * =====================================
		 */
		
		/**
		 * 특정 데이터 삭제 방법
		 * =====================================
		 */
		int result = boardRepository.deleteById(1);
		if (result > 0) {
			System.out.println("데이터 정상 삭제 완료");
		}
		else {
			System.out.println("데이터 삭제 실패");
		}
		/**
		 * 특정 데이터 삭제 종료
		 * =====================================
		 */
		
		
		controllerResult = false;
	}
}
