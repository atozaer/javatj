package view;

import java.util.ArrayList;
import java.util.List;

import controller.Controller;
import controller.MainController;
import vo.MemberVO;

public class MemberView extends View {

	public MemberView() {
		super("회원번호\t아이디\t이름\t연락처\t가입일", "%d\t%s\t%s\t%s\t%s");
	}

	@Override
	public void menuSelector() {
		System.out.print("(s)회원 검색, (l)회원 리스트");
		if (Controller.sessionNo == null) {
			System.out.print(", (c)회원 가입, (u)로그인");
		}
		else {
			System.out.print(", (d)회원 탈퇴, (m)회원 정보 수정, (o)로그아웃");
		}
		System.out.print(", (e)회원 메뉴 종료\n");
		
		menuCode = MainController.sc.next().toLowerCase();
	}

	@Override
	public void menuReSelector() {
		System.out.printf("메뉴 코드를 확인해 주세요(현재 입력 코드 : %s)\n", menuCode);
	}
	
	public int search() { 
		return getSearchIntMessage("회원 일련 번호");
	}
	
	public void searchResult(List<MemberVO> memberList) {
		showListHeader();// 리스트 헤더 출력
		if (memberList.size() == 0) {
			System.out.println("검색 한 조건의 회원이 존재하지 않습니다.");
		}
		else {
			for (MemberVO member : memberList) {
				System.out.println(String.format(listString,
						member.getMemberNo(),	// 일련번호
						member.getMemberId(),	// 아이디
						member.getMemberName(),	// 이름
						member.getTel(),	// 연락처
						sdf.format(member.getRegDate())	// 가입일
					)
				);
			}
		}
		showListFooter();// 리스트 헤더 출력
	}
	
	public void list(List<MemberVO> memberList) {
		showListHeader();// 리스트 헤더 출력
		if (memberList.size() > 0) {
			for (MemberVO member: memberList) {
				System.out.println(String.format(listString,
						member.getMemberNo(),	// 일련번호
						member.getMemberId(),	// 아이디
						member.getMemberName(),	// 이름
						member.getTel(),	// 연락처
						sdf.format(member.getRegDate())	// 가입일
					)
				);
			}
		}
		else {
			System.out.println("가입 된 회원이 없습니다.");					
		}
		showListFooter(); // 리스트 푸터 출력
	}
	
	public String joinIdInput() {
		System.out.println("가입할 아이디를 입력해 주세요");
		return MainController.sc.next();
	}
	
	public MemberVO join(int result, String id) {
		if (result > 0) {
			System.out.println("해당 계정으로 가입 된 아이디가 존재 합니다.");
			return null;
		} else {
			System.out.println("비밀번호를 입력해 주세요");
			String joinPass = MainController.sc.next();
			System.out.println("이름을 입력해 주세요");
			String joinName = MainController.sc.next();
			System.out.println("연락처를 입력해 주세요");
			String joinTel = MainController.sc.next();
			
			MemberVO joinMember = new MemberVO();
			joinMember.setMemberId(id);
			joinMember.setPassword(joinPass);
			joinMember.setMemberName(joinName);
			joinMember.setTel(joinTel);
			
			return joinMember;
		}
	}
	
	public void joinResult(String msg) {
		System.out.println(msg);
	}
	
	public List<String> login() {
		List<String> loginInfo = new ArrayList<>();
		System.out.println("로그인 아이디를 입력해 주세요");
		loginInfo.add(MainController.sc.next());
		
		System.out.println("로그인 비밀번호를 입력해 주세요");
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
