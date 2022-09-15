package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.MemberDAO;
import model.vo.MemberVO;

public class M_updateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setMpw(req.getParameter("mpw"));
		vo.setMname(req.getParameter("mname"));
		vo.setMphoto(req.getParameter("mphoto"));
		vo.setMbirth(req.getParameter("mbirth"));
		vo.setMphone(req.getParameter("mphone"));
		vo.setMgender(req.getParameter("mgender"));
		vo.setMmail(req.getParameter("mmail"));
		vo.setMid(req.getParameter("mid"));
		
		if(dao.m_update(vo)) {
			forward = new ActionForward();
			forward.setPath("login.jsp");
			forward.setRedirect(false);
		} else {
			throw new Exception("회원 정보변경 중에 문제발생!");
		}
				
		
		return forward;
	}

}
