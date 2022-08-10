package view;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import controller.MainController;
import vo.MemberVO;

public class MemberView extends View {
	MemberVO member;

	public MemberView() {
		super("번호\t아이디\t\t패스워드\t\t이름\t전화번호\t\t가입일", "%d\t%s\t\t%s\t\t%s\t%s\t%s");
	}

	@Override
	public void menuSelector() {
		if (Controller.sessionNo == null) {
			System.out.printf("(i)로그인 (c)회원가입 (f)아이디찾기 (s)비밀번호찾기 (a)관리자모드 ");
		} else {
			System.out.printf("(o)로그아웃 (p)회원정보 (l)회원목록 (r)회원검색 (m)회원정보수정 (d)회원탈퇴 ");
		}
		System.out.println("(e)회원메뉴종료");

		menuCode = MainController.sc.next().toLowerCase();
	}

	@Override
	public void menuReSelector() {
		System.out.printf("메뉴 코드를 확인해 주세요(현재 입력 코드 : %s)\n", menuCode);
	}

	public MemberVO join() {
		member = new MemberVO();
		System.out.println("==========회원가입==========");
		System.out.print("아이디 : ");
		member.setMemberId(MainController.sc.next());
		System.out.print("이름 : ");
		member.setMemberName(MainController.sc.next());
		System.out.print("비밀번호 : ");
		member.setPassword(MainController.sc.next());
		System.out.print("연락처 : ");
		member.setTel(MainController.sc.next());

		return member;
	}

	public MemberVO joinInfoGet() {
		member = new MemberVO();
		System.out.println("회원 가입 정보 입력");
		System.out.print("아이디 : ");
		member.setMemberId(MainController.sc.next());
		System.out.print("이름 : ");
		member.setMemberName(MainController.sc.next());
		System.out.print("비밀번호 : ");
		member.setPassword(MainController.sc.next());
		System.out.print("연락처 : ");
		member.setTel(MainController.sc.next());

		return member;
	}

	public String[] loginInfoGet() {
		String[] strs = new String[2];
		System.out.println("==========로그인==========");
		System.out.println("아이디 입력 :");
		strs[0] = MainController.sc.next();
		System.out.println("비밀번호 입력 :");
		strs[1] = MainController.sc.next();

		return strs;
	}

	public void loginFail() {
		System.out.println("입력된 회원 정보와 일치하는 회원이 없습니다.\n회원 정보를 다시 한번 확인해 주시기 바랍니다.");
	}

	public String[] searchIdInput() {
		String[] strs = new String[2];
		System.out.println("==========아이디찾기==========");
		System.out.println("찾고자하는 아이디의 이름을 입력해주세요.");
		strs[0] = MainController.sc.next();
		System.out.println("찾고자하는 아이디의 전화번호을 입력해주세요.");
		strs[1] = MainController.sc.next();
		return strs;
	}

	public void searchIdResult(List<MemberVO> memberList) {
		if (memberList.size() > 0) {
			for (MemberVO member : memberList) {
				System.out.printf("%s님의 아이디는 ", member.getMemberName());
				System.out.println(member.getMemberId() + " 입니다.");
			}
		} else {
			System.out.println("검색결과가 없습니다. 다시 입력해주세요.");
		}

	}

	public String resultMsg(String msg) {
		return msg;
	}

	public String[] searchPasswordInput() {
		String[] strs = new String[2];
		System.out.println("==========비밀번호찾기==========");
		System.out.println("비밀번호를 찾고자 하는 아이디를 입력해 주세요.");
		strs[0] = MainController.sc.next();
		System.out.println("비밀번호를 찾고자 하는 아이디의 전화번호를 입력해주세요.");
		strs[1] = MainController.sc.next();
		return strs;
	}

	public void searchPasswordResult(List<MemberVO> memberList) {
		if (memberList.size() > 0) {
			for (MemberVO member : memberList) {
				System.out.printf("%s 아이디의 비밀번호는 ", member.getMemberId());
				System.out.println(member.getPassword() + " 입니다.");
			}
		} else {
			System.out.println("검색결과가 없습니다. 다시 입력해주세요.");
		}
	}

	public void listMember(List<MemberVO> memberList) {
		showListHeader();
		for (MemberVO member : memberList) {
			System.out.println(String.format(listString, 
					member.getMemberNo(), 
					member.getMemberId(),
					member.getPassword(), 
					member.getMemberName(), 
					member.getTel(), 
					member.getRegDate()));
		}
		showListFooter();
	}
}

