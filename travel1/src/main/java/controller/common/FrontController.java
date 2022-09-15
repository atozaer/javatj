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
		// 1. ��û �����ϱ�
		String uri = request.getRequestURI();			// /travel/*.do
		String cp = request.getContextPath();			// /travel
		String command = uri.substring(cp.length());	// /*.do

		// 2. ������ ��û�� �´� ActionŬ���� execute() ȣ���ϱ�
		ActionForward forward = null;

		if(command.equals("/main.do")) {
			System.out.println("�α� : FC : ���������� ��� ��û");
			try {
				forward = new MainAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/idCheck.do")) {
			System.out.println("�α� : FC : ���̵��ߺ�üũ ������ ��� ��û");
			try {
				forward = new IdCheckAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/M_photoAction.do")){
			System.out.println("�α� : FC : ���� ���� ���ε� ��û");
			try {
				forward = new M_photoAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    


		}else if(command.equals("/FileDupAction_myPage.do")){
			System.out.println("�α� : FC : ���������� ���� ���� ���ε� ��û");
			try {
				forward = new FileDupAction_myPage().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    


		}else if(command.equals("/FileDupAction_Review.do")){
			System.out.println("�α� : FC : ����Խ��� ���� ���� ���ε� ��û");
			try {
				forward = new FileDupAction_Review().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		else if(command.equals("/FileDupAction_Ask.do")){
			System.out.println("�α� : FC : ���ǰԽ��� ���� ���� ���ε� ��û");
			try {
				forward = new FileDupAction_Ask().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}else if(command.equals("/FileDupAction_News.do")){
		         System.out.println("�α� : FC : �������� ���� ���ε� ��û");
		         try {
		            forward = new FileDupAction_News().execute(request, response);
		         } catch (Exception e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		         }    


		}else if(command.equals("/signup.do")) {
			System.out.println("�α� : FC : ȸ������ ������ ��� ��û");
			try {
				forward = new SignupAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/m_update.do")) {
			System.out.println("�α� : FC : ȸ�� ���� ���� ��û");
			try {
				forward = new M_updateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/m_delete.do")) {
			System.out.println("�α� : FC : ȸ�� Ż�� ��û");
			try {
				forward = new M_deleteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/login.do")) {
			System.out.println("�α� : FC : �α��� ��û");
			try {
				forward = new LoginAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/logout.do")) {
			System.out.println("�α� : FC : �α��� ��û");
			try {
				forward = new LogoutAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/idSearch.do")) {
			System.out.println("�α� : FC : ���̵� ã�� ������ ��� ��û");
			try {
				forward = new IdSearchAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/pwSearch.do")) {
			System.out.println("�α� : FC : ��й�ȣ ã�� ������ ��� ��û");
			try {
				forward = new PwSearchAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/mypage.do")) {
			System.out.println("�α� : FC : ���� ������ ��� ��û");
			try {
				forward = new MypageAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/searchPage.do")) { 
			System.out.println("�α� : FC : �˻� ��� ��û");
			try {
				forward = new SearchPageAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/myReviewBoard.do")) {
			System.out.println("�α� : FC : ���� �ۼ��� �� ������ ��� ��û");
			try {
				forward = new MyReviewBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/memberInfo.do")) {
			System.out.println("�α� : FC : ȸ�� ���� ��� ��û");
			try {
				forward = new MemberInfoAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/memberList.do")) {
			System.out.println("�α� : FC : ȸ�� ����Ʈ ��� ��û");
			try {
				forward = new MemberListAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/ask.do")) {
			System.out.println("�α� : FC : ���� �󼼺��� ��û");
			try {
				forward = new AskAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/askBoard.do")) {
			System.out.println("�α� : FC : ���� �Խ��� ������ ��� ��û");
			try {
				forward = new AskBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/askWrite.do")) {
			System.out.println("�α� : FC : ���� ���� ��û");
			try {
				forward = new AskWriteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/a_update.do")) {
			System.out.println("�α� : FC : ���� ���� ��û");
			try {
				forward = new A_updateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/a_delete.do")) {
			System.out.println("�α� : FC : ���� ���� ��û");
			try {
				forward = new A_deleteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/a_comment_insert.do")) {
			System.out.println("�α� : FC : ���� ��� �Է� ��û");
			try {
				forward = new A_comment_insertAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/news.do")) {
			System.out.println("�α� : FC : ���� �� ������ ��� ��û");
			try {
				forward = new NewsAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/newsBoard.do")) {
			System.out.println("�α� : FC : ���� �Խ��� ����Ʈ ������ ��� ��û");
			try {
				forward = new NewsBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/newsWrite.do")) {
			System.out.println("�α� : FC : ���� ���� ������ ��� ��û");
			try {
				forward = new NewsWriteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/n_update.do")) {
			System.out.println("�α� : FC : ���� ���� ��û");
			try {
				forward = new N_updateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/n_delete.do")) {
			System.out.println("�α� : FC : ���� ���� ��û");
			try {
				forward = new N_deleteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(command.equals("/review.do")) {
			System.out.println("�α� : FC : ���� ������ ��� ��û");
			try {
				forward = new ReviewAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/reviewBoard.do")) {
			System.out.println("�α� : FC : ���� �Խ��� ������ ��� ��û");
			try {
				forward = new ReviewBoardAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/reviewWrite.do")) {
			System.out.println("�α� : FC : ���� ���� ������ ��� ��û");
			try {
				forward = new ReviewWriteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/r_update.do")) {
			System.out.println("�α� : FC : ���� ���� ������ ��� ��û");
			try {
				forward = new R_updateAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/r_delete.do")) {
			System.out.println("�α� : FC : ���� ���� ������ ��� ��û");
			try {
				forward = new R_deleteAction().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/r_comments_selectAll.do")) { 
			System.out.println("�α� : FC : ���� ��� ���� ������ ��� ��û");
			try {
				forward = new R_comments_selectAll().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/r_comment_insert.do")) {
			System.out.println("�α� : FC : ���� ����Է� ��û");
			try {
				forward = new R_comment_insert().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/r_comment_update.do")) {
			System.out.println("�α� : FC : ���� ��� ���� ��û");
			try {
				forward = new R_comment_update().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(command.equals("/r_comment_delete.do")) { 
			System.out.println("�α� : FC : ���� ��� ���� ��û");
			try {
				forward = new R_comment_delete().execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 3. dispatcher�̿��ؼ� �����ϱ�(View �̵�)
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
		//		System.out.println("��Ʈ�ѷ�"+flag);
		//		
		//		if(flag.equals("true")) {
		//			
		//		PrintWriter out =response.getWriter();
		//		out.println("<script>alert('��û�۾� ����!');history.go(-1);</script>");
		//		
		//		}

		// ����ڿ��� �������� �ʰ� �α׷� ��ȯ
		System.out.println("��û�۾� ����!");




	}

}
