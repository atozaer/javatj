package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.ReviewboardDAO;
import model.vo.ReviewboardSet;
import model.vo.ReviewboardVO;

public class ReviewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		ReviewboardVO vo = new ReviewboardVO();
		ReviewboardDAO dao = new ReviewboardDAO();
		
		vo.setRnum(Integer.parseInt(req.getParameter("rnum")));
		ArrayList<ReviewboardSet> datas = dao.r_selectOne(vo);
		
		System.out.println("ReviewAction로그:"+datas);
		
		if(vo!=null) {			
			req.setAttribute("review", datas);
			forward = new ActionForward();
			forward.setPath("review.jsp");
			forward.setRedirect(false);
		}
		
		return forward;
	}

}
