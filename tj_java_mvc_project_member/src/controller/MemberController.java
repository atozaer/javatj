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
		super("회원번호\t아이디\t패스워드\t이름\t전화번호\t작성일", "%d\t%s\t%s\t%s\t%d\t%s");
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
			if (!loginCheck(false)) {
				break;
			}
			member = memberView.join();
			int joinResult = memberRepository.save(member);

			if (joinResult > 0) {
				System.out.println("회원가입 성공");
			} else {
				System.out.println("회원가입 실패");
			}
			break;

		case "i": // 로그인
			if (!loginCheck(false)) {
				break;
			}

			String[] loginInfo = new String[2];
			loginInfo = memberView.loginInfoGet();
			MemberVO loginMember = memberRepository.loginMember(loginInfo[0], loginInfo[1]);
			while (true) {
				if (loginMember == null) {
					memberView.loginFail();
					continue;
				} else {
					Controller.sessionNo = loginMember.getMemberNo();
					Controller.sessionName = loginMember.getMemberName();
					System.out.println("로그인성공");
					break;
				}
			}
			break;
		case "f":// 아이디찾기
			if (!loginCheck(false)) {
				break;
			}

			String[] searchId = memberView.searchIdInput();

			memberList = memberRepository.selectMemberNameTel(searchId[0], searchId[1]);

			memberView.searchIdResult(memberList);

			break;
			

		case "s":// 비밀번호찾기
			if (!loginCheck(false)) {
				break;
			}

			String[] searchPassword = memberView.searchPasswordInput();

			memberList = memberRepository.selectMemberIdTel(searchPassword[0], searchPassword[1]);

			memberView.searchPasswordResult(memberList);

			break;
		case "o":// 로그아웃
			if (!loginCheck(true))
				break;
			sessionNo = null;
			sessionName = null;
			memberView.resultMsg("로그아웃되었습니다.");
			break;
		case "p":// 회원정보
			if (!loginCheck(true))
				break;

		case "l":// 회원목록
			memberList = memberRepository.selectAll();
			memberView.listMember(memberList);
			break;
		case "r":// 회원검색

			int searchMemberNo = memberView.searchNo();

			memberList = memberRepository.selectFindById(searchMemberNo);

			memberView.searchMemberNo(memberList);

			break;
		case "m"://회원정보 수정
			if (!loginCheck(true))
				break;
			while (true) {
				String passwordCheck = memberView.passwordCheck();
				member = memberRepository.selectModifyMember(sessionNo, passwordCheck);
				if (member == null) {
					continue;
				} else {
					int resultNo = memberRepository.update(memberView.modifyMember(member));
					if (resultNo > 0) {
						memberView.resultMsg("정상적으로 정보가 수정 되었습니다.");
					} else {
						memberView.resultMsg("정보 수정에 실패했습니다.");
						continue;
					}
					break;
				}
			}
			break;
		case "d":// 회원탈퇴
			if (!loginCheck(true))
				break;
			if(memberView.deleteCheck().toLowerCase().equals("y")) {
				String passwordCheck = memberView.passwordCheck();
				int result = memberRepository.deleteMember(sessionNo, passwordCheck);
				
				if(result > 0) {
					memberView.resultMsg("회원탈퇴완료");
					sessionNo = null;
					sessionName = null;
					break;
				}else {
					memberView.resultMsg("비밀번호가 일치하지 않습니다. \n다시 입력해주세요.");
				}
			}else {
				System.out.println("회원탈퇴취소");
				break;
			}
			
			
			break;
		case "e":// 회원메뉴종료
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
