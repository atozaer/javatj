package controller.action;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.dao.MemberDAO;
import model.vo.MemberVO;

public class IdCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		  ActionForward forward = null;
	      
		  String id = req.getParameter("userId");
			System.out.println("들어온 id : " + id);
			
			MemberVO vo = new MemberVO();
		  MemberDAO dao = new MemberDAO();
		  vo.setMid(id);
		  
		  
			int flag =dao.m_checkId(id);
			
			System.out.println(flag);
			if(flag == 0) {
				System.out.println("중복");
			}else {
				System.out.println("가능");
			}
			PrintWriter out = res.getWriter();
//			req.setAttribute("flag", "false");
			out.write(flag+""); //문자열로 던지기 위해서 +""

	      return forward;
	}

}
