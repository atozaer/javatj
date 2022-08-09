package controller;

import java.util.List;

import repository.MemberRepository;
import view.MemberView;
import vo.BoardVO;
import vo.MemberVO;

public class MemberController extends Controller {
	List<MemberVO> memberList;
	MemberView memberView;
	MemberRepository memberRepository;

	public MemberController() {
		// super 클래스쪽 인자 전달을 통한 리스트 조회에 필요한 타이틀, 내용 출력 포멧 셋
		super("번호\t제목\t내용\t작성자\t조회수\t작성일", "%d\t%s\t%s\t%s\t%d\t%s");
		// 레포지토리(DB 통신을 위한 객체) 셋팅
		memberRepository = new MemberRepository();
		memberView = new MemberView();
	}

	@Override
	void selectMenu() {
		controllerResult = true; // 컨트롤러 흐름제어 flag 해당 메뉴 종료시만 false 대입 Controller.run() 메소드 내 흐름 종료
		memberList = null; // 리스트 형태 데이터 객체
		MemberVO member = null; // 단일 형태 데이터 객체

		controllerResult = false;

		memberView.menuSelector();
		
		switch (memberView.menuCode) {
		case "c": // 회원가입
			
			memberView.join();
			memberRepository.save(member);
			break;
		
		case "i":  //로그인
			String[] loginInfo = new String[2]; 
			loginInfo = memberView.loginInfoGet();
			MemberVO loginMember = memberRepository.loginMember(loginInfo[0],loginInfo[1]);
			Controller.sessionNo = loginMember.getMemberNo();
			Controller.sessionName = loginMember.getMemberName();
			
			if(!loginCheck(false)) {
				
			}else {
				
			}
			break;
		
		
		
		
		
		
		
		
		
		case "e":
			controllerResult = false;
			break;
		default:
			memberView.menuReSelector();
			break;
			
		}
	}
}

//관리자메뉴
//(R) 회원검색 (L) 회원리스트 ()적립금관리 ()등급관리
//
//로그인 전
//(I) 로그인 (C) 회원가입 (F) 비밀번호찾기 (E) 회원메뉴종료
//
//로그인 후
//(O) 로그아웃 (P) 회원정보 (D) 회원탈퇴  (E) 회원메뉴종료
