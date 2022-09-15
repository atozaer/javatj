package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.AskboardDAO;
import model.vo.AskboardSet;
import model.vo.AskboardVO;

public class AskBoardAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = new ActionForward();
		
		AskboardVO vo = new AskboardVO();
		AskboardDAO dao = new AskboardDAO();
		
		ArrayList<AskboardSet> datas = dao.a_selectAll();
		req.setAttribute("ask", datas);
		
		
		forward.setPath("askBoard.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
