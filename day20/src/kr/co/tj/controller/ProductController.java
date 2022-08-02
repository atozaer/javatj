package kr.co.tj.controller;

import java.util.ArrayList;
import java.util.Random;

import kr.co.tj.model.MemberDAO;
import kr.co.tj.model.MemberVO;
import kr.co.tj.model.ProductDAO;
import kr.co.tj.model.ProductVO;
import kr.co.tj.view.ProductView;

public class ProductController {
	MemberDAO memberDao;
	ProductDAO productDao;
	ProductView view;

	public ProductController() {
		memberDao = new MemberDAO();
		productDao = new ProductDAO();
		view = new ProductView();
	}

	public void startApp() {
		while (true) {
			String memberid = view.inputMenu();
			MemberVO memberVO = new MemberVO();
			memberVO.setId(memberid);
			memberVO = memberDao.selectOne(memberVO);
			if (memberVO == null) {
				view.printNoMember();
				continue;
			}
			// 로그인성공!
			while (true) {
				int act = view.printMenu();
				if (act == 1) {
					ProductVO productVO = new ProductVO();
					ArrayList<ProductVO> datas = productDao.selectAll(productVO);
					view.printList(datas);
				} else if (act == 2) {
					int productId = view.selectPro();
					ProductVO productVO = new ProductVO();
					productVO.setId(productId);
					if (!productDao.update(productVO)) {
						// 구매실패
						view.printNoPro();
						continue;
					}
					// 구매성공
					memberVO.setPoint(new Random().nextInt(10) + 1);// +)product select
					// 가격에 따른 포인트 추가로직
					if (memberDao.update(memberVO)) { // ★★★★★ 변수의 유효범위, scope ★★★★★
						System.out.println("로그 성공");
					} else {
						System.out.println("로그 실패");
					}
				} else if (act == 3) {
					view.printEnd();
					break;
				}
			}

		}
	}
}
