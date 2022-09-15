package controller.action;

// 완료

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.MemberDAO;
import model.vo.MemberVO;

public class SignupAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setMid(req.getParameter("mid"));
		vo.setMpw(req.getParameter("mpw"));
		vo.setMname(req.getParameter("mname"));
		vo.setMbirth(req.getParameter("mbirth"));
		vo.setMphone(req.getParameter("mphone"));
		vo.setMgender(req.getParameter("mgender"));
		vo.setMmail(req.getParameter("mmail"));
		
		if(dao.m_insert(vo)) {
			forward = new ActionForward();
			forward.setPath("login.jsp");
			forward.setRedirect(false);			
		} else {
			throw new Exception("회원 가입 중에 문제발생!");
		}
		
		
		return forward;
	}

}
