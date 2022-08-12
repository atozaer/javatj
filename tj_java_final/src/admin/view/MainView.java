package admin.view;

import java.util.ArrayList;
import java.util.List;

import controller.MainController;

public class MainView implements AdminView {
	public List<String> loginInfo() {
		List<String> infoList = new ArrayList<>();
		
		System.out.println("관리자 아이디를 입력해주세요");
		infoList.add(MainController.sc.next());
		System.out.println("비밀번호를 입력해주세요");
		infoList.add(MainController.sc.next());
		
		return infoList;
	}
	
	public String menuSelector() {
		System.out.println("(m)회원 관리, (p)상품 관리, (o)주문 관리, (그외)관리자 로그아웃");
		return MainController.sc.next().toLowerCase();
	}
	
	public void printLoginSucess() {
		System.out.println("관리자모드에 오신걸 환영 합니다.");
	}
	
	public void printLoginFail() {
		System.out.println("로그인에 실패 했습니다.");
	}
	
	public void printAdminPage() {
		System.out.println("관리자 모드 입니다.");
	}
}
