package kr.co.tj.controller;

public class MainController {
	MemberController memberController;
	ProductController productController;
	AdminController adminController;
	public static boolean exitFlag = false; // true:종료, false:계속실행
		
	public MainController() {
		memberController = new MemberController(this);    
		productController = new ProductController(this); 
		adminController = new AdminController(this); 
	}
	
	public void startApp() {
		while(!exitFlag) {
			if (MemberController.session) {
				// session = true면 로그인상태로 이동
				if (MemberController.loginID.equals("admin")) {
					// 로그인 ID가 admin이면 관리자 모드
					adminController.start();
				} else {
					// 회원 로그인 페이지
					productController.start();
				}
			} else {
				// session = false면 회원가입 또는 로그인 이전상태로 이동
				memberController.start();
			}
		}		
	}	
}
