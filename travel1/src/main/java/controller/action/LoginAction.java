package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.MemberDAO;
import model.vo.MemberVO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setMid(req.getParameter("mid"));
		vo.setMpw(req.getParameter("mpw"));
		
		vo=dao.m_selectOne(vo);
		
		if(vo!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("member", vo);
			
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
			
		}
		else {
			forward = new ActionForward();
			forward.setPath("login.jsp");
			forward.setRedirect(true);
			
		}
		
		return forward;
	}

}
