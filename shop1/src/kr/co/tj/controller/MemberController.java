package kr.co.tj.controller;

import kr.co.tj.model.MemberDAO;
import kr.co.tj.model.MemberVO;
import kr.co.tj.model.ProductVO;
import kr.co.tj.view.StartView;

public class MemberController {
	MainController mainController;

	public static boolean session;
	public static String loginID;
	static {
		session = false;
		loginID = null;
	}
	private MemberDAO mDAO; 
	private StartView sView;
	private MemberVO m0_vo, m1_vo; // m0_vo:입력, m1_vo:출력
	private int select;
	
	public MemberController(MainController mainController) {
		mDAO = new MemberDAO();  
		
		sView = new StartView();
		
		m0_vo = new MemberVO();
		m1_vo = new MemberVO();
		
		this.mainController = mainController;
	}
	
	public void start() {
		while(!MainController.exitFlag) {
			select = sView.startView();
			switch(select) {
				case 1: // 로그인
					m0_vo = null; m1_vo = null;
					m0_vo = sView.loginView();
					m1_vo = mDAO.memberSearch(m0_vo.getId()); 
					if(m0_vo.getPasswd().equals(m1_vo.getPasswd())) {
						MemberController.session = true;
						MemberController.loginID = m0_vo.getId();
						mainController.startApp();	// 로그인						
					} else if (m0_vo.getId().equals(m1_vo.getId())){
						sView.loginFailViewA();		// password 틀림					
					} else {
						sView.loginFailViewB();		// ID 틀림
					}
					break;
				case 2: // ID 찾기
					m0_vo = null; m1_vo = null;
					m0_vo = sView.idSearchView();
					m1_vo = mDAO.memberIdSearch(m0_vo); 
					if (m1_vo.getId() != null) {
						sView.idSearchSuccessView(m1_vo);	
					} else{
						sView.idSearchFailView();			
					}	
					break;
				case 3: // 회원가입
					m0_vo = null; m1_vo = null;
					m0_vo = sView.singupViewA();
					m1_vo = mDAO.memberSearch(m0_vo.getId());
					if (m1_vo.getId() != null) {
						sView.signupFailViewA();	
					} else {
						m1_vo = sView.singupViewB();
						m1_vo.setId(m0_vo.getId());
						if(mDAO.memberInsert(m1_vo)) {
							sView.signupSuccessView();
						}else {
							sView.signupFailViewB();
						}
					}
					break;
				case 4: // 쇼핑몰 종료
					sView.endProgram();
					break;
				default:;
			}
		}
	}
	
}
