package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.NewsboardDAO;
import model.vo.NewsboardVO;

public class NewsBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		
		NewsboardDAO dao = new NewsboardDAO();
		NewsboardVO vo = new NewsboardVO();
		
		ArrayList<NewsboardVO> datas = dao.n_selectAll();
		req.setAttribute("news", datas);
		
		
		forward.setPath("newsBoard.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
