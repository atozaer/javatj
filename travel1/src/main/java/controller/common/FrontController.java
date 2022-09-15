package controller.common;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.action.A_comment_insertAction;
import controller.action.A_deleteAction;
import controller.action.A_updateAction;
import controller.action.AskAction;
import controller.action.AskBoardAction;
import controller.action.AskWriteAction;
import controller.action.FileDupAction_Ask;
import controller.action.FileDupAction_News;
import controller.action.FileDupAction_Review;
import controller.action.FileDupAction_myPage;
import controller.action.IdCheckAction;
import controller.action.IdSearchAction;
import controller.action.LoginAction;
import controller.action.LogoutAction;
import controller.action.M_deleteAction;
import controller.action.M_photoAction;
import controller.action.M_updateAction;
import controller.action.MainAction;
import controller.action.MemberInfoAction;
import controller.action.MemberListAction;
import controller.action.MyReviewBoardAction;
import controller.action.MypageAction;
import controller.action.N_deleteAction;
import controller.action.N_updateAction;
import controller.action.NewsAction;
import controller.action.NewsBoardAction;
import controller.action.NewsWriteAction;
import controller.action.PwSearchAction;
import controller.action.R_comment_delete;
import controller.action.R_comment_insert;
import controller.action.R_comment_update;
import controller.action.R_comments_selectAll;
import controller.action.R_deleteAction;
import controller.action.R_updateAction;
import controller.action.ReviewAction;
import controller.action.ReviewBoardAction;
import controller.action.ReviewWriteAction;
import controller.action.SearchPageAction;
import controller.action.SignupAction;
import model.dao.MemberDAO;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// 1. 요청 추출하기
		String uri = request.getRequestURI();			// /travel/*.do
		String cp = request.getContextPath();			// /travel
		String command = uri.substring(cp.length());	// /*.do

		// 2. 추출한 요청에 맞는 Action클래스 execute() 호출하기
		ActionForward forward = null;

		if(command.equals("/main.do")) {
			System.out.println("로그 : FC : 메인페이지 출력 요청");
			try {
				forward = new MainAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/idCheck.do")) {
			System.out.println("로그 : FC : 아이디중복체크 페이지 출력 요청");
			try {
				forward = new IdCheckAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/M_photoAction.do")){
			System.out.println("로그 : FC : 사진 파일 업로드 요청");
			try {
				forward = new M_photoAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    


		}else if(command.equals("/FileDupAction_myPage.do")){
			System.out.println("로그 : FC : 마이페이지 사진 파일 업로드 요청");
			try {
				forward = new FileDupAction_myPage().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    


		}else if(command.equals("/FileDupAction_Review.do")){
			System.out.println("로그 : FC : 리뷰게시판 사진 파일 업로드 요청");
			try {
				forward = new FileDupAction_Review().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		else if(command.equals("/FileDupAction_Ask.do")){
			System.out.println("로그 : FC : 문의게시판 사진 파일 업로드 요청");
			try {
				forward = new FileDupAction_Ask().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else if(command.equals("/FileDupAction_News.do")){
		         System.out.println("로그 : FC : 공지사항 파일 업로드 요청");
		         try {
		            forward = new FileDupAction_News().execute(request, response);
		         } catch (Exception e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		         }    


		}else if(command.equals("/signup.do")) {
			System.out.println("로그 : FC : 회원가입 페이지 출력 요청");
			try {
				forward = new SignupAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/m_update.do")) {
			System.out.println("로그 : FC : 회원 정보 변경 요청");
			try {
				forward = new M_updateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/m_delete.do")) {
			System.out.println("로그 : FC : 회원 탈퇴 요청");
			try {
				forward = new M_deleteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/login.do")) {
			System.out.println("로그 : FC : 로그인 요청");
			try {
				forward = new LoginAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/logout.do")) {
			System.out.println("로그 : FC : 로그인 요청");
			try {
				forward = new LogoutAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/idSearch.do")) {
			System.out.println("로그 : FC : 아이디 찾기 페이지 출력 요청");
			try {
				forward = new IdSearchAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/pwSearch.do")) {
			System.out.println("로그 : FC : 비밀번호 찾기 페이지 출력 요청");
			try {
				forward = new PwSearchAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/mypage.do")) {
			System.out.println("로그 : FC : 마이 페이지 출력 요청");
			try {
				forward = new MypageAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/searchPage.do")) { 
			System.out.println("로그 : FC : 검색 출력 요청");
			try {
				forward = new SearchPageAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/myReviewBoard.do")) {
			System.out.println("로그 : FC : 내가 작성한 글 페이지 출력 요청");
			try {
				forward = new MyReviewBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/memberInfo.do")) {
			System.out.println("로그 : FC : 회원 정보 출력 요청");
			try {
				forward = new MemberInfoAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/memberList.do")) {
			System.out.println("로그 : FC : 회원 리스트 출력 요청");
			try {
				forward = new MemberListAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/ask.do")) {
			System.out.println("로그 : FC : 문의 상세보기 요청");
			try {
				forward = new AskAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/askBoard.do")) {
			System.out.println("로그 : FC : 문의 게시판 페이지 출력 요청");
			try {
				forward = new AskBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/askWrite.do")) {
			System.out.println("로그 : FC : 문의 쓰기 요청");
			try {
				forward = new AskWriteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/a_update.do")) {
			System.out.println("로그 : FC : 문의 수정 요청");
			try {
				forward = new A_updateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/a_delete.do")) {
			System.out.println("로그 : FC : 문의 삭제 요청");
			try {
				forward = new A_deleteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/a_comment_insert.do")) {
			System.out.println("로그 : FC : 문의 답글 입력 요청");
			try {
				forward = new A_comment_insertAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/news.do")) {
			System.out.println("로그 : FC : 공지 상세 페이지 출력 요청");
			try {
				forward = new NewsAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/newsBoard.do")) {
			System.out.println("로그 : FC : 공지 게시판 리스트 페이지 출력 요청");
			try {
				forward = new NewsBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/newsWrite.do")) {
			System.out.println("로그 : FC : 공지 쓰기 페이지 출력 요청");
			try {
				forward = new NewsWriteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/n_update.do")) {
			System.out.println("로그 : FC : 공지 수정 요청");
			try {
				forward = new N_updateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/n_delete.do")) {
			System.out.println("로그 : FC : 공지 삭제 요청");
			try {
				forward = new N_deleteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/review.do")) {
			System.out.println("로그 : FC : 리뷰 페이지 출력 요청");
			try {
				forward = new ReviewAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/reviewBoard.do")) {
			System.out.println("로그 : FC : 리뷰 게시판 페이지 출력 요청");
			try {
				forward = new ReviewBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/reviewWrite.do")) {
			System.out.println("로그 : FC : 리뷰 쓰기 페이지 출력 요청");
			try {
				forward = new ReviewWriteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/r_update.do")) {
			System.out.println("로그 : FC : 리뷰 쓰기 페이지 출력 요청");
			try {
				forward = new R_updateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/r_delete.do")) {
			System.out.println("로그 : FC : 리뷰 쓰기 페이지 출력 요청");
			try {
				forward = new R_deleteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/r_comments_selectAll.do")) { 
			System.out.println("로그 : FC : 리뷰 댓글 보기 페이지 출력 요청");
			try {
				forward = new R_comments_selectAll().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/r_comment_insert.do")) {
			System.out.println("로그 : FC : 리뷰 댓글입력 요청");
			try {
				forward = new R_comment_insert().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/r_comment_update.do")) {
			System.out.println("로그 : FC : 리뷰 댓글 수정 요청");
			try {
				forward = new R_comment_update().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/r_comment_delete.do")) { 
			System.out.println("로그 : FC : 리뷰 댓글 삭제 요청");
			try {
				forward = new R_comment_delete().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 3. dispatcher이용해서 응답하기(View 이동)
		if(forward!=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {

				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}

		//		request.setAttribute("flag", "true");
		//		String flag = (String)request.getAttribute("flag");
		//		
		//		System.out.println("컨트롤러"+flag);
		//		
		//		if(flag.equals("true")) {
		//			
		//		PrintWriter out =response.getWriter();
		//		out.println("<script>alert('요청작업 실패!');history.go(-1);</script>");
		//		
		//		}

		// 사용자에게 보여주지 않고 로그로 변환
		System.out.println("요청작업 실패!");




	}

}
