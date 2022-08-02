package kr.co.tj.view;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.tj.model.ProductVO;

public class ProductView {
	Scanner sc = new Scanner(System.in);

	public String inputMenu() {
		System.out.println("로그인할 아이디입력>>>");
		String id = sc.next();
		return id;
	}

	public void printNoMember() {
		System.out.println("해당 아이디는 존재하지 않습니다! 다시 시도해 보세요!");
	}

	public int printMenu() {
		System.out.println("====메뉴====");
		System.out.println("1.상품목록출력");
		System.out.println("2.상품구매");
		System.out.println("3.서비스나가기");
		System.out.print(">>>");
		int act = sc.nextInt();
		return act;
	}

	public void printList(ArrayList<ProductVO> datas) {
		for (ProductVO v : datas) {
			System.out.println(v);
		}
	}

	public int selectPro() {
		System.out.println("구매할 상품번호입력>>>");
		int id = sc.nextInt();
		return id;
	}
	
	public void printPro() {
		System.out.println("상품 구매를 완료하였습니다.");
	}
	
	public void printNoPro() {
		System.out.println("상품구매에 실패했습니다. 잠시후 다시 시도해주세요.");
	}
	
	public void printEnd() {
		System.out.println("이용해 주셔서 감사합니다.");
	}
}
