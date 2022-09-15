package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.AskboardDAO;
import model.vo.AskboardVO;

public class A_deleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		AskboardDAO dao = new AskboardDAO();
		AskboardVO vo = new AskboardVO();
		
		vo.setAnum(Integer.parseInt(req.getParameter("anum")));
		
		
		if(dao.a_delete(vo)) {
			
			forward = new ActionForward();
			forward.setPath("askBoard.do");
			forward.setRedirect(false);
		} else {
			throw new Exception("���� ���� �߿� �����߻�!");
		}
		
		return forward;
	}

}
