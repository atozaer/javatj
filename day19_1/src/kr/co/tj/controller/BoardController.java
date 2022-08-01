package kr.co.tj.controller;

import java.util.ArrayList;

import kr.co.tj.model.BoardDAO;
import kr.co.tj.model.BoardVO;
import kr.co.tj.view.BoardView;

public class BoardController {
	BoardView view;
	BoardDAO dao;
	
	public BoardController() {
		view = new BoardView();
		dao = new BoardDAO();
	}
	
	public void startApp() {
		while(true) {
			view.clientView();
			if(view.protocol.equals("C")) {//등록
				BoardVO vo = new BoardVO();
				view.action1();
				vo.setTitle(view.action1_A());
				vo.setContent(view.action1_B());
				vo.setAuthor(view.action2());
				vo.setReadcount(view.action3());
				dao.boardInsert(vo);
				view.action4();								
			}//등록
			else if(view.protocol.equals("R")) {//검색
				BoardVO vo = new BoardVO();
				vo.setTitle(view.action5());
				vo=dao.boardOne(vo);
				view.action6(vo);
			}//검색
			else if(view.protocol.equals("U")) {//수정
				
			}//수정
			else if(view.protocol.equals("D")) {//삭제
				BoardVO vo = new BoardVO();
				vo.setTitle(view.action12());
				dao.boardDelete(vo);
				view.action13();
				
			}//삭제
			else if(view.protocol.equals("L")) {//전체출력
				view.action14();
				ArrayList<BoardVO> datas=dao.boardAll();
				view.action15(datas);
			}//전체출력
		}
	}
}
