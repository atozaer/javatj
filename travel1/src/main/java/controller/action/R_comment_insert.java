package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.ReviewboardDAO;
import model.vo.CommentsVO;
import model.vo.ReviewboardVO;

public class R_comment_insert implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		
		ReviewboardVO rvo = new ReviewboardVO();
		ReviewboardDAO rdao = new ReviewboardDAO();
		CommentsVO cvo = new CommentsVO();
		
		cvo.setRnum(Integer.parseInt(req.getParameter("rnum")));
		cvo.setMid(req.getParameter("mid"));
		cvo.setCcontent(req.getParameter("ccontent"));
		cvo.setCthumbsup(Float.valueOf(req.getParameter("cthumbsup")));
						
		if(rdao.r_insert_comment(cvo)) {
			forward = new ActionForward();
			forward.setPath("review.do");
			forward.setRedirect(false);
		}else {
			throw new Exception("리뷰 댓글 작성 중에 문제발생!");
		}
		
		return forward;
	}

}
