package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.ReviewboardDAO;
import model.vo.ReviewboardVO;

public class R_deleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward = null;
		
		ReviewboardVO vo = new ReviewboardVO();
		ReviewboardDAO dao = new ReviewboardDAO();
		
		vo.setRnum(Integer.parseInt(req.getParameter("rnum")));
		
		if(dao.r_delete(vo)) {
			forward = new ActionForward();
			forward.setPath("reviewBoard.do");
			forward.setRedirect(false);
		}else {
			throw new Exception("리뷰 글 삭제 중에 문제발생!");
		}
		
		return forward;
	}

}
