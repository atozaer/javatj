package controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.NewsboardDAO;
import model.vo.NewsboardVO;

public class NewsAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		NewsboardDAO dao = new NewsboardDAO();
		NewsboardVO vo = new NewsboardVO();
		
		vo.setNnum(Integer.parseInt(req.getParameter("nnum")));
		
		vo = dao.n_selectOne(vo);
		
		req.setAttribute("news", vo);
		
		
		if(vo!=null) {
			forward = new ActionForward();
			forward.setPath("news.jsp");
			forward.setRedirect(false);	
			
		}
		
		return forward;
	}

}
