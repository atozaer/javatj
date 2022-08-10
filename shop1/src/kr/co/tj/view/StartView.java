package kr.co.tj.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import kr.co.tj.controller.MainController;
import kr.co.tj.controller.MemberController;
import kr.co.tj.model.MemberVO;

public class StartView {
	public int startView() {
		Scanner scan = new Scanner(System.in);
		int select;
		
		while(true) {
			System.out.println("===========================================");
			System.out.println("1:로그인  2:아이디 찾기  3:회원가입  4:쇼핑몰 종료");
			System.out.print("메뉴 선택 : ");
			select = scan.nextInt();
			if (select<1 || select>4) {
				System.out.println("잘못 선택하셨습니다.");
				continue;
			} else {			
				break;
			}
		}
		
		return select;
	}
	
	// 로그인
	public MemberVO loginView() { // ID,PW를 동시에 전달하기 위해 반환값을 MemberVO로 변경
		Scanner scan = new Scanner(System.in);
		MemberVO m_vo = new MemberVO();
		
		System.out.print("ID 입력 : ");
		m_vo.setId(scan.next());
		System.out.print("password 입력 : ");
		m_vo.setPasswd(scan.next());
		
		return m_vo;
	}
	
	public int loginSuccessView(int myMoney, int myPoint) { // 로그인 후 선택사항을 전달하기 위해 반환값을 int로 변경
		Scanner scan = new Scanner(System.in);
		int select;
		
		while(true) {
			System.out.println("===================================================");
			System.out.println("접속계정 : "+MemberController.loginID+"  | 보유금액:"
								+ myMoney+"원 | 보유포인트:" + myPoint+"p");
			System.out.println("===================================================");
			System.out.println("1:상품목록 보기   2:쇼핑머니 충전   3:장바구니 보기   4:로그아웃");
			System.out.print("메뉴 선택 : ");
			select = scan.nextInt();
			
			if (select<0 || select>4) {
				System.out.println("잘못 선택하셨습니다.");
				continue;
			} else {
				break;
			}
		}
		
		return select;
	}
	
	public void loginFailViewA() { // 로그인실패 사유를 세분화 : ID
		System.out.println("password가 틀렸습니다.");
	}
	
	public void loginFailViewB() { // 로그인실패 사유를 세분화 : PW
		System.out.println("존재하지 않는 ID입니다.");
	}
	
	// 아이디 찾기
	public MemberVO idSearchView(){
		Scanner scan = new Scanner(System.in);
		MemberVO m_vo = new MemberVO();
		
		System.out.println("### ID 찾기 ###");
		System.out.print("이름 입력 : ");
		m_vo.setName(scan.next());
		System.out.print("생년월일 입력(YYYYMMDD) : ");
		m_vo.setBirth(scan.nextInt());
		
		return m_vo;
	}
	
	public void idSearchSuccessView(MemberVO m_vo){
		System.out.println("가입하신 ID는 "+m_vo.getId()+"입니다.");
	}
	
	public void idSearchFailView() {
		System.out.println("가입정보를 찾을 수 없습니다.");		
	}
	
	// 회원가입
	public MemberVO singupViewA() { // ID중복여부 확인부터 처리하기 위해 세분화, controller간소화를 위해 반환값을 VO로 변경
		Scanner scan = new Scanner(System.in);
		MemberVO m_vo = new MemberVO();
		
		System.out.println("### 회원가입 ###");
		System.out.print("ID 입력 : ");
		m_vo.setId(scan.next());
		
		return m_vo;
	}
	
	public MemberVO singupViewB() { // 나머지 정보 입력
		Scanner scan = new Scanner(System.in);
		MemberVO m_vo = new MemberVO();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate formattedBirth;
		String inputBirth=null;
		int birth = 0;
		
		System.out.print("패스워드 입력 : ");
		m_vo.setPasswd(scan.next());
		System.out.print("이름 입력 : ");
		m_vo.setName(scan.next());
		System.out.print("주소 입력 : ");		
		try {
			m_vo.setAddr(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
//		m_vo.setAddr(scan.next());
		System.out.print("전화번호 입력 : ");
		m_vo.setTel(scan.next());
		
		while(true) {
			System.out.print("생일 입력(YYYYMMDD) : ");
			inputBirth = scan.next();
			try {
				formattedBirth = LocalDate.parse(inputBirth, formatter);
				birth = Integer.parseInt(formatter.format(formattedBirth));
				m_vo.setBirth(birth);
			} catch (Exception e) {
				//e.printStackTrace();
				System.out.println("날짜 입력 에러 : 형식에 맞춰 입력해주세요(YYYYMMDD)");
				continue;
			}
			if (String.valueOf(birth).equals(inputBirth)) {
				break; // 날짜형식 맞음
			} else {
				System.out.println("날짜 입력 에러 : 형식에 맞춰 입력해주세요(YYYYMMDD)");		
			}
		}				
//		m_vo.setBirth(scan.nextInt());

		return m_vo;
	}
	
	public void signupSuccessView() {
		System.out.println("회원가입 되었습니다!");
	}
	
	public void signupFailViewA() { // 회원가입 실패사유 세분화 : ID중복
		System.out.println("중복된 ID입니다.");		
	}
	
	public void signupFailViewB() { // 회원가입 실패사유 세분화 : 회원가입 쿼리 실패
		System.out.println("회원가입에 실패했습니다. 다시 가입해주세요.");		
	}
	
	// 회원정보 조회
	public void memberInfoView(MemberVO m_vo) {
		System.out.println(m_vo.getId()+"회원님의 가입정보입니다.");
		System.out.println(m_vo);
	}
	
	// 쇼핑몰 종료
	public void endProgram() {
		System.out.println("쇼핑몰을 종료합니다.");	
		MainController.exitFlag = true;
	}
}
