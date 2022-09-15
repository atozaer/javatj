package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.MemberDAO;
import model.vo.MemberVO;

public class MypageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setMid(req.getParameter("mid"));
		vo.setMpw(req.getParameter("mpw"));
		
		vo = dao.m_selectOne(vo);
		System.out.println(vo);
		if(vo!=null) {
			
			
			forward = new ActionForward();
			forward.setPath("myPage.jsp");
			forward.setRedirect(false);
		}
		
		
		
		return forward;
	}

}
