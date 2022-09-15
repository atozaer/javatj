package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.AskboardDAO;
import model.vo.AskboardVO;

public class A_updateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward = null;
		
		AskboardDAO dao = new AskboardDAO();
		AskboardVO vo = new AskboardVO();
		
		vo.setAtitle(req.getParameter("atitle"));
		vo.setAcontent(req.getParameter("acontent"));
		vo.setAnum(Integer.parseInt(req.getParameter("anum")));
		
		if(dao.a_update(vo)) {
			
			forward = new ActionForward();
			forward.setPath("askBoard.do");
			forward.setRedirect(false);
			
		} else {
			throw new Exception("문의 수정 중에 문제발생!");
		}
		
		
		return forward;
	}

}
