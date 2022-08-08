package view;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import controller.MainController;
import vo.MemberVO;

public class MemberView extends View {
	MemberVO member;

	public MemberView() {
		super("번호\t아이디\t패스워드\t이름\t전화번호\t가입일", "%d\t%s\t%s\t%s\t%d\t%s");
	}

	@Override
	public void menuSelector() {
		if (Controller.sessionNo == null) {
			System.out.printf("(i)로그인 (c)회원가입 (f)아이디찾기 (s)비밀번호찾기 (a)관리자모드 ");
		} else {
			System.out.printf("(o)로그아웃 (p)회원정보 (d)회원탈퇴 ");
		}
		System.out.println("(e)회원메뉴종료");
		menuCode = MainController.sc.next().toLowerCase();
	}

	@Override
	public void menuReSelector() {
		System.out.printf("메뉴 코드를 확인해 주세요(현재 입력 코드 : %s)\n", menuCode);
	}

	public int searchNo() {
		System.out.println("찾을 회원 일련번호:");
		int searchNo = MainController.sc.nextInt();
		return searchNo;
	}

	public String searchId() {
		System.out.println("찾을 회원 아이디:");
		String searchId = MainController.sc.next();
		return searchId;
	}

	public void searchResult(List<MemberVO> memberList) {
		if (memberList.size() == 0) {
			System.out.println("검색 한 조건의 회원이 존재하지 않습니다.");
		} else {
			for (MemberVO member : memberList) {
				System.out.println(String.format(listString, member.getMemberNo(), // 일련번호
						member.getMemberId(), // 아이디
						member.getMemberName(), // 이름
						member.getTel(), // 연락처
						sdf.format(member.getRegDate()) // 가입일
				));
			}
		}
	}

	public void list(List<MemberVO> memberList) {
		if (memberList.size() > 0) {
			for (MemberVO member : memberList) {
				System.out.println(String.format(listString, member.getMemberNo(), // 일련번호
						member.getMemberId(), // 아이디
						member.getMemberName(), // 이름
						member.getTel(), // 연락처
						sdf.format(member.getRegDate()) // 가입일
				));
			}
		} else {
			System.out.println("가입 된 회원이 없습니다.");
		}
	}

	public String registIdInput() {// 회원가입 시 아이디 입력
		System.out.println("가입할 아이디 입력:");
		return MainController.sc.next();
	}

	public MemberVO registMember(int result, String id) {
		if (result > 0) {
			System.out.println("아이디가 중복됩니다. 다시 입력해주세요.");
			return null;
		} else {
			System.out.println("비밀번호를 입력해 주세요");
			String registPass = MainController.sc.next();
			System.out.println("이름을 입력해 주세요");
			String registName = MainController.sc.next();
			System.out.println("연락처를 입력해 주세요");
			String registTel = MainController.sc.next();

			MemberVO registMember = new MemberVO();
			registMember.setMemberId(id);
			registMember.setPassword(registPass);
			registMember.setMemberName(registName);
			registMember.setTel(registTel);

			return registMember;
		}
	}

	public void registResult(String msg) {
		System.out.println(msg);
	}

	public List<String> login() {
		List<String> loginInfo = new ArrayList<>();
		System.out.println("로그인 아이디 입력:");
		loginInfo.add(MainController.sc.next());
		System.out.println("로그인 패스워드 입력:");
		loginInfo.add(MainController.sc.next());

		return loginInfo;
	}

	public void loginFail() {
		System.out.println("입력된 회원 정보와 일치하는 회원이 없습니다.\n회원 정보를 다시 한번 확인해 주시기 바랍니다.");
	}

	public String hackCheck() {
		System.out.println("정말로 탈퇴하시겠습니까?(y/n)");
		return MainController.sc.next().toLowerCase();
	}

	public void hackResult(String msg) {
		System.out.println(msg);
	}

	public String passwordCheck() {
		System.out.println("현재 로그인 계정의 비밀번호를 다시 한번 입력해 주세요");
		return MainController.sc.next();
	}

	public MemberVO modify() {
		System.out.println("비밀번호를 입력해 주세요");
		String updatePass = MainController.sc.next();
		System.out.println("이름을 입력해 주세요");
		String updateName = MainController.sc.next();
		System.out.println("연락처를 입력해 주세요");
		String updateTel = MainController.sc.next();

		MemberVO updateMember = new MemberVO();
		updateMember.setMemberNo(Controller.sessionNo);
		updateMember.setPassword(updatePass);
		updateMember.setMemberName(updateName);
		updateMember.setTel(updateTel);

		return updateMember;
	}

	public void modifyResult(String msg) {
		System.out.println(msg);
	}

}
