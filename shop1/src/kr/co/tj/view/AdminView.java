package kr.co.tj.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.tj.controller.MemberController;
import kr.co.tj.model.MemberVO;
import kr.co.tj.model.ProductVO;

public class AdminView {
	public int adminLoginView() {
		Scanner scan = new Scanner(System.in);
		int select;
		
		while(true) {
			System.out.println("\n관리자 로그인");
			System.out.println("---------------------------------------------");
			System.out.println("1.상품목록 확인   2.재고 추가   3.상품 추가   4.상품 삭제  5.상품추가(크롤링)");
			System.out.println("6.회원목록 조회   7.회원 검색   8.포인트 추가  9.회원삭제   10.관리자 로그아웃");
			System.out.print("메뉴 선택 : ");
			
			select = scan.nextInt();
			if (select<1 || select>10) {
				System.out.println("잘못 선택하셨습니다.");
				continue;
			} else {
				break;
			}
		}
		return select;
	}
	public void adminListView(ArrayList<ProductVO> datas) {
		System.out.println("==== 상품목록 =====");
		for(ProductVO p_vo:datas) {
			System.out.println(p_vo);
		}
	}
	
	//=======================================================
	//회원관리

	public void memberAllView(ArrayList<MemberVO> datas) {
		System.out.println("회원목록 입니다.");
		for (MemberVO data:datas) {
			System.out.println(data);
		}
	}
	public MemberVO memberSearchView() {
		Scanner scan = new Scanner(System.in);
		MemberVO m_vo = new MemberVO();
		
		System.out.println("회원을 검색합니다.");
		System.out.print("검색할 ID 입력 : ");
		m_vo.setId(scan.next());
		
		return m_vo;
	}
	public void memberSearchSuccessView(MemberVO m_vo) {// 검색된 회원정보 출력을 위해 파라미터 추가
		System.out.println("검색된 회원정보입니다.");
		System.out.println(m_vo);
	}
	public void memberSearchFailView() {
		System.out.println("존재하지 않는 회원ID입니다.");
	}
	public MemberVO memberDeleteView() {
		Scanner scan = new Scanner(System.in);
		MemberVO m_vo = new MemberVO();
		
		System.out.println("회원을 탈퇴시킵니다.");
		System.out.print("탈퇴시킬 ID 입력 : ");
		m_vo.setId(scan.next());
		
		return m_vo;
	}
	public void memberDeleteSuccessView() {
		System.out.println("해당회원을 탈퇴시켰습니다.");		
	}
	public void memberDeleteFailView() {
		System.out.println("회원 탈퇴에 실패했습니다.");		
	}
	// 멤버포인트(admin)
	public MemberVO pointAddView() {
		MemberVO vo = new MemberVO();
		Scanner scan = new Scanner(System.in);
		vo.setPoint(-1);
		
		while(vo.getPoint() < 0) {
			System.out.print("포인트 추가할 회원 ID : ");
			vo.setId(scan.next());
			System.out.println("추가할 포인트 : ");
			vo.setPoint(scan.nextInt());
			if (vo.getPoint() < 0) {
				System.out.println("포인트는 양수만 입력가능합니다.");
			}
		}
		
		return vo;
	}
	public void pointAddSuccessView() {
		System.out.println("포인트가 정상적으로 적립되었습니다.");
	}
	public void pointAddFailView() {
		System.out.println("포인트 적립에 실패하였습니다.");
	}
	
	//=======================================================
	//상품관리
	
	public ProductVO stockAddView() { // 상품 재고 추가
		Scanner scan = new Scanner(System.in);
		ProductVO p_vo = new ProductVO();
		int pstock=0;
		
		System.out.println("상품의 재고를 추가합니다.");
		System.out.print("상품번호 입력 : ");
		p_vo.setPnum(scan.nextInt());
		
		while(pstock<=0) {
			System.out.print("입고수량 입력 : ");
			pstock = scan.nextInt();
			p_vo.setPstock(pstock);
			if(pstock<=0) System.out.println("수량을 다시 입력해주세요!");
		}
		return p_vo;
	}
	public void stockAddSuccessView() {
		System.out.println("상품재고를 추가했습니다.");
	}
	public void stockAddFailView() {
		System.out.println("상품재고 추가를 실패했습니다.");
		System.out.println("상품번호를 확인해주세요.");
	}	
	public ProductVO productAddView() { // 상품 추가
		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ProductVO vo = new ProductVO();
		String pname=null, pinfo=null;		
		int pstock, price;
		
		System.out.print("상품명 입력 : ");
		try {
			pname = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		pname = scan.next(); // BufferedReader로 변경
		System.out.print("상품수량 입력 : ");
		pstock = scan.nextInt();
		System.out.print("상품가격 입력 : ");
		price = scan.nextInt();
		System.out.print("상품 상세정보 입력 : ");
		try {
			pinfo = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}		
//		pinfo = scan.next(); // BufferedReader로 변경
		
		vo.setPname(pname);
		vo.setPstock(pstock);
		vo.setPrice(price);
		vo.setPinfo(pinfo);
		
		return vo;
	}
	public void productAddSuccessView() {
		System.out.println("상품이 추가됐습니다.");

	}
	public void productAddFailView() {
		System.out.println("상품을 추가하지 못했습니다.");
	}
	public ProductVO productDeleteView() {
		Scanner scan = new Scanner(System.in);
		ProductVO vo = new ProductVO();

		System.out.print("삭제할 상품번호 입력 : ");
		vo.setPnum(scan.nextInt());		
		
		return vo;
	}
	public void productDeleteSuccessView() {
		System.out.println("해당상품을 삭제했습니다.");
	}
	public void productDeleteFailView() {
		System.out.println("해당상품을 삭제하지 못했습니다.");
	}
	public void productMassiveAdd() {
		System.out.println("크롤링된 상품을 추가했습니다.");
	}
	public void exitAdmin() {
		System.out.println("관리자 로그아웃");
		MemberController.session = false;
		MemberController.loginID = null;
	}
	public void wrongNum() {
		System.out.println("잘못 선택하셨습니다.");
	}
}
