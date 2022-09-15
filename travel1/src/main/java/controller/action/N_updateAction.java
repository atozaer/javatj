package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.NewsboardDAO;
import model.vo.NewsboardVO;

public class N_updateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		NewsboardDAO dao = new NewsboardDAO();
		NewsboardVO vo = new NewsboardVO();
		
		vo.setNtitle(req.getParameter("ntitle"));
		vo.setNcontent(req.getParameter("ncontent"));
		vo.setNdate(req.getParameter("ndate"));
		vo.setNphoto(req.getParameter("nphoto"));
		
		if(dao.n_update(vo)) {
			forward = new ActionForward();
			forward.setPath("newsboard.do");
			forward.setRedirect(false);
		} else {
			throw new Exception("공지 글 수정 중에 문제발생!");
		}
		
		return forward;
	}

}
