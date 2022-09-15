package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.ReviewboardDAO;
import model.vo.ReviewboardVO;

public class R_reviewSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward = null;
		
		ReviewboardVO vo = new ReviewboardVO();
		ReviewboardDAO dao = new ReviewboardDAO();
		
		vo.setMid(req.getParameter("mid"));
		
		ArrayList<ReviewboardVO> datas = dao.r_reviewSearch(vo);
		req.setAttribute("Search", datas);
		
		forward = new ActionForward();
		forward.setPath("searchPage.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
