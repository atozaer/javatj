package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.ReviewboardDAO;
import model.vo.ReviewboardSet;
import model.vo.ReviewboardVO;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		ReviewboardVO vo = new ReviewboardVO();
		ReviewboardDAO dao = new ReviewboardDAO();
		
		ArrayList<ReviewboardSet> datas = dao.r_selectAll(vo);
		req.setAttribute("mainreview", datas);
		
		
		
		forward = new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}
