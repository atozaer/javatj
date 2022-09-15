package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.ReviewboardDAO;
import model.vo.CommentsVO;

public class R_comment_update implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		
		ReviewboardDAO rdao = new ReviewboardDAO();
		CommentsVO cvo = new CommentsVO();
		
		cvo.setCcontent(req.getParameter("ccontent"));
		cvo.setCnum(Integer.parseInt(req.getParameter("ccnum")));
		if(rdao.r_update_comment(cvo)) {
			forward = new ActionForward();
			forward.setPath("review.do");
			forward.setRedirect(false);
		}else {
			throw new Exception("리뷰 댓글 수정 중에 문제발생!");
		}
		
		return forward;
	}

}
