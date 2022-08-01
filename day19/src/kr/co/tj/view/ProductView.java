package kr.co.tj.view;

import java.util.ArrayList;
import java.util.Scanner;

import kr.co.tj.model.ProductVO;

public class ProductView {
	Scanner sc = new Scanner(System.in);

	public int act; // private+getter,setter

	public void clientView() {
		System.out.println("1.목록");
		System.out.println("2.상품구매");
		System.out.println("3.프로그램종료");
		System.out.println(">>>");
		act = sc.nextInt();
	}

	public void adminView() {
		System.out.println("1.상품제고추가");
		System.out.println("2.관리자모드종료");
		System.out.println(">>>");
		act = sc.nextInt();
	}

	public void action1(ArrayList<ProductVO> datas) {
		System.out.println("===========상품목록 페이지===========");
		for (ProductVO vo : datas) {
			System.out.println(vo);
		}
	}

	public void action2() {
		System.out.println("구매할상품번호입력>>>");
		act = sc.nextInt();
	}

	public void action2_A() {
		System.out.println("=====구매완료 페이지=====");
	}

	public void action2_B() {
		System.out.println("=====구매실패 페이지=====");
	}

	public void action3() {
		System.out.println("프로그램이 종료됩니다.....");
	}

	public ProductVO action4() {
		ProductVO vo = new ProductVO();
		System.out.println("재고를 추가할 상품번호 입력 >>>");
		int pid = sc.nextInt();
		System.out.println("얼만큼추가할까요???");
		int cnt = sc.nextInt();
		vo.setCnt(cnt);
		vo.setPid(pid);
		return vo;
	}

	public void action4_A() {
		System.out.println("=====재고추가완료 페이지=====");
	}

	public void action4_B() {
		System.out.println("=====재고추가실패 페이지=====");
	}

	public void action5() {
		System.out.println("관리자모드가 종료됩니다.");
	}

}
