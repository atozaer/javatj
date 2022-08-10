package kr.co.tj.client;

import kr.co.tj.controller.MainController;

public class ShopTest1 {
	public static void main(String[] args) {
		MainController mc = new MainController();		
		mc.startApp();
	}
}

/*=============================================================*\

### Controller ###
 MainController    : 3개의 컨트롤러 관리
 AdminController   : 관리자 모드 관리
 MemberController  : 회원가입,로그인(로그인 이전) 관리
 ProductController : 상품구매,쇼핑머니 충전 등 로그인 이후 관리
 
### View ###
 AdminView    : 관리자 화면
 StartView    : 로그인 이전 화면
 ShoppingView : 로그인 이후(관리자 제외) 모든 화면
 
### 주요객체,변수 ###
 MemberController.session : 로그인상태 제어(static) 
 MemberController.loginID : 로그인 ID 제어(static)
 Maincontroller.exitFlag  : 프로그램 종료처리를 용이하게 하기위해 사용
 
 mDAO : MemberDAO 객체
 pDAO : ProductDAO 객체
 
 aView : AdminView 객체
 pView : ShoppingView 객체
 sView : StartView 객체
 
 * DAO - Controller - View 사이 공유변수
   - 가급적 vo변수를 통해 공유되도록 작성하였음.
   - 입력데이터와 출력데이터를 파악하기 용이하도록 입출력 변수를 분리
   m0_vo : MemberVO 입력값
   m1_vo : MemberVO 출력값
   p0_vo : ProductVO 입력값
   p1_vo : PdoductVO 출력값
   -> mo_vo, p0_vo 하나만 있는 경우는 입력값 또는 출력값만 있는 경우임(주로 입력값)
   
 * ProductController 변수
   basket : 장바구니 -> 로그인 상태에서는 계속 유지되나, 로그아웃하면 삭제됨.
   items : 쇼핑목록 -> 쿼리(DAO)를 사용하지 않기 위해 사용, DAO를 사용해도 상관없음(개인취향 =_=)
   
 * ProductController에서 장바구니추가, 장바구니구매는 코드가 길어서 별도의 메서드로 작성
   purchaseItems : 장바구니 목록 구매
   addItems : 장바구니에 추가
   
 * ProductDAO의 basketAdd()메서드(장바구니에 추가)는 현재 쿼리를 사용하지 않으므로
   DAO파트보다는 Controller파트에 들어가는 것이 합당하나,
   이후의 작업에서 DB에 장바구니를 생성할 것을 고려하여 DAO에 포함시킴.

 * 쇼핑머니 적립/차감, 포인트 적립/차감 관련 쿼리는 동일한 구조에 값만 양수/음수이므로
   각각 한개의 DAO만을 작성하고 Controller에서 대입값이 (-)를 붙여 사용함
   - MemberMoneyAdd(),MemberMoneyAddMinus() -> MemberMoenyUpdate()
   - MemberPointAdd(),MemberPointMinus() -> MemberPointUpdate()
   
 * 프로그램의 기본흐름은 참고예시 pptx파일 참조

 * 파트별 DAO, View는 UML다이어그램 참조

 * 메서드, 파라미터, 반환값이 가이드(UML)와 다른경우는 각 메서드의 주석 참고

\*=============================================================*/