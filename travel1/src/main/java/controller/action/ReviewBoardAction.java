package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.ReviewboardDAO;
import model.vo.ReviewboardSet;
import model.vo.ReviewboardVO;

public class ReviewBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		
		String a = req.getParameter("a");
		
		ReviewboardVO vo = new ReviewboardVO();
		ReviewboardDAO dao = new ReviewboardDAO();
		vo.setMid(a);
		
		ArrayList<ReviewboardSet> datas = dao.r_selectAll(vo);
		req.setAttribute("reviewList", datas);
		req.setAttribute("a", vo.getMid());
		
		
		forward.setPath("reviewBoard.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
