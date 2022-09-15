package controller.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.ReviewboardDAO;
import model.vo.ReviewboardVO;

public class SearchPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		ActionForward forward = null;
		
		ReviewboardVO vo = new ReviewboardVO();
		ReviewboardDAO dao = new ReviewboardDAO();
		
		ArrayList<ReviewboardVO> datas = null;
		
		String str = req.getParameter("keyword");
		
		System.out.println(str);
		
		if(str.equals("rtitle")) {

			vo.setRtitle(req.getParameter("query"));
			datas = dao.r_placeSearch(vo);
			System.out.println("제목으로 검색했습니다.");

		}

		else if(str.equals("mid")) {

			vo.setMid(req.getParameter("query"));

			datas = dao.r_reviewSearch(vo);
			System.out.println("작성자로 검색했습니다.");
			
		}
		
		req.setAttribute("Search", datas);
		
		System.out.println(datas);
		
		
		forward = new ActionForward();
		forward.setPath("searchPage.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
