package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.NewsboardDAO;
import model.vo.NewsboardVO;

public class N_deleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ActionForward forward = null;
		
		NewsboardDAO dao = new NewsboardDAO();
		NewsboardVO vo = new NewsboardVO();
		
		vo.setNnum(Integer.parseInt(req.getParameter("nnum")));
		
		if(dao.n_delete(vo)) {
			
			forward = new ActionForward();
			forward.setPath("newsboard.do");
			forward.setRedirect(false);
			
		}else {
			throw new Exception("공지 글 삭제 중에 문제발생!");
		}
		return forward;
	}

}