//
//	public void adminMenuSelector() {
//		if (MainController.sc.equals("admin")) {
//			System.out.printf("==========관리자메뉴==========");
//			System.out.println("(R)회원검색 (L)회원리스트 ( )적립금관리 ( )등급관리");
//			menuCode = MainController.sc.next().toLowerCase();
//		}
//	}
//
//	public int searchNo() {
//		return getSearchIntMessage("회원 일련 번호");
//	}
//
//	public String searchId() {
//		return getSearchStringMessage("회원 아이디");
//	}
//
//	public void searchResult(List<MemberVO> memberList) {
//		showListHeader();// 리스트 헤더 출력
//		if (memberList.size() == 0) {
//			System.out.println("검색 한 조건의 회원이 존재하지 않습니다.");
//		} else {
//			for (MemberVO member : memberList) {
//				System.out.println(String.format(listString, member.getMemberNo(), // 일련번호
//						member.getMemberId(), // 아이디
//						member.getMemberName(), // 이름
//						member.getTel(), // 연락처
//						sdf.format(member.getRegDate()) // 가입일
//				));
//			}
//		}
//		showListFooter();// 리스트 헤더 출력
//	}
//
//	public void list(List<MemberVO> memberList) {
//		showListHeader();// 리스트 헤더 출력
//		if (memberList.size() > 0) {
//			for (MemberVO member : memberList) {
//				System.out.println(String.format(listString, member.getMemberNo(), // 일련번호
//						member.getMemberId(), // 아이디
//						member.getMemberName(), // 이름
//						member.getTel(), // 연락처
//						sdf.format(member.getRegDate()) // 가입일
//				));
//			}
//		} else {
//			System.out.println("가입 된 회원이 없습니다.");
//		}
//		showListFooter(); // 리스트 푸터 출력
//	}
//
//	public String joinIdInput() {
//		System.out.println("가입할 아이디를 입력해 주세요");
//		return MainController.sc.next();
//	}
//
//	public MemberVO join(int result, String id) {
//		if (result > 0) {
//			System.out.println("해당 계정으로 가입 된 아이디가 존재 합니다.");
//			return null;
//		} else {
//			System.out.println("비밀번호를 입력해 주세요");
//			String joinPass = MainController.sc.next();
//			System.out.println("이름을 입력해 주세요");
//			String joinName = MainController.sc.next();
//			System.out.println("연락처를 입력해 주세요");
//			String joinTel = MainController.sc.next();
//
//			MemberVO joinMember = new MemberVO();
//			joinMember.setMemberId(id);
//			joinMember.setPassword(joinPass);
//			joinMember.setMemberName(joinName);
//			joinMember.setTel(joinTel);
//
//			return joinMember;
//		}
//	}
//
//	public void joinResult(String msg) {
//		System.out.println(msg);
//	}
//
//	public List<String> login() {
//		List<String> loginInfo = new ArrayList<>();
//		System.out.println("로그인 아이디를 입력해 주세요");
//		loginInfo.add(MainController.sc.next());
//
//		System.out.println("로그인 비밀번호를 입력해 주세요");
//		loginInfo.add(MainController.sc.next());
//		return loginInfo;
//	}
//
//	public void loginFail() {
//		System.out.println("입력된 회원 정보와 일치하는 회원이 없습니다.\n회원 정보를 다시 한번 확인해 주시기 바랍니다.");
//	}
//
//	public String hackCheck() {
//		System.out.println("정말로 탈퇴하시겠습니까?(y/n)");
//		return MainController.sc.next().toLowerCase();
//	}
//
//	public void hackResult(String msg) {
//		System.out.println(msg);
//	}
//
//	public String passwordCheck() {
//		System.out.println("현재 로그인 계정의 비밀번호를 다시 한번 입력해 주세요");
//		return MainController.sc.next();
//	}
//
//	public MemberVO modify() {
//		System.out.println("수정할 비밀번호를 입력해 주세요");
//		String updatePass = MainController.sc.next();
//		System.out.println("수정할 이름을 입력해 주세요");
//		String updateName = MainController.sc.next();
//		System.out.println("수정할 연락처를 입력해 주세요");
//		String updateTel = MainController.sc.next();
//
//		MemberVO updateMember = new MemberVO();
//		updateMember.setMemberNo(Controller.sessionNo);
//		updateMember.setPassword(updatePass);
//		updateMember.setMemberName(updateName);
//		updateMember.setTel(updateTel);
//
//		return updateMember;
//	}
//
//	public void modifyResult(String msg) {
//		System.out.println(msg);
//	}
