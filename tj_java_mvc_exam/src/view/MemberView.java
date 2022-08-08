package view;

import controller.MainController;
import vo.MemberVO;

public class MemberView extends View {
	MemberVO member;
	
	public MemberView() {
		super("회원번호\t아이디\t이름\t전화번호\t가입일", "%d\t%s\t%s\t%s\t%s");
	}

	@Override
	public void menuSelector() {
		System.out.println("(r)회원검색 (l)회원리스트 (c)회원가입 (f)비밀번호찾기 (i)로그인 (e)회원메뉴종료");
		menuCode = MainController.sc.next().toLowerCase();
	}

	@Override
	public void menuReSelector() {
		System.out.printf("메뉴 코드를 확인해 주세요(현재 입력 코드 : %s)\n", menuCode);
	}

	public MemberVO registMember() {//회원가입
		member = new MemberVO();
		System.out.println("========회원가입========");
		System.out.println("아이디 입력:");
		String memberId = MainController.sc.next();
		System.out.println("패스워드 입력:");
		String password = MainController.sc.next();
		System.out.println("이름 입력:");
		String memberName = MainController.sc.next();
		System.out.println("전화번호 입력:");
		String tel = MainController.sc.next();
		
		return member;
	}
	
	public int search() {
		return getSearchIntMessage("회원 일련번호");
	}
	
	
}
